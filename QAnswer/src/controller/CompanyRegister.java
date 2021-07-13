package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Service.CompanyService;
import model.CompanyModel;

/**
 * Servlet implementation class CompanyRegister
 */
@WebServlet("/CompanyRegister")
public class CompanyRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String cmpid = request.getParameter("id");
		out.println(cmpid);

		CompanyService csobj = new CompanyService();
		CompanyModel cmobj=(CompanyModel)csobj.getCompanyInformation(cmpid);
		
		if(csobj.approveCompany(cmobj))
		{
			if(csobj.deleteCompany(cmpid))
			{
				response.sendRedirect("Admin.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("companyRequest.jsp");
				rd.include(request, response);
				out.println("<h3>Delete error</h3>");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("companyRequest.jsp");
			rd.include(request, response);
			out.println("<h3>Submit error</h3>");
		}
		
			
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

}
}
