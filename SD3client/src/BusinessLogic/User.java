package BusinessLogic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	
	int id;
	String username;
	String password;
	String role;

	public User(int id, String username, String password, String role){
		this.id=id;
		this.username=username;
		this.password=password;	
		this.role=role;		
	}
	public User(String username, String password, String role)
	{
		this.username=username;
		this.password=password;	
		this.role=role;	
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}



	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	
}
