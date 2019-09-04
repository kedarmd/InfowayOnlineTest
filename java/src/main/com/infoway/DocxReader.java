package com.infoway;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.formula.functions.Substitute;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.infoway.Dao.AddQuestionDao;
import com.infoway.Dao.AddQuestionDaoImpl;
import com.model.MCQ;
 
public class DocxReader {

	public static void main(String args[]) {
		 
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		try {
			File fileToBeRead = new File("mcq.docx");
			fileInputStream = new FileInputStream(fileToBeRead);
		//	String words[]=null;
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fileInputStream));
		//	document = new XWPFDocument(fileInputStream);
			List<XWPFParagraph> paragraphList= xdoc.getParagraphs();
			int i=0;
			ArrayList<MCQ> lMcq=new ArrayList<>();
			MCQ mcq=new MCQ();
		//	StringBuffer sb = new StringBuffer();
			for (XWPFParagraph paragraph : paragraphList) {
				//System.out.println(paragraph.getText());
				if(mcq==null)
					mcq=new MCQ();
				if(mcq.getQuestion()==null)
				mcq.setQuestion(new StringBuffer());
			 
			
			//if(i%2==0) {
			if(paragraph.getText().contains("a)"))
			{
				
				mcq.setA(paragraph.getText()) ;
				//String a = mcq.getA();
				// System.out.println("------------"+a.substring(2));
				 mcq.setA(mcq.getA().substring(2));
				 
			}
			else
				if(paragraph.getText().contains("b)"))
				{
					mcq.setB(paragraph.getText());
					mcq.setB(mcq.getB().substring(2));
				}
				else
					if(paragraph.getText().contains("c)"))
					{
						mcq.setC(paragraph.getText());
						mcq.setC(mcq.getC().substring(2));
					}
					else
						if(paragraph.getText().contains("d)"))
						{
							mcq.setD(paragraph.getText());
							mcq.setD(mcq.getD().substring(2));
					/*
					 * StringBuffer sbr = mcq.getQuestion().append(paragraph.getText().replace("'",
					 * "\\'")+"\n"); String str = sbr.toString().trim();
					 * System.out.println("*************"+str); sbr= new StringBuffer(str);
					 * sbr.replace(0, 2, ""); System.out.println("-------------"+sbr);
					 * mcq.setQuestion(new StringBuffer(sbr)); lMcq.add(mcq); mcq=null;
					 */
							
						}
						else
							if(paragraph.getText().contains("ans-"))
							{
								mcq.setAns(paragraph.getText());
								mcq.setAns(mcq.getAns().substring(4));
								StringBuffer sbr = mcq.getQuestion().append(paragraph.getText().replace("'", "\\'")+"\n");
								String str = sbr.toString().trim();
								System.out.println("*************"+str);
								sbr= new StringBuffer(str);
								sbr.replace(0, 2, "");
								System.out.println("-------------"+sbr);
								mcq.setQuestion(new StringBuffer(sbr));
								lMcq.add(mcq);
								mcq=null;
								
							}
						else {
							
						 mcq.getQuestion().append(paragraph.getText().replace("'", "\\'")+"\n");
							
						}
			
			//}
			i++;
			}
			
			AddQuestionDao sdao=new AddQuestionDaoImpl();
            if(sdao.insertFromExcel(lMcq)) {
          	  System.out.println("Inserted Succesfully..........!!!");
            }
			
			for (MCQ mcq1 : lMcq) {
				System.out.println(mcq1.getQuestion());
				System.out.println(mcq1.getA());
				System.out.println(mcq1.getB());
				System.out.println(mcq1.getC());
				System.out.println(mcq1.getD());
			
			}
			
			
//			XWPFWordExtractor extractor = new XWPFWordExtractor(document);
//			System.out.println(extractor.getText());
 
		} catch (Exception e) {
			System.out.println("We had an error while reading the Word Doc");
		} finally {
			try {
				if (document != null) {
			//		document.
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception ex) {
			}
		}
 
	}
	
}
