package servlet;

import imple.imple;
import inter.inter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import bean.Block;

import bean.requestbean;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.lowagie.text.Element;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

import dbcon.Database;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
MultipartParser mp =new MultipartParser(request, 999999999);
		
		Part part = null;
		ArrayList paramValues = new ArrayList();
		
		HttpSession session=request.getSession();
 
		 
		
		response.getContentType();
	 
		String status="Finish";
		 
			FilePart filepart = null;
			ParamPart param=null;
			File file1 = null;
			String filepath1 = null;
			String filetype=null;
			String filepath2 = null;
			String filename = null;
		
		long size=0;
		String path=getServletContext().getRealPath("");
		
		System.out.println("path0000000000000000000000=="+path);
		
		
		String editpath=path.substring(0, path.indexOf("."));
		
		System.out.println("edithpath1111111111111111======"+editpath);
		
		String fullpath=editpath+"goverment\\WebContent\\quotation\\";
		
		
		System.out.println("fullpath333333333333333=="+fullpath);
		
		while((part=mp.readNextPart())!=null)
		{
			
			if(part.isFile())
			{
				
				filepart=(FilePart)part;
				
				
			 filename=filepart.getFileName();
				
				System.out.println("filename9999999999999999=="+filename);
				
			 fullpath=fullpath+filename;
				
				System.out.println("fullpath5555555555555555555=="+fullpath);
				
				
				
				File file=new File(fullpath);
			 size=filepart.writeTo(file);
				
				System.out.println("size6666666666666=="+size);
				
		 filetype=filepart.getContentType();
				System.out.println("filetype88888888888---"+filetype);
				
			}
			else if(part.isParam())
			{
				param = (ParamPart) part;
				String tagName =param.getName();
				System.out.println("tagName ============= " + tagName);
				String tagValue = param.getStringValue();
				System.out.println("tagValue ************ " + tagValue);
				 
				paramValues.add(tagValue);
				paramValues.add(tagName);
				
			}
		
		}
	
		String filecontent = "";
		String encrpt = null;
		 String encontent = null;
		 

		if (filename.endsWith(".txt")) {// if open

//file encrypted and store into filepath1
			
			FileInputStream fis = new FileInputStream(fullpath);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			String reading = new String(b);
			filecontent = filecontent + reading;
            System.out.println("filecontent=" + filecontent);
           
            try {//try1 open
            	
                
    			encontent = AES.encrypt99(filecontent);
    				System.out.println("encontent===="+encontent);
         filepath1 = editpath + "\\goverment\\WebContent\\Encrypt\\"+filename;
              file1 = new File(filepath1);
                    file1.createNewFile();
                    if (!file1.exists()) {file1.createNewFile();}// If file doesn't exists, then create it
                    FileWriter fw = new FileWriter(file1.getAbsoluteFile());
    				BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(encontent);// Write in file
                    bw.close();// Close connection
                    System.out.println("fileeeeeeeeeeeeeeeee" + filepath1);
       
          //file decrypted and store into filepath2
                    String decontent= AES.decrypt(encontent);
    				System.out.println("decontent===="+decontent);
    		    filepath2 = editpath + "\\goverment\\WebContent\\Decrypt\\"+filename;
                    File file2 = new File(filepath2);
                    file2.createNewFile();
                    if (!file1.exists()) {file1.createNewFile();}// If file doesn't exists, then create it
                    FileWriter fw1 = new FileWriter(file2.getAbsoluteFile());
    				BufferedWriter bw1 = new BufferedWriter(fw1);
                    bw1.write(decontent);// Write in file
                    bw1.close();// Close connection
                    System.out.println("fileeeeeeeeeeeeeeeee" + filepath2);
       
                    
                    } catch (Exception e) {
				
				e.printStackTrace();
			}
            
            
		}
		else if (filename.endsWith(".docx")) 
		{  
			WordExtractor extractor = null;
			
			FileInputStream fis2=new FileInputStream(fullpath);
			System.out.println("file is"+fis2);
			HWPFDocument document=new HWPFDocument(fis2);
			extractor = new WordExtractor(document);
			String [] fileData = extractor.getParagraphText();
			String mydate=extractor.getTextFromPieces();
			System.out.println("DATASSSSSSSSSSSSSSSSSss "+fileData);
			System.out.println("THE MYYYYYYYYYYY "+mydate);
			String text1=null;
			System.out.println("filedata len  "+fileData.length);
		}
		
		else if(filename.endsWith(".pdf"))
		{ 
			//System.out.println("padf file name"+file1.getName());
		
	
		PdfReader pdfReader=new PdfReader(fullpath);
			String	Text7 = null;
			int pages=pdfReader.getNumberOfPages();
			for(int i1=1;i1<pages;i1++)
			{
				 filecontent=PdfTextExtractor.getTextFromPage(pdfReader, i1);
				System.out.println("page:"+i1+" "+filecontent);
				Text7=Text7+filecontent;
				
			}
			System.out.println("Pdf full content ="+Text7);
	
		try {
			encrpt = encryptdata.encrypt(filecontent);
		Document document=new Document(PageSize.A4);
		/*  File file=new File("C:\\Users\\spiro13\\Desktop\\naga\\"+pdffilename);
		  System.out.println(file.delete());*/
		PdfWriter.getInstance(document, new FileOutputStream(new File(filepath2+filename)));
		//FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\spiro13\\Desktop\\naga\\pdffilename1.pdf");
		Chunk chunk=new Chunk(encrpt);
		document.open();
		Font font=new Font();
		font.setStyle(Font.BOLD);
		Paragraph p1=new Paragraph(chunk);
		p1.setAlignment(Element.ALIGN_LEFT);
		document.add(p1);
		document.close();
		System.out.println("pdf writing is completed");
		//fileOutputStream.write(encrpt.getBytes());
		System.out.println(encrpt);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
           
		try {
			
			//try1 open
            	
            
		encontent = AES.encrypt99(filecontent);
			System.out.println("encontent===="+encontent);
 filepath1 = editpath + "\\goverment\\WebContent\\Encrypt\\"+filename;
      file1 = new File(filepath1);
            file1.createNewFile();
            if (!file1.exists()) {file1.createNewFile();}// If file doesn't exists, then create it
            FileWriter fw = new FileWriter(file1.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
            bw.write(encontent);// Write in file
            bw.close();// Close connection
            System.out.println("fileeeeeeeeeeeeeeeee" + filepath1);

  //file decrypted and store into filepath2
            String decontent= AES.decrypt(encontent);
			System.out.println("decontent===="+decontent);
	    filepath2 = editpath + "\\goverment\\WebContent\\Decrypt\\"+filename;
            File file2 = new File(filepath2);
            file2.createNewFile();
            if (!file1.exists()) {file1.createNewFile();}// If file doesn't exists, then create it
            FileWriter fw1 = new FileWriter(file2.getAbsoluteFile());
			BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(decontent);// Write in file
            bw1.close();// Close connection
            System.out.println("fileeeeeeeeeeeeeeeee" + filepath2);
            
        }// try close
   
	catch (Exception e) {
		System.out.println(e);
		}
		}
            String prehash="";
			String afterhash="";
			
			String ad="mail";
			
			Connection con;
			con=Database.create();
			try {
				PreparedStatement pa=con.prepareStatement("SELECT phash,ahash FROM `contract`.request` where mail='"+ad+"'");
				ResultSet rs=pa.executeQuery();
				while(rs.next()){
					prehash=rs.getString(1);
					afterhash=rs.getString(2);
					
				}
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(afterhash);
			prehash=afterhash;

			 
			 
			 
			Block genesisBlock = new Block("Hi im the first block", "0");
 
			String phas=genesisBlock.hash;
			
			Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
			System.out.println("Hash for block 2 : " + secondBlock.hash);
			String aphas=secondBlock.hash; 
			
			requestbean bu=new requestbean();
		 bu.setId(paramValues.get(0).toString());
		   System.out.println("setFilename:"+paramValues.get(0).toString());
		   
				   bu.setDepart  (paramValues.get(2).toString());
				   System.out.println("setFilename:"+paramValues.get(2).toString());
				   
				   bu.setDate(paramValues.get(4).toString());
				   System.out.println("setFilename:"+paramValues.get(4).toString());
				   
				   bu.setZone(paramValues.get(6).toString());
				   System.out.println("setFilename:"+paramValues.get(6).toString());
				   
				   bu.setAamount(paramValues.get(8).toString());
				   System.out.println("setFilename:"+paramValues.get(8).toString());
				   bu.setDuration(paramValues.get(10).toString());
				   System.out.println("setFilename:"+paramValues.get(10).toString());
				   bu.setRequest(paramValues.get(12).toString());
				   System.out.println("setFilename:"+paramValues.get(12).toString());
				   bu.setCompanyname(paramValues.get(14).toString());
				   System.out.println("setFilename:"+paramValues.get(14).toString());
				   
				  
				   bu.setFilename(filename);
				   bu.setFiletype(filetype);
				   bu.setFilesize(String.valueOf(size));
				   bu.setFilecontent(encontent);
				  
				   bu.setPhash(prehash);
				   bu.setAhash(aphas);
				   bu.setMail(ad);
				
				   inter in=new imple();
				   int n=in.request(bu);
				   if(n==1){
				    
					   response.sendRedirect("contractormain.jsp");
				   }else{
					   response.sendRedirect("Error.jsp");
				   }
		}
		}
				 

        			
                
		

		


