package model;

public class CompanyModel {
	
	private String cmpid;
	private String cmpname,email,password,city,country,website;
	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyModel(String cmpid, String cmpname, String email, String password, String city, String country,
			String website) {
		super();
		this.cmpid = cmpid;
		this.cmpname = cmpname;
		this.email = email;
		this.password = password;
		this.city = city;
		this.country = country;
		this.website = website;
	}
	public String getCmpid() {
		return cmpid;
	}
	public void setCmpid(String cmpid) {
		this.cmpid = cmpid;
	}
	public String getCmpname() {
		return cmpname;
	}
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	

}
