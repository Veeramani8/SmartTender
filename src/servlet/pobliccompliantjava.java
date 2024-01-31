package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import bean.publiccom;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class pobliccompliantjava
 */
@WebServlet("/pobliccompliantjava")
public class pobliccompliantjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pobliccompliantjava() {
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
		// TODO Auto-generated method stub
MultipartParser mp =new MultipartParser(request, 999999999);
		
		Part part = null;
		ArrayList paramValues = new ArrayList();
		
		HttpSession session=request.getSession();
 
		 
		
		response.getContentType();
	 
		
	 
		FilePart filepart = null;
		ParamPart param=null;
 
		String filetype=null;
	 
		String filename = null;
		
		long size=0;
		String path=getServletContext().getRealPath("");
		
		System.out.println("path0000000000000000000000=="+path);
		
		
		String editpath=path.substring(0, path.indexOf("."));
		
		System.out.println("edithpath1111111111111111======"+editpath);
		
		String fullpath=editpath+"goverment\\WebContent\\Locals\\";
		
		
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
	 
			 
 
			 
		publiccom bu=new publiccom();
				   bu.setCname(paramValues.get(0).toString());
				   System.out.println("setFilename:"+paramValues.get(0).toString());
				   
				   bu.setEmail(paramValues.get(2).toString());
				   System.out.println("setFilename:"+paramValues.get(2).toString());
				   
				   bu.setAddress(paramValues.get(4).toString());
				   System.out.println("setFilename:"+paramValues.get(4).toString());
				   
				   bu.setCompliantdate(paramValues.get(6).toString());
				   System.out.println("setFilename:"+paramValues.get(6).toString());
				   bu.setMobile(paramValues.get(8).toString());
				   System.out.println("setFilename:"+paramValues.get(8).toString());
				   bu.setZone(paramValues.get(10).toString());
				   System.out.println("setFilename:"+paramValues.get(10).toString());
				   bu.setDepartment(paramValues.get(12).toString());
				   System.out.println("setFilename:"+paramValues.get(12).toString());
				   bu.setCtype(paramValues.get(14).toString());
				   System.out.println("setFilename:"+paramValues.get(14).toString());
				   bu.setStreet(paramValues.get(16).toString());
				   System.out.println("setFilename:"+paramValues.get(16).toString());
				   bu.setDescription(paramValues.get(18).toString());
				   System.out.println("setFilename:"+paramValues.get(18).toString());
				   
				   
				   
				   bu.setFilename(filename);
				   
				   
				   inter in=new imple();
				   int n=in.pub(bu);
				   if(n==1){
				    
					   response.sendRedirect("publicmain.jsp");
				   }else{
					   response.sendRedirect("Error.jsp");
				   }
				    
        			
                
			}
}
