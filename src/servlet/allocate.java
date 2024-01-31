package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.detailbean;

/**
 * Servlet implementation class allocate
 */
@WebServlet("/allocate")
public class allocate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allocate() {
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
		String department=request.getParameter("firstname");
		System.out.println("Department"+department);
		
		String date=request.getParameter("lastname");
		System.out.println("REQ DATE:"+date);
		
		String zone=request.getParameter("zone");
		System.out.println("zone"+zone);
		
		String amount=request.getParameter("amount");
		System.out.println("Ammount"+amount);
		
		String datee=request.getParameter("Edate");
		System.out.println("ADATE:"+datee);
		
		String filename=request.getParameter("filename");
		System.out.println("filename"+filename);
		
		String filekey=request.getParameter("filekey");
		System.out.println("ADATE:"+filekey);
		
		String process=request.getParameter("process");
		System.out.println("process:"+process);
		
	detailbean db=new detailbean();
	db.setDepartment(department);
	db.setDate(date);
	db.setZone(zone);
	db.setAmount(amount);
	db.setEdate(datee);
	db.setFilename(filename);
	db.setFilekey(filekey);
	db.setProcessing(process);
	
	inter n=new imple();
	int c=n.detail(db);
	if(c==1){
		response.sendRedirect("uploadsus.jsp");
	}
	else
	{
	response.sendRedirect("error.jsp");
	}
	
	}

}
