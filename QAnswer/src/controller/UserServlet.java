package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import model.UserModel;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name,email,password;
		String btn = request.getParameter("btn");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		switch(btn)
		{
		case "Register":
			
				name = request.getParameter("name");
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				UserModel umobj = new UserModel();
				umobj.setName(name);
				umobj.setEmail(email);
				umobj.setPassword(password);
				
				int uid = new Random().nextInt(100);
				String usernameid= name;
				usernameid = usernameid.concat(""+uid);
				umobj.setUsername_id(usernameid);
				
				UserService usobj = new UserService();
				if(usobj.register(umobj))
				{
					RequestDispatcher rd1 = request.getRequestDispatcher("Login.jsp");
					rd1.forward(request,response);
				}
				else
				{
					RequestDispatcher rd2 = request.getRequestDispatcher("register.jsp");
					rd2.include(request, response);
					out.println("<h2>Error</h2>");
				}
				name=null;
				email=null;
				password=null;
				
			break;
			
		case "Login":
			
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				UserModel umobj2 = new UserModel();
				umobj2.setEmail(email);
				umobj2.setPassword(password);
				
				UserService usobj2 = new UserService();
				if(usobj2.login(umobj2))
				{
					HttpSession session = request.getSession();
					session.setAttribute("useremail", umobj2.getEmail());
					RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
					rd1.forward(request,response);	
				}
				else
				{
					RequestDispatcher rd2 = request.getRequestDispatcher("Login.jsp");
					rd2.include(request,response);
					out.println("<h2>Invalid username or password</h2>");
				}
				
			break;
			
		}
	}

}
