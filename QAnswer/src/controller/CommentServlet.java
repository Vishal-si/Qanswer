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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String ansid= request.getParameter("ansid");
		String user = request.getParameter("user");
		String comment = request.getParameter("comment");
		String commid=user;
		int n = new Random().nextInt(100);
		commid = commid.substring(0, 4);
		commid=commid.concat(""+n);
		
		Feedback fdobj = new Feedback();
		UserModel umobj = new UserModel();
		AnswerModel amobj = new AnswerModel();
		
		umobj.setEmail(user);
		amobj.setAnsid(ansid);
		fdobj.setComment(comment);
		fdobj.setLikeid(commid);
		fdobj.setAmobj(amobj);
		fdobj.setUmobj(umobj);
		
		FeedbackService fdsobj = new FeedbackService();
		if(fdsobj.writeComment(fdobj,umobj,amobj))
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

}
