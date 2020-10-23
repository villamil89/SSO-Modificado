/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class LoginDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HeaderDTO header;

	private RequestDTO body;

	/**
	 * @param header
	 * @param body
	 */
	public LoginDTO(HeaderDTO header, RequestDTO body) {
		this.header = header;
		this.body = body;
	}

	/**
	 * 
	 */
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the header
	 */
	public HeaderDTO getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(HeaderDTO header) {
		this.header = header;
	}

	/**
	 * @return the body
	 */
	public RequestDTO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(RequestDTO body) {
		this.body = body;
	}
	
}
