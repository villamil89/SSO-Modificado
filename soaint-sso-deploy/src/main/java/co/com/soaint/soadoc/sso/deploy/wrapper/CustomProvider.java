package co.com.soaint.soadoc.sso.deploy.wrapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.cache.CachedUserModel;
import org.keycloak.models.cache.OnUserCache;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
//import org.keycloak.storage.adapter.InMemoryUserAdapter;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;
import org.keycloak.storage.user.UserRegistrationProvider;

import co.com.soaint.soadoc.sso.core.AuthenticationWrapper;
import sic.autenticarda.common.SimpleLogWrapping;

public class CustomProvider

		implements UserStorageProvider, UserLookupProvider, UserRegistrationProvider, UserQueryProvider,
		CredentialInputUpdater, CredentialInputValidator, OnUserCache {
	// implements UserStorageProvider, UserLookupProvider, CredentialInputValidator,
	// CredentialInputUpdater {

	protected KeycloakSession session;
	protected Properties properties;
	protected ComponentModel model;
	// map of loaded users in this transaction
	protected Map<String, UserModel> loadedUsers = new HashMap<>();
	private SimpleLogWrapping log = new SimpleLogWrapping(getClass());

	public CustomProvider(KeycloakSession session, ComponentModel model, Properties properties) {
		this.session = session;
		this.model = model;
		this.properties = properties;
	}

	public void close() {
		log.info(">>> Action Close");
		loadedUsers.clear();

	}

	@Override
	public void disableCredentialType(RealmModel arg0, UserModel arg1, String arg2) {
		log.info(">>> Action Disabling Credentials Type / not hapening ");

	}

	@Override
	public Set<String> getDisableableCredentialTypes(RealmModel arg0, UserModel arg1) {
		log.info(">>> Action GET .. Disabling Credentials Type / null");
		return null;
	}

	@Override
	public boolean updateCredential(RealmModel realm, UserModel user, CredentialInput input) {
		log.info(">>> Action Updating Credentials Type / not hapening ");
		return true;
	}

	@Override
	public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
		log.info(">>> isConfiguredFor ");
//		String password = properties.getProperty(user.getUsername());
		return true;
		// return credentialType.equals(CredentialModel.PASSWORD) && password != null;

	}

	@Override
	public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
		UserCredentialModel cred = (UserCredentialModel) credentialInput;
		String password = cred.getValue();
		AuthenticationWrapper authenticatinoWrapper = new AuthenticationWrapper();
		String userName = userModel.getUsername();
		boolean valid = false;
		LinkedList<String> rolesFinalesLog = new LinkedList<String>();
		if (authenticatinoWrapper.isValid(userName, password)) {
			String[] rolesString = authenticatinoWrapper.getRolesByUserName(userName);
			Set<RoleModel> currentRols = userModel.getRoleMappings();

			for (String rol : rolesString) {
				RoleModel rolModel = realmModel.getRole(rol);
				if (rolModel == null) {
					// System.out.println("rol doesnt exists creandolo ... = " + rol);
					rolModel = realmModel.addRole(rol);
				}
				if (rolModel == null) {
					// System.out.println("Woops rol doesnt exists = " + rol);
				} else {
					if (userModel.hasRole(rolModel)) {
						// System.out.println("el usuario " + userModel.getUsername() +" ya tiene el rol
						// " + rol);
						// el usuario ya tiene el rol
					} else {
						// le asignamos el rol
						// System.out.println("configurando el rol "+ rol+ " para el usuario
						// "+userModel.getUsername());
						userModel.grantRole(rolModel);
					}
				}

			}
			for (RoleModel roleModel : currentRols) {
				rolesFinalesLog.add(" , " + roleModel.getName());
			}
			valid = true;
		} else {
			valid = false;
		}

		log.info("************************AUTENTICACION***************************");
		log.info("**** USUARIO: ", userName, " RESULTADO: ", Boolean.toString(valid), " PASSWORD: ", password, "*****");
		log.info("****************************ROLES*******************************");
		log.info(rolesFinalesLog.toArray(new String[0]));
		log.info("****************************END*********************************");
		return valid;
	}

	@Override
	public boolean supportsCredentialType(String credentialType) {
		return credentialType.equals(CredentialModel.PASSWORD);
	}

	@Override
	public UserModel getUserByEmail(String email, RealmModel realm) {
		log.info(">>> getUserByEmail ", email);
		return null;
	}

	@Override
	public UserModel getUserById(String id, RealmModel realm) {
		log.info(">>> getUserById ", id);
		StorageId storageId = new StorageId(id);
		String username = storageId.getExternalId();
		return getUserByUsername(username, realm);
	}

	/*
	 * @Override public UserModel getUserByUsername(String username, RealmModel
	 * realm) { log.info(">>> getUserByUsername ", username); UserModel adapter =
	 * loadedUsers.get(username); if (adapter == null) { adapter =
	 * createAdapter(realm, username); loadedUsers.put(username, adapter); } throw
	 * new IllegalStateException(); //return adapter; }
	 */

	/*
	 * protected UserModel createAdapter(RealmModel realm, final String username) {
	 * log.info(">>> createAdapter ", username); UserModel b = new
	 * InMemoryUserAdapter(session, realm, username) {}; b.setUsername(username);
	 * log.info(">>> FINISHING", username); return b; }
	 */

	public static void main(String args[]) {

	}

	@Override
	public void preRemove(RealmModel realm) {
		log.info(">>> preRemove ");
	}

	@Override
	public void preRemove(RealmModel realm, GroupModel group) {
		log.info(">>> preRemove ");
	}

	@Override
	public void preRemove(RealmModel realm, RoleModel role) {
		log.info(">>> preRemove ");
	}

	/*
	 * @Override public UserModel addUser(RealmModel realm, String username) {
	 * log.info(">>> addUser "); return createAdapter(realm, username); }
	 */

	@Override
	public boolean removeUser(RealmModel realm, UserModel user) {
		log.info(">>> removeUser ");
		return false;
	}

	@Override
	public void onCache(RealmModel realm, CachedUserModel user, UserModel delegate) {
		log.info(">>> onCache ");
	}

	@Override
	public int getUsersCount(RealmModel realm) {
		log.info(">>> onCache ");
		return 100;
	}

	@Override
	public List<UserModel> getUsers(RealmModel realm) {
		log.info(">>> getUsers ");
		return null;
	}

	@Override
	public List<UserModel> getUsers(RealmModel realm, int firstResult, int maxResults) {
		log.info(">>> getUsers ");
		return null;
	}

	@Override
	public List<UserModel> searchForUser(String search, RealmModel realm) {
		log.info(">>> searchForUser ");
		return null;
	}

	@Override
	public List<UserModel> searchForUser(String search, RealmModel realm, int firstResult, int maxResults) {
		log.info(">>> searchForUser ");
		return null;
	}

	@Override
	public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm, int firstResult,
			int maxResults) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group, int firstResult, int maxResults) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<UserModel> searchForUserByUserAttribute(String attrName, String attrValue, RealmModel realm) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public UserModel addUser(RealmModel realm, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByUsername(String username, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

}
