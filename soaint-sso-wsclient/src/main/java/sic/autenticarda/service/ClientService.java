/**
 * 
 */
package sic.autenticarda.service;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import sic.autenticarda.common.SimpleLogWrapping;
import sic.autenticarda.common.SoaintPropiedades;
import sic.autenticarda.model.dto.HeaderDTO;
import sic.autenticarda.model.dto.LoginDTO;
import sic.autenticarda.model.dto.RequestDTO;
import sic.autenticarda.model.dto.UserResponseDTO;

/**
 * @author ovillamil
 *
 */
public class ClientService implements IClientService {

	private SimpleLogWrapping log = new SimpleLogWrapping(this.getClass());

	private static SoaintPropiedades propiedades = new SoaintPropiedades();

	@Override
	public UserResponseDTO login(String username, String password) throws Exception {
		log.info(" \n\n login prev service Res service = " + username);

		try {
			LoginDTO login = new LoginDTO();
			
			HeaderDTO header = new HeaderDTO();
			log.info(" \n\n tokenApplication = " + propiedades.getPropiedad("tokenApplication"));
			header.setApiToken(propiedades.getPropiedad("tokenApplication"));
			login.setHeader(header);

			RequestDTO rq = new RequestDTO();
			log.info(" \n\n login" + username);
			rq.setUsername(username);
			rq.setPassword(password);
			login.setBody(rq);

			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);

			WebResource webResource = client.resource(propiedades.getPropiedad("urlApiUserLogin"));

			String input = new Gson().toJson(login).toString();
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			String responseString = response.getEntity(String.class);

			log.info(" \n\n login service Res service = " + responseString);

			return new Gson().fromJson(responseString, UserResponseDTO.class);

		} catch (Exception e) {
			System.out.println("Error login : " + e.getMessage());
			e.printStackTrace();
		}

		return new UserResponseDTO();
	}
}
