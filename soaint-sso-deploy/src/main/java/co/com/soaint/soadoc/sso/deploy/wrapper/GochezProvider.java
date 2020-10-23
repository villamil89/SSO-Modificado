package co.com.soaint.soadoc.sso.deploy.wrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.UserModelDelegate;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

import sic.autenticarda.common.SimpleLogWrapping;



public class GochezProvider
		implements UserStorageProvider, UserLookupProvider, CredentialInputValidator, CredentialInputUpdater {

	protected KeycloakSession session;
	protected Properties properties;
	protected ComponentModel model;
	// map of loaded users in this transaction
	protected Map<String, UserModel> loadedUsers = new HashMap<>();
	private SimpleLogWrapping log = new SimpleLogWrapping(getClass());

	public GochezProvider(KeycloakSession session, ComponentModel model, Properties properties) {
		this.session = session;
		this.model = model;
		this.properties = properties;
	}

	public void close() {
		// TODO Auto-generated method stub
		loadedUsers.clear();

	}

	@Override
	public void disableCredentialType(RealmModel arg0, UserModel arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getDisableableCredentialTypes(RealmModel arg0, UserModel arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public boolean updateCredential(RealmModel realm, UserModel user, CredentialInput input) {
		// if (input.getType().equals(CredentialModel.PASSWORD)) throw new
		// ReadOnlyException("user is read only for this update");
		// vamos a probar que actualize los permisos a la fuerza
		return true;
	}

	@Override
	public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
		String password = properties.getProperty(user.getUsername());
		return true;
		// return credentialType.equals(CredentialModel.PASSWORD) && password != null;

	}

	@Override
	public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {		
		return BaseProviderDelegateMethods.isValid(realmModel, userModel, credentialInput);
	}

	@Override
	public boolean supportsCredentialType(String credentialType) {
		return credentialType.equals(CredentialModel.PASSWORD);
	}

	@Override
	public UserModel getUserByEmail(String email, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserById(String id, RealmModel realm) {
		StorageId storageId = new StorageId(id);
		String username = storageId.getExternalId();
		return getUserByUsername(username, realm);
	}

	@Override
	public UserModel getUserByUsername(String username, RealmModel realm) {
		System.out.println("GOING BY getuser");
		UserModel adapter = loadedUsers.get(username);
		if (adapter == null) {
			// String password = properties.getProperty(username);
			// if (password != null) {
			adapter = createAdapter(realm, username);
			loadedUsers.put(username, adapter);
			// }
		}
		return adapter;
	}

	protected UserModel createAdapter(RealmModel realm, final String username) {
		//revisamos en el local storage si el usuario ya existe
				//primero lo intentamos obtener del UserLocalStorage dela sesion
				UserModel local = session.userLocalStorage().getUserByUsername(username, realm);		
				//si el usuario no existe, entonces lo agregamos al local storage
				if (local == null) {
		            local = session.userLocalStorage().addUser(realm, username);
		            local.setEnabled(true);		           
		            local.setFederationLink(model.getId());
		        }
				if(!local.isEnabled()) {
					local.setEnabled(true);
				}
				
				
				return new UserModelDelegate(local) {
					
					public void grantRole(RoleModel rol) {
						session.userFederatedStorage().grantRole(realm, username, rol);
					}
				};
	}

}
