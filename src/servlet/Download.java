package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
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
		HttpSession session=request.getSession();
		
		response.getContentType();
		
	String key2=request.getParameter("filekey");
		
		
		System.out.println("download0000000000000000000===="+key2);   
		JOptionPane joptionpane =new JOptionPane("CLICK OK");
		
		
	    JDialog jdialog= joptionpane.createDialog("Alert");
		
		jdialog.setAlwaysOnTop(true);
		
		jdialog.show();
		
		String newkey =JOptionPane.showInputDialog("Enter Your filekey");
		
		
		if(newkey.equals(key2))
	
		{
		try
		{
	PrintWriter out=response.getWriter();
		
		
		String realpath = getServletContext().getRealPath("/");
		String filepath = realpath.substring(0, realpath.indexOf("."))
				+ "BC06-22\\WebContent\\Local\\";
		
		
		String filename=request.getParameter("filename");
		System.out.println(filename);
		
	/*	 String filepath="E:\\2016 Web\\ITJDM15\\WebContent\\compress\\"+compress+".zip";*/
		
		  response.setContentType("APPLICATION/OCTET-STREAM");   
		  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
	FileInputStream fileInputStream=new FileInputStream(filepath+filename);  
		            
		  int i;   
		  while ((i=fileInputStream.read()) != -1) {  
		    out.write(i);   
		  }   
		  fileInputStream.close(); 
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
}
		
		else
		{
System.out.println("failed");
			
			JOptionPane.showMessageDialog(null, "Sorry Your key is wrong");
			
			response.sendRedirect("Center.jsp");
		}		
}
	
}
