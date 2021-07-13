package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.Database;
import model.AnswerModel;
import model.Feedback;
import model.UserModel;

public class FeedbackService {
	
	public boolean getLikes(String user, String ansid)
	{
		String query = "Select *from like_table where user = ? and ansid = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,user);
			pst.setString(2,ansid);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				return true;
			}
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	public boolean setLikes(UserModel umobj, AnswerModel amobj, Feedback fobj)
	{
		String query ="Insert into like_table(likeid,ansid,user,likes) values(?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,fobj.getLikeid());
			pst.setString(2,amobj.getAnsid());
			pst.setString(3,umobj.getEmail());
			pst.setBoolean(4, fobj.getLike());
			
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
	
	
	public boolean getDislikes(String user, String ansid)
	{
		String query = "Select *from dislike_table where user = ? and ansid = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,user);
			pst.setString(2,ansid);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				return true;
			}
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	public boolean setDislikes(UserModel umobj, AnswerModel amobj, Feedback fobj)
	{
		String query ="Insert into dislike_table(dislikeid,ansid,user,dislikes) values(?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,fobj.getLikeid());
			pst.setString(2,amobj.getAnsid());
			pst.setString(3,umobj.getEmail());
			pst.setBoolean(4, fobj.getLike());
			
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
	
	public boolean writeComment(Feedback fdobj, UserModel umobj,AnswerModel amobj)
	{
		String query = "Insert into comment(cid,ansid,user,comment) values(?,?,?,?)"; 
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,fdobj.getLikeid());
			pst.setString(2,amobj.getAnsid());
			pst.setString(3,umobj.getEmail());
			pst.setString(4,fdobj.getComment());
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

}
