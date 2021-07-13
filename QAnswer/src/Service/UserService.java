package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.Database;
import model.UserModel;

public class UserService {
	
	public boolean register(UserModel umobj)
	{
		String query = "Insert into user(userid,name,email,password)values(?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,umobj.getUsername_id());
			pst.setString(2,umobj.getName());
			pst.setString(3,umobj.getEmail());
			pst.setString(4,umobj.getPassword());
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
	
	public boolean login(UserModel umobj)
	{
		String query="Select *from user WHERE email=? AND password=?";
		try
		{
			Connection conn= Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,umobj.getEmail());
			pst.setString(2,umobj.getPassword());
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
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
	
	
	public UserModel getUsernameFromEmail(String useremail)
	{
		String query="SELECT name from user WHERE email = ?";
		UserModel umobj = null;
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, useremail);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				umobj = new UserModel();
				umobj.setName(rst.getString("name"));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return umobj;
		
	}
	
	public String getUseridFromEmail(String useremail)
	{
		String query="SELECT userid from user WHERE email = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, useremail);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				return rst.getString("userid");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return null;		
		
	}
	

}
