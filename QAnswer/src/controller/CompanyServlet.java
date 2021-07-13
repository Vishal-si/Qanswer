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

import Service.CompanyService;
import model.CompanyModel;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServlet() {
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
		
		String btn = request.getParameter("btn");
		PrintWriter out = response.getWriter();
		switch(btn)
		{
		case "Login":
			String email1 = request.getParameter("email");
			String password1 = request.getParameter("password");
			
			CompanyModel cmobj1 = new CompanyModel();
			cmobj1.setEmail(email1);
			cmobj1.setPassword(password1);
			
			HttpSession session = request.getSession();
			session.setAttribute("cmpemail", email1);
			
			CompanyService csobj1 = new CompanyService();
			if(csobj1.companyLogin(cmobj1))
			{
				response.sendRedirect("postanswer.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("companyLogin.jsp");
				rd.include(request, response);
				out.println("<h3>Error</h3>");

			}
				
			
			
			break;
			
			
		case "Register":
		String cmpname= request.getParameter("cmpname");
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		String country= request.getParameter("country");
		String website= request.getParameter("website");
		
		CompanyModel cmobj = new CompanyModel();
		cmobj.setCmpname(cmpname);
		cmobj.setEmail(email);
		cmobj.setPassword(password);
		cmobj.setCity(city);
		cmobj.setCountry(country);
		cmobj.setWebsite(website);
		
		String cmpnameid = cmpname;
		cmpnameid = cmpnameid.substring(0,4);
		int n = new Random().nextInt(100);
		cmpnameid = cmpnameid.concat(""+n);
		
		cmobj.setCmpid(cmpnameid);
		
		CompanyService csobj = new CompanyService();
		if(csobj.registerCompany(cmobj))
		{
			response.sendRedirect("message.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("addCompany.jsp");
			rd.include(request, response);
			out.println("<h3>Error</h3>");
		}

			
			
			break;
		
		}
		
		
		
		
		
	}

}
