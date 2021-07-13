package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.AdminService;
import model.AdminModel;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		AdminModel amobj = new AdminModel(email,password);
		
		AdminService asobj = new AdminService();
		if(asobj.adminLogin(amobj)==true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin",email);
			response.sendRedirect("AdminHome.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
			rd.include(request, response);
			out.println("<h3>invalid admin id or password</h3>");
		}
	}

}
