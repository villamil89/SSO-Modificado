package co.com.soaint.soadoc.sso.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import sic.autenticarda.common.SimpleLogWrapping;

public class StaticUserManager {

	private SimpleLogWrapping log = new SimpleLogWrapping(this.getClass());

	public Properties lastProperties = null;
	private String[] businessUsers = null;
	private String[] allUsers = null;
	private String[] kieUsers = null;
	private Map<String, String[]> roles = null;
	private Map<String, String> passwords = null;
	private Boolean logPasswords = null;

	public static String[] addArrays(String[] array1, String[] array2) {
		String[] returnValue = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, returnValue, 0, array1.length);
		System.arraycopy(array2, 0, returnValue, array1.length, array2.length);
		return returnValue;

	}

	public StaticUserManager(Properties prop) {
		updateProperties(prop);
	}

	public void updateProperties(Properties properties) {
		lastProperties = properties;
		String showPasswordAsString = null;
		if ((showPasswordAsString = properties.getProperty("show-password")) != null
				&& showPasswordAsString.equalsIgnoreCase("true")) {
			logPasswords = true;
		} else {
			logPasswords = false;
		}

		businessUsers = properties.getProperty("static-users-business").split(",");
		Arrays.sort(businessUsers);

		kieUsers = properties.getProperty("static-users-kie").split(",");
		Arrays.sort(kieUsers);

		allUsers = addArrays(businessUsers, kieUsers);
		Arrays.sort(allUsers);

		// Map Construction for password
		passwords = new HashMap<String, String>();
		for (String user : allUsers) {
			String password = properties.getProperty("password-for-" + user);
			if (password != null) {
				passwords.put(user, password);
			}
		}

		// Map Construction for roles
		roles = new HashMap<String, String[]>();
		for (String user : allUsers) {
			String groups = properties.getProperty("groups-for-" + user);
			if (groups != null) {
				roles.put(user, groups.split(","));
			}
		}
	}

	public String[] getRolesByUserName(String username) {
		log.info("buscando usuario: ", username);
		return roles.get(username);
	}

	public boolean validateUser(String username, String password) {
		log.info("validando usuario ", username);
		if (logPasswords) {
			log.info("password utilizado por usuario : ", username, " password: ", password);
		}
		if (Arrays.binarySearch(allUsers, username) < 0) {
			return false;
		}
		if (passwords.containsKey(username)) {
			return passwords.get(username).equals(password);
		} else {
			return true;
		}
	}

}
