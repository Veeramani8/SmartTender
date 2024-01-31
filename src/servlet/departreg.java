package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.departbean;

/**
 * Servlet implementation class departreg
 */
@WebServlet("/departreg")
public class departreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public departreg() {
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
		
		String name=request.getParameter("username");
		System.out.println("name:"+name);
		
		String department=request.getParameter("department");
		System.out.println("Department"+department);
		
		String pass=request.getParameter("pass");
		System.out.println("pass"+pass);
		
		String cpass=request.getParameter("cpass");
		System.out.println("cpass"+cpass);
		
		departbean d=new departbean();
		d.setName(name);
		d.setDepartment(department);
		d.setPass(pass);
		d.setConpass(cpass);
		
		inter n=new imple();
		int b=n.dreg(d);
		if(b==1){
			response.sendRedirect("departlogin.jsp");
			
		}
		else{
			response.sendRedirect("Error.jsp");
			
		}
	}

}
