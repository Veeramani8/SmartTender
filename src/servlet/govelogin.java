package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class govelogin
 */
@WebServlet("/govelogin")
public class govelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public govelogin() {
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
		String email=request.getParameter("email");
		System.out.println("email"+email);
		
		String pass=request.getParameter("pass");
		System.out.println("pass"+pass);
		
		if (email.equals("Admin@gmail.com") && pass.equals("Admin")) {
			response.sendRedirect("govermentmain.jsp");
		    //System.out.println("register Successfully");
			
		} else {
			JOptionPane jpane=new JOptionPane("Invalid Log In");
			JDialog jdialog=jpane.createDialog("Alert");
		
			jdialog.setAlwaysOnTop(true);
			
			jdialog.show();
			
			
			
			/*jpane.showMessageDialog(null,"Invalid Log In ");*/
			response.sendRedirect("govermentlogin.jsp");
	}
	}


	}


