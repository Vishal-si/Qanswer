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

import Service.FeedbackService;
import model.AnswerModel;
import model.Feedback;
import model.UserModel;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String ansid = request.getParameter("id");
		String user = request.getParameter("user");
		String likeid=user;
		int n = new Random().nextInt(100);
		likeid = likeid.substring(0, 4);
		likeid=likeid.concat(""+n);
		
		FeedbackService fsobj = new FeedbackService();
		if(fsobj.getLikes(user,ansid)==true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("answerframe.jsp");
			rd.include(request, response);
			out.println("<h2>Allready like</h2>");
		}
		else
		{
			Feedback fobj = new Feedback();
			AnswerModel amobj = new AnswerModel();
			UserModel umobj = new UserModel();
			umobj.setEmail(user);
			amobj.setAnsid(ansid);
			fobj.setLike(true);
			fobj.setLikeid(likeid);
			fobj.setUmobj(umobj);
			fobj.setAmobj(amobj);
			
			if(fsobj.setLikes(umobj, amobj, fobj)==true)
			{
				response.sendRedirect("answerframe.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("answerframe.jsp");
				rd.include(request,response);
				out.println("<h2>Error</h2>");
				
				
			}
			
		}
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
	
	}

}
