package co.com.soaint.soadoc.sso.core;

import common.SoaintPropiedades;

public class AuthenticationWrapper {

	private StaticUserManager staticUserManager = null;
	private SoaintCustomInterface soaintCustomInterface = null;
	private SoaintPropiedades soaintPropiedades = null;
	private String[] nonstaticCommonGroup = null;

	public AuthenticationWrapper() {
		soaintPropiedades = new SoaintPropiedades();
		
		staticUserManager = new StaticUserManager(soaintPropiedades.getProperties());

		soaintCustomInterface = new SoaintCustomAuthentication();

		nonstaticCommonGroup = soaintPropiedades.getProperties().getProperty("nonstatic-common-group").split(",");
	}

	public boolean isValid(String username, String password) {
		if (staticUserManager.validateUser(username, password)) {
			return true;
		} else {
			return soaintCustomInterface.isValid(username, password);
		}
	}

	public String[] getRolesByUserName(String username) {
		String[] thaRoles = null;

		if ((thaRoles = staticUserManager.getRolesByUserName(username)) != null) {
			return thaRoles;
		} else {
			String[] rolesFromCustom = soaintCustomInterface.getRoles();
			String[] fullRoles = StaticUserManager.addArrays(rolesFromCustom, nonstaticCommonGroup);
			return fullRoles;
		}
	}

}