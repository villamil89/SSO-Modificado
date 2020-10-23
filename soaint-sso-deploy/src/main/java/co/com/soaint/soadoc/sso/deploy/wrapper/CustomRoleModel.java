package co.com.soaint.soadoc.sso.deploy.wrapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.keycloak.models.RoleContainerModel;
import org.keycloak.models.RoleModel;

public class CustomRoleModel implements RoleModel{

	private String name;
	private String description;
	private String id;
	
	
	public CustomRoleModel() {
		super();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public boolean isComposite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addCompositeRole(RoleModel role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCompositeRole(RoleModel role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<RoleModel> getComposites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientRole() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getContainerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleContainerModel getContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasRole(RoleModel role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String name, Collection<String> values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFirstAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
