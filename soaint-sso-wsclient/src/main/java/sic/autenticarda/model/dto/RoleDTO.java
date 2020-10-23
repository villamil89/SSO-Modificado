/**
 * 
 */
package sic.autenticarda.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author ovillamil
 *
 */
public class RoleDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codeAuthApplication;
	
    private String nameAuthApplication;
    
    private String id;
    
    private String description;
    
    private String name;
    
    private Boolean enabled;
    
    private List<PrivilegeDTO> privileges;

	/**
	 * @param codeAuthApplication
	 * @param nameAuthApplication
	 * @param id
	 * @param description
	 * @param name
	 * @param enabled
	 * @param privileges
	 */
	public RoleDTO(String codeAuthApplication, String nameAuthApplication, String id, String description, String name,
			Boolean enabled, List<PrivilegeDTO> privileges) {
		this.codeAuthApplication = codeAuthApplication;
		this.nameAuthApplication = nameAuthApplication;
		this.id = id;
		this.description = description;
		this.name = name;
		this.enabled = enabled;
		this.privileges = privileges;
	}

	/**
	 * 
	 */
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codeAuthApplication
	 */
	public String getCodeAuthApplication() {
		return codeAuthApplication;
	}

	/**
	 * @param codeAuthApplication the codeAuthApplication to set
	 */
	public void setCodeAuthApplication(String codeAuthApplication) {
		this.codeAuthApplication = codeAuthApplication;
	}

	/**
	 * @return the nameAuthApplication
	 */
	public String getNameAuthApplication() {
		return nameAuthApplication;
	}

	/**
	 * @param nameAuthApplication the nameAuthApplication to set
	 */
	public void setNameAuthApplication(String nameAuthApplication) {
		this.nameAuthApplication = nameAuthApplication;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the privileges
	 */
	public List<PrivilegeDTO> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(List<PrivilegeDTO> privileges) {
		this.privileges = privileges;
	}

}
