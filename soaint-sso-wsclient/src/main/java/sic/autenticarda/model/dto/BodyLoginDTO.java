/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class BodyLoginDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
    private Integer status;
    
    private BodyDTO body;

	/**
	 * @param message
	 * @param status
	 * @param body
	 */
	public BodyLoginDTO(String message, Integer status, BodyDTO body) {
		this.message = message;
		this.status = status;
		this.body = body;
	}

	/**
	 * 
	 */
	public BodyLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the body
	 */
	public BodyDTO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(BodyDTO body) {
		this.body = body;
	}
    
}
