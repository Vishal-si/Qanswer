package controller;

import java.io.Console;
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

import Service.AnswerService;
import model.AnswerModel;
import model.CompanyModel;
import model.Question;

/**
 * Servlet implementation class PostAnswerServlet
 */
@WebServlet("/PostAnswerServlet")
public class PostAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnswerServlet() {
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
		String cmpname = request.getParameter("cmpname");
		String quesid = request.getParameter("quesid");
		String answer = request.getParameter("answer");
		String ansid ="ans";
		int a =new Random().nextInt(100);
		ansid= ansid.concat(""+a);
		
		CompanyModel cmobj = new CompanyModel();
		cmobj.setCmpname(cmpname);
		
		AnswerModel amobj = new AnswerModel();
		amobj.setAnsid(ansid);
		amobj.setAnswer(answer);
		
		Question qobj = new Question();
		qobj.setQuestion_id(quesid);

		AnswerService asobj = new AnswerService();
		if(asobj.addAnswer(cmobj, qobj, amobj))
		{
			response.sendRedirect("index.jsp");

		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("postanswer.jsp");
			rd.include(request, response);
			out.println("<h3>Answer not submit pls try again</h3>");
		}
		
		
		
	}

}
