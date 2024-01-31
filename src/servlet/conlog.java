package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.contractorbean;


/**
 * Servlet implementation class conlog
 */
@WebServlet("/conlog")
public class conlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conlog() {
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
		
		String cname=request.getParameter("cname");
		System.out.println("doctors "+cname);
		 
		HttpSession session=request.getSession();
		session.setAttribute("company", cname);
		
		String pass=request.getParameter("pass");
		System.out.println("pass: "+pass);
		
		String status="Activate";
		
		contractorbean r=new contractorbean();
		r.setCname(cname);
		r.setPassword(pass);
		r.setStatus(status);
		
		inter n=new imple();
		boolean v=n.clog(r);
		if(v==true){
			session.setAttribute("srno","1");
	response.sendRedirect("contractormain.jsp");
		}else{
			session.setAttribute("srno","2");
			response.sendRedirect("contarctlogin.jsp");
		}
	}

}
