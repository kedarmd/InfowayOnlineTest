package com.infoway;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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



public class ExcelQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ExcelQuestionServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String fileName=request.getParameter("upload1");
		System.out.println(fileName);		
		
//		// String description = request.getParameter("upload"); // Retrieves <input type="text" name="description">
//		    Part filePart = request.getPart("upload1"); // Retrieves <input type="file" name="file">
//		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//		    InputStream fileContent = filePart.getInputStream();
//		    // ... (do your job here)
//		
		
		ArrayList<AddQuestion> alist=new ArrayList<AddQuestion>();
		

        FileInputStream fis = new FileInputStream(fileName);
        
     // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
       
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();
        
        ArrayList<AddQuestion> addquestion = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        //I've Header and I'm ignoring header for that I've +1 in loop
                  for(int i=mySheet.getFirstRowNum();i<=mySheet.getLastRowNum();i++){
                	  AddQuestion s= new AddQuestion();
                      Row ro=mySheet.getRow(i);
                      for(int j=ro.getFirstCellNum()+1;j<=ro.getLastCellNum()-1;j++){
                          Cell ce = ro.getCell(j);
                          
                        if(j==1){
                            s.setQuestion(ce.getStringCellValue());
                            
                        }
                        if(j==2){
                            s.setA(ce.getStringCellValue());
                        }
                        if(j==3) {
                        	s.setB(ce.getStringCellValue());
                        }
                        if(j==4) {
                        	s.setC(ce.getStringCellValue());
                        }
                        if(j==5) {
                        	s.setD(ce.getStringCellValue());
                        }
                        
                        if(j==6) {
                        	s.setAns(ce.getStringCellValue());
                        }
                        
                      }
                     if(s.getQuestion()!=null) {
                    	 addquestion.add(s); 
                     }
                      
                      
                  }
                  
                  AddQuestionDao sdao=new AddQuestionDaoImpl();
                  if(sdao.insertFromExcel(addquestion)) {
                	  System.out.println("Inserted Succesfully..........!!!");
                  }
	}

}
