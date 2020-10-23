package co.com.soaint.soadoc.sso.core;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import common.SimpleLogWrapping;
import sic.autenticarda.model.dto.RoleDTO;
import sic.autenticarda.model.dto.UserResponseDTO;
import sic.autenticarda.service.IClientService;

public class SoaintCustomAuthentication implements SoaintCustomInterface {

	private UserResponseDTO response;

	private SimpleLogWrapping log = new SimpleLogWrapping(this.getClass());

	private IClientService service;

	public boolean isValid(String username, String password) {
		log.info("ejecutando validacion real de usuario : ", username);

		try {
			response = service.login(username, password);

			if (response.getStatus().equals("OK") && response.getBody().getBody().isEnabled()) {
				log.info(" \n\n SoaintCustomAuthentication Se logueo correctamente  = " + username + " - " + password);
				return Boolean.TRUE;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.info(" \n\n Error isValid  = " + username + " - " + password + " \n\n" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.info("Error" + e.getMessage());
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}

	public String[] getRoles() {
		try {
			List<String> listRoles = new ArrayList<String>();

			for (RoleDTO rol : response.getBody().getBody().getRoles()) {
				listRoles.add(rol.getName());
			}
			
			listRoles.add("process-admin");
			listRoles.add("manager");
			listRoles.add("admin");
			listRoles.add("analyst");
			listRoles.add("rest-all");
			listRoles.add("developer");
			listRoles.add("rest-project");
			listRoles.add("user");

			String[] resprole = listRoles.toArray(new String[listRoles.size()]);
			
			log.info("Roles" + resprole);
			
			return resprole;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}