package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.Database;
import model.AdminModel;

public class AdminService {
	
	public boolean adminLogin(AdminModel amobj)
	{
		String query="Select *from admin where adminid = ? and password = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,amobj.getEmail());
			pst.setString(2, amobj.getPassword());
			ResultSet rst = pst.executeQuery();
			if(rst.next())
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
