package model;

public class AdminModel {
	
	private String email;
	private String password;
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	

}
