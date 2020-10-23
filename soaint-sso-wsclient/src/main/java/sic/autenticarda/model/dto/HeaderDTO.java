/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class HeaderDTO implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String apiToken;

	/**
	 * @param apiToken
	 */
	public HeaderDTO(String apiToken) {
		this.apiToken = apiToken;
	}

	/**
	 * 
	 */
	public HeaderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the apiToken
	 */
	public String getApiToken() {
		return apiToken;
	}

	/**
	 * @param apiToken the apiToken to set
	 */
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	 
	 
}
