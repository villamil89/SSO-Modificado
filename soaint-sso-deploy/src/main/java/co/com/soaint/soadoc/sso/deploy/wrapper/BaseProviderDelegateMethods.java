package co.com.soaint.soadoc.sso.deploy.wrapper;

import java.util.HashSet;
import java.util.Set;

import org.keycloak.credential.CredentialInput;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;

import co.com.soaint.soadoc.sso.core.AuthenticationWrapper;
import common.SimpleLogWrapping;

public class BaseProviderDelegateMethods {


	private static SimpleLogWrapping log = new SimpleLogWrapping(BaseProviderDelegateMethods.class.getClass());
	
	public static boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {		
		UserCredentialModel cred = (UserCredentialModel) credentialInput;
		String password = cred.getValue();
		AuthenticationWrapper authenticatinoWrapper = new AuthenticationWrapper();
		String userName = userModel.getUsername();
				boolean valid = false;		
		Set<RoleModel> rolesRealm = new HashSet<RoleModel>(); ;
		String[] rolesString = authenticatinoWrapper.getRolesByUserName(userName);
		log.info("+++++++++++++++++++++++++++++++++++++++++++");
		if (authenticatinoWrapper.isValid(userName, password)) {
			for (String rol : rolesString) {
				RoleModel rolModel  = realmModel.getRole(rol);
				if(rolModel==null) {
					log.info("rol doesnt exists", rol);
					rolModel = realmModel.addRole(rol);
				}
				if(rolModel==null) {
					log.info("IS DEAD JIM .....", rol);					
				}else {
					if(userModel.hasRole(rolModel)) {
						log.info("already exists usuario: ", userName, " rol: ", rol);
					}else {
						log.info("granting role: ", userName, " rol: ", rol);
						userModel.grantRole(rolModel);	
					}
				}

			}			
			valid =true;
		}else {
			valid = false;	
		}
		log.info("+++++++++++++++++++++++++++++++++++++++++++");
		rolesRealm = userModel.getRoleMappings();
		log.info("************************AUTENTICACION***************************");
		log.info("**** USUARIO: ", userName, " RESULTADO: ", Boolean.toString(valid), " PASSWORD: ", password, "*****");
		log.info("****************************REQUEST ROLES****************************");
		for(String rol: rolesString) {
			log.info("***"+rol+"***");
		}
		log.info("***********************ROLES DEL REALM**************************");
		for(RoleModel rol: rolesRealm) {
			log.info("Nombre: ", rol.getName(), " Descripcion: ", rol.getDescription());
		}
		log.info("****************************END*********************************");
		
		return valid;
	}
}
