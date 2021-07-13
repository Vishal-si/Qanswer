package model;
import java.util.Random;

public class UserModel 
{
	private String username_id;
	private String name;
	private String email;
	private String password;
	public UserModel(String name, String username_id,String email, String password) {
		super();
		this.name = name;
		this.username_id = username_id;
		this.email=email;
		this.password=password;
	}
	public UserModel() {
	
	}
	public String getUsername_id() {
		return username_id;
	}
	public void setUsername_id(String username_id) {
		this.username_id = username_id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
