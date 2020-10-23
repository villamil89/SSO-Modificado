package co.com.soaint.soadoc.sso.core;

public interface SoaintCustomInterface {
	
	boolean isValid(String username, String password);
	
	String[] getRoles();

	String[] getRolesByUserName(String username);
}
