package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.contractorbean;

/**
 * Servlet implementation class contractorreg
 */
@WebServlet("/contractorreg")
public class contractorreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contractorreg() {
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
		System.out.println("Company Name:"+cname);
		
		String email=request.getParameter("cmail");
		System.out.println("Email:"+email);
		
		String cnumber=request.getParameter("cnumber");
		System.out.println("Contact number"+cnumber);
		
		String pass=request.getParameter("pass");
		System.out.println("pass:"+pass);
		
		String cpass=request.getParameter("cpass");
		System.out.println("cpass:"+cpass);
		
		String city=request.getParameter("city");
		System.out.println("city"+city);

		String State=request.getParameter("state");
		System.out.println("State"+State);
		
		String country=request.getParameter("country");
		System.out.println("country"+country);
		
		contractorbean b=new contractorbean();
		b.setCname(cname);
		b.setEmail(email);
		b.setNumber(cnumber);
		b.setPassword(pass);
		b.setConpassword(cpass);
		b.setCity(city);
		b.setState(State);
		b.setCountry(country);
		
		inter n=new imple();
		int v=n.con(b);
		if(v==1){
			response.sendRedirect("contarctlogin.jsp");
		}
		else{
			response.sendRedirect("Error.jsp");
		}
	}

}
