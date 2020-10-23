/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class PrivilegeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
    private String name;
    
    private String code;
    
    private Boolean enabled;

	/**
	 * @param id
	 * @param name
	 * @param code
	 * @param enabled
	 */
	public PrivilegeDTO(String id, String name, String code, Boolean enabled) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.enabled = enabled;
	}

	/**
	 * 
	 */
	public PrivilegeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
