package com.infoway;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.infoway.Dao.AddQuestionDao;
import com.infoway.Dao.AddQuestionDaoImpl;
import com.model.AddQuestion;
import com.model.MCQ;
 
public class FileBrowse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private final String UPLOAD_DIRECTORY = "C:/uploads";
 
    public FileBrowse() {
        super(); 
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		//......CAUTION......
		//POJO CHANGE KELA AHE.....AddQuestion to MCQ
		
		
		//process only if its multipart content
		//String fileName=request.getParameter("upload1");
	//	String fileName = request.getParameter("majhifile");
		//String fileName1 = (String) request.getAttribute("filename");
		//System.out.println(fileName1);
		
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload( new DiskFileItemFactory()).parseRequest(request);
                String name=null;
               // String tryname = null;
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                         name = new File(item.getName()).getName();
                       //  tryname = (UPLOAD_DIRECTORY + File.separator + File.separator + name);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                System.out.println(name);
             //   System.out.println(tryname);
               // File fs = new File("C:/uploads");
               // String fileName2 = fs.getAbsolutePath();
               // System.out.println(fileName2);
                FileInputStream fis = new FileInputStream("C:/uploads/"+name);
                
             // Finds the workbook instance for XLSX file
                XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
               
                // Return first sheet from the XLSX workbook
                XSSFSheet mySheet = myWorkBook.getSheetAt(0);
               
                // Get iterator to all the rows in current sheet
             //   Iterator<Row> rowIterator = mySheet.iterator();
                
                ArrayList<MCQ> lMcq=new ArrayList<>();
                
            //    DataFormatter formatter = new DataFormatter();
                //I've Header and I'm ignoring header for that I've +1 in loop
                          for(int i=mySheet.getFirstRowNum();i<=mySheet.getLastRowNum();i++){
                        	  MCQ mcq=new MCQ();
                        	  if(mcq.getQuestion()==null)
                  				mcq.setQuestion(new StringBuffer());
                  			
                              Row ro=mySheet.getRow(i);
                              
                              for(int j=ro.getFirstCellNum()+1;j<=ro.getLastCellNum()-1;j++){
                            	  
                                  Cell ce = ro.getCell(j);
                                  
                                if(j==1){
                                	mcq.getQuestion().append(ce.getStringCellValue());
                                	//mcq.setQuestion(ce.getStringCellValue());
                                    
                                }
                                if(j==2){
                                	mcq.setA(ce.getStringCellValue());
                                }
                                if(j==3) {
                                	mcq.setB(ce.getStringCellValue());
                                }
                                if(j==4) {
                                	mcq.setC(ce.getStringCellValue());
                                }
                                if(j==5) {
                                	mcq.setD(ce.getStringCellValue());
                                }
                                
                                if(j==6) {
                                	mcq.setAns(ce.getStringCellValue());
                                }
                                
                              }
                             if(mcq.getAns()!=null) {
                            	 lMcq.add(mcq); 
                            
                            	 mcq=null;
                            	 
                             }
                              
                              
                          }
                          
                          AddQuestionDao sdao=new AddQuestionDaoImpl();
                          if(sdao.insertFromExcel(lMcq)) {
                        	  System.out.println("Inserted Succesfully..........!!!");
                          }
           
               
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/result.jsp").forward(request, response);
 
 
		
	}

}
