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



import bean.departbean;

/**
 * Servlet implementation class deparlogin
 */
@WebServlet("/deparlogin")
public class deparlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deparlogin() {
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
		String name=request.getParameter("name");
		System.out.println("Staff Name"+name);
		
		String department=request.getParameter("department");
		System.out.println("department"+department);
		
		HttpSession session=request.getSession();
		session.setAttribute("depart", department);
		
		String pass=request.getParameter("pass");
		System.out.println("pass"+pass);
		
		departbean s=new departbean();
		s.setName(name);
		s.setDepartment(department);
		s.setPass(pass);
		
		inter b=new imple();
		boolean n=b.dlog(s);
		if(n==true){
			response.sendRedirect("departmain.jsp");
			session.setAttribute("srno", "1");
		}
		else{
			session.setAttribute("srno", "2");
			response.sendRedirect("departlogin.jsp");
		}
	}

}
