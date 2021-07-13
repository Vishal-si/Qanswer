package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.Database;
import model.AnswerModel;
import model.CompanyModel;
import model.Question;

public class AnswerService {
	
	public boolean addAnswer(CompanyModel cmobj,  Question qobj, AnswerModel amobj)
	{
		String query="Insert into answer(ansid,answer,quesid,cmpname) value(?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,amobj.getAnsid());
			pst.setString(2,amobj.getAnswer());
			pst.setString(3, qobj.getQuestion_id());
			pst.setString(4,cmobj.getCmpname());
			int x = pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	public List<AnswerModel> getAllAnswerInDisplay()
	{
		List<AnswerModel> alist = new ArrayList<AnswerModel>();
		AnswerModel amobj = null;
		CompanyModel cmobj = null;
		String query="Select ansid,answer,cmpname from answer";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				amobj = new AnswerModel();
				amobj.setAnsid(rst.getString("ansid"));
				amobj.setAnswer(rst.getString("answer"));
				cmobj = new CompanyModel();
				cmobj.setCmpname(rst.getString("cmpname"));
				amobj.setCmobj(cmobj);
				alist.add(amobj);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return alist;
	}
	
	public List<Question> getAnswerByCompany(String userid)
	{
		List<Question> list = new ArrayList<Question>();
		String query="Select *from question_answer where userid = ?";
		try
		{
			Question qobj =null;
			AnswerModel  amobj = null;
			CompanyModel cmobj = null;
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, userid);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				qobj = new Question();
				amobj = new AnswerModel();
				cmobj = new CompanyModel();
				//question
				qobj.setTopic(rst.getString("topic"));
				qobj.setSubTopic(rst.getString("subtopic"));
				qobj.setQues(rst.getString("question"));
				
				//answer
				amobj.setAnswer(rst.getString("answer"));
				
				//company
				cmobj.setCmpname(rst.getString("cmpname"));
				
				qobj.setAmobj(amobj);
				qobj.setCmobj(cmobj);
				
				list.add(qobj);
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return list;
	}

}
