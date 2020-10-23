/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class RequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;

	/**
	 * @param username
	 * @param password
	 */
	public RequestDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * 
	 */
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
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
}
