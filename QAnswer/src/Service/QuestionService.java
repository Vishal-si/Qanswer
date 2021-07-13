package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import DAO.Database;
import model.Question;
import model.UserModel;

public class QuestionService {
	
	public boolean submitQuestion(Question qobj, UserModel umobj)
	{
		String query= "Insert into question(quesid,topic,subtopic,question,date,time,userid) Values(?,?,?,?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, qobj.getQuestion_id());
			pst.setString(2,qobj.getTopic());
			pst.setString(3,qobj.getSubTopic());
			pst.setString(4,qobj.getQues());
			pst.setDate(5, qobj.getDate());
			pst.setTimestamp(6, qobj.getTime());
			pst.setString(7, umobj.getUsername_id());
			
			int x = pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
			conn.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
		
	}
	
	public List<Question> displayQuestion()
	{
		List<Question> list = new ArrayList<Question>();
		Question qobj = null;
		UserModel umobj = null;
		try
		{
		
			Connection conn = Database.getConn();
			String query = "SELECT question,userid FROM question order by date desc";
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(query);
			while(rst.next()==true)
			{
				qobj = new Question();
				umobj = new UserModel();
				
				qobj.setQues(rst.getString("question"));
				umobj.setUsername_id(rst.getString("userid"));
				qobj.setUmobj(umobj);
				
				list.add(qobj);
			}
			conn.close();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return list;
	}
	
	public Question getQuestionfromid(String quesid)
	{
		String query="Select question from question WHERE quesid= ? Order by date desc";
		Question qobj =null;
		try
		{
		
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,quesid);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				qobj = new Question();
				qobj.setQues(rst.getString("question"));
			}
			conn.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return qobj;
		
	}
	
	public List<Question> displayAllQuestion()
	{
		List<Question> list = new ArrayList<Question>();
		try
		{
			Question qobj = null;
			UserModel umobj = null;
			String query = "Select *from question Order by date";
			Connection conn =Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				qobj = new Question();
				umobj = new UserModel();
				qobj.setQuestion_id(rst.getString("quesid"));
				qobj.setTopic(rst.getString("topic"));
				qobj.setSubTopic(rst.getString("subtopic"));
				qobj.setQues(rst.getString("question"));
				qobj.setDate(rst.getDate("date"));
				umobj.setUsername_id(rst.getString("userid"));
				qobj.setUmobj(umobj);
				list.add(qobj);
			}
			conn.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return list;
	}

}
