package CartPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userID = request.getParameter("userID");
		String Password = request.getParameter("Password");
		Dao dao=new Dao();
		RequestDispatcher dispatcher;
		if(dao.isValidUser(userID,Password)==true)
{
	dispatcher=request.getRequestDispatcher("Home.html");
	dispatcher.forward(request, response);
	
}
else
{
	System.out.println("Invalid credentials");
	
	PrintWriter writer=response.getWriter();
	
	writer.print("please enter valid credentials");
	dispatcher=request.getRequestDispatcher("cart.html");	
	dispatcher.include(request,response);	
}
	
	}
}
  