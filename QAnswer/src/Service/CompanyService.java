package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.Database;
import model.CompanyModel;

public class CompanyService {
	
	public boolean registerCompany(CompanyModel cmobj)
	{
		String query="Insert into companySubmission(cmpid,cmpname,email,password,city,country,website) values(?,?,?,?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,cmobj.getCmpid());
			pst.setString(2,cmobj.getCmpname());
			pst.setString(3,cmobj.getEmail());
			pst.setString(4,cmobj.getPassword());
			pst.setString(5,cmobj.getCity());
			pst.setString(6,cmobj.getCountry());
			pst.setString(7,cmobj.getWebsite());
		
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
	
	public List<CompanyModel> totalRequest()
	{
	
		List<CompanyModel> lmobj = new ArrayList<CompanyModel>();
		CompanyModel cmobj = null;
		try
		{
			Connection conn = Database.getConn();
			String query= "Select cmpid,cmpname,email,password,city,country,website From companySubmission";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				cmobj = new CompanyModel();
				cmobj.setCmpid(rst.getString("cmpid"));
				cmobj.setCmpname(rst.getString("cmpname"));
				cmobj.setEmail(rst.getString("email"));
				cmobj.setPassword(rst.getString("password"));
				cmobj.setCity(rst.getString("city"));
				cmobj.setCountry(rst.getString("country"));
				cmobj.setWebsite(rst.getString("website"));
				lmobj.add(cmobj);	
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return lmobj;
	}
	
	public boolean approveCompany(CompanyModel cmobj)
	{
		String query="Insert into approveCompany(cmpid,cmpname,email,password,city,country,website) values(?,?,?,?,?,?,?)";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,cmobj.getCmpid());
			pst.setString(2,cmobj.getCmpname());
			pst.setString(3,cmobj.getEmail());
			pst.setString(4,cmobj.getPassword());
			pst.setString(5,cmobj.getCity());
			pst.setString(6,cmobj.getCountry());
			pst.setString(7,cmobj.getWebsite());
		
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
	

	public CompanyModel getCompanyInformation(String cmpid)
	{
		CompanyModel cmobj = null;
		String query= "Select *from companySubmission WHERE cmpid = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,cmpid);
			ResultSet rst = pst.executeQuery();
			while(rst.next()==true)
			{
				cmobj= new CompanyModel();
				cmobj.setCmpid(rst.getString("cmpid"));
				cmobj.setCmpname(rst.getString("cmpname"));
				cmobj.setEmail(rst.getString("email"));
				cmobj.setPassword(rst.getString("password"));
				cmobj.setCity(rst.getString("city"));
				cmobj.setCountry(rst.getString("country"));
				cmobj.setWebsite(rst.getString("website"));
			}
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return cmobj;
	}
	
	public boolean deleteCompany(String cmpid)
	{
		String query="Delete from companySubmission Where cmpid = ? ";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,cmpid);
		
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
	
	public List<CompanyModel> totalCompany()
	{
	
		List<CompanyModel> lmobj = new ArrayList<CompanyModel>();
		CompanyModel cmobj = null;
		try
		{
			Connection conn = Database.getConn();
			String query= "Select cmpid,cmpname,email,city,country,website From approveCompany";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				cmobj = new CompanyModel();
				cmobj.setCmpid(rst.getString("cmpid"));
				cmobj.setCmpname(rst.getString("cmpname"));
				cmobj.setEmail(rst.getString("email"));
				cmobj.setCity(rst.getString("city"));
				cmobj.setCountry(rst.getString("country"));
				cmobj.setWebsite(rst.getString("website"));
				lmobj.add(cmobj);	
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return lmobj;
	}
	
	public boolean companyLogin(CompanyModel cmobj)
	{
		String query = "Select *from approveCompany WHERE email = ? AND password = ?";
		try
		{
			Connection conn = Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,cmobj.getEmail());
			pst.setString(2,cmobj.getPassword());
			ResultSet rst = pst.executeQuery();
			if(rst.next()==true)
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
	
	public CompanyModel getCompanyNameByEmail(String email)
	{
		CompanyModel cmobj = null;
		try
		{
			
			String query="Select cmpname from approvecompany Where email = ?";
			Connection conn= Database.getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				cmobj = new CompanyModel();
				cmobj.setCmpname(rst.getString("cmpname"));
			}
		}
		catch(Exception e)
		
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass());
		}
		return cmobj;
	}


}
