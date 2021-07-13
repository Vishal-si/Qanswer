package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.QuestionService;
import model.Question;
import model.UserModel;


/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		//0doGet(request, response);
		
		HttpSession session = request.getSession(true);
		String useremail = (String)session.getAttribute("useremail");
		if(useremail==null)
		{
			response.sendRedirect("Login.jsp");
		}
		else
		{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String userid = request.getParameter("userid");
		String topic = request.getParameter("topic");
		if(topic.equals("C++") || topic.equals("c++") || topic.equals("c+") || topic.equals("c++"))
		{
			topic="cplus";
		}
		else if(topic.equals("C#") || topic.equals("c#"))
		{
			topic="cshrap";
		}
		
		String subtopic = request.getParameter("subtopic");
		String question = request.getParameter("question");
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
		
		
		UserModel umobj = new UserModel();
		umobj.setUsername_id(userid);
		
		Question qobj = new Question();
		qobj.setQues(question);
		qobj.setTopic(topic);
		qobj.setSubTopic(subtopic);
		qobj.setDate(sqldate);
		qobj.setTime(sqlTime);
		
		String ques_id = topic;
		int qid = new Random().nextInt(100);
		ques_id=ques_id.concat(""+qid);
		qobj.setQuestion_id(ques_id);
		
		QuestionService qsobj = new QuestionService();
		if(qsobj.submitQuestion(qobj, umobj))
		{
			response.sendRedirect("index.jsp");
		}
		
		else 
		{
			RequestDispatcher rd2 = request.getRequestDispatcher("post.jsp");
			rd2.include(request, response);
			out.println("<h3>Error</h3>");
		}
		out.close();
		}
	}


}
