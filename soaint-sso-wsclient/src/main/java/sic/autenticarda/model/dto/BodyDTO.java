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
public class BodyDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<RoleDTO> roles;
	
    private String token;
    
    private String id;
    
    private String userName;
    
    private String name;
    
    private String email;
    
    private String phoneNumber;
    
    private String organization;
    
    private boolean enabled;
    
    private boolean lockoutEnabled;
    
    private String lockoutEndDateUtc;
    
    private String ldapGuid;

	/**
	 * @param roles
	 * @param token
	 * @param id
	 * @param userName
	 * @param name
	 * @param email
	 * @param phoneNumber
	 * @param organization
	 * @param enabled
	 * @param lockoutEnabled
	 * @param lockoutEndDateUtc
	 * @param ldapGuid
	 */
	public BodyDTO(List<RoleDTO> roles, String token, String id, String userName, String name, String email,
			String phoneNumber, String organization, boolean enabled, boolean lockoutEnabled, String lockoutEndDateUtc,
			String ldapGuid) {
		this.roles = roles;
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.organization = organization;
		this.enabled = enabled;
		this.lockoutEnabled = lockoutEnabled;
		this.lockoutEndDateUtc = lockoutEndDateUtc;
		this.ldapGuid = ldapGuid;
	}

	/**
	 * 
	 */
	public BodyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the roles
	 */
	public List<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the lockoutEnabled
	 */
	public boolean isLockoutEnabled() {
		return lockoutEnabled;
	}

	/**
	 * @param lockoutEnabled the lockoutEnabled to set
	 */
	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	/**
	 * @return the lockoutEndDateUtc
	 */
	public String getLockoutEndDateUtc() {
		return lockoutEndDateUtc;
	}

	/**
	 * @param lockoutEndDateUtc the lockoutEndDateUtc to set
	 */
	public void setLockoutEndDateUtc(String lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	/**
	 * @return the ldapGuid
	 */
	public String getLdapGuid() {
		return ldapGuid;
	}

	/**
	 * @param ldapGuid the ldapGuid to set
	 */
	public void setLdapGuid(String ldapGuid) {
		this.ldapGuid = ldapGuid;
	}
    
}
