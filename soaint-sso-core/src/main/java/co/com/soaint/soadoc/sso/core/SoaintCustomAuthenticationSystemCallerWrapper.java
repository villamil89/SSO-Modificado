package co.com.soaint.soadoc.sso.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import sic.autenticarda.common.SimpleLogWrapping;

public class SoaintCustomAuthenticationSystemCallerWrapper implements SoaintCustomInterface {
	

	private String javaExecLocation = "/usr/lib/jvm/java-1.8.0-openjdk/bin/java";
	private String jarLocation = "/opt/eap/standalone/deployments/soaint-sso-custom-login.jar";
	private String userCommand = "user";
	private String roleCommand = "rol";
	
	private static SimpleLogWrapping log = new SimpleLogWrapping(SoaintCustomAuthenticationSystemCallerWrapper.class.getClass());
	
	///opt/eap/standalone/deployments/soaint-sso-custom-login-jar-with-dependencies.jar
	
	public static void generateCommonLogs(JsonObject authenticationResult) {
		if(authenticationResult.has("exception")) {
			JsonObject exception =  authenticationResult.getAsJsonObject("exception");
			if(exception.has("message")&& (!exception.get("message").isJsonNull())) {
				log.err("Exceptin Message: ", exception.get("message").getAsString());
			}
			if(exception.has("stacktrace")&& (!exception.get("stacktrace").isJsonNull())) {
				log.err("Exception Stack: ",  exception.get("stacktrace").getAsString());
			}
		}
		if(authenticationResult.has("log")) {
			log.info("LOG: ",authenticationResult.get("log").getAsString());
		}
	}
	
    public String[] getRolesByUserName(String username) {
    	String [] parameters = {
				javaExecLocation,
				"-jar",
				jarLocation,
				roleCommand,
				username
		};
		try {
			String output = executeJava(parameters);
			Gson gson = new Gson();
			JsonObject authenticationResult = gson.fromJson(output, JsonObject.class);
			generateCommonLogs(authenticationResult);
			if(authenticationResult.has("roles")) {
				 JsonArray rolesAsJsonArray = authenticationResult.getAsJsonArray("roles");
				 LinkedList<String> rolesAsLinkedList = new LinkedList<String>();
				 for (JsonElement jsonElement : rolesAsJsonArray) {
					 String rol = jsonElement.getAsString();
					 log.info("leyendo rol remoto: ", rol);
					 rolesAsLinkedList.add(rol);
				}
				String [] finalResult  = null;
				finalResult = rolesAsLinkedList.toArray(new String[] {});
				return finalResult;
			}else {
				log.err("error desconocido no vienen roles");
				return null;
			}
	     			
		}catch(Exception e) {
			log.err(e, "error en la ejecucion remota");
			return null;
		}
		
	}
	
	public boolean isValid(String username, String password) {
		String [] parameters = {
				javaExecLocation,
				"-jar",
				jarLocation,
				userCommand,
				username,
				password
		};
		try {
			String output = executeJava(parameters);
			Gson gson = new Gson();
			JsonObject authenticationResult = gson.fromJson(output, JsonObject.class);
			generateCommonLogs(authenticationResult);
			return authenticationResult.get("validUser").getAsBoolean();
	     			
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public static void main(String args[]) {
		SoaintCustomAuthenticationSystemCallerWrapper wrapper = new SoaintCustomAuthenticationSystemCallerWrapper();
		//wrapper.setJarLocation("/cool/rinzler/co/soaint/ImplementacionSSO/soaint-sso-deploy/target/soaint-sso-custom-login.jar");
		wrapper.setJarLocation("/cool/rinzler/co/soaint/sso/ImplementacionSSO/soaint-sso-deploy/target/soaint-sso-custom-login.jar");
		wrapper.setJavaExecLocation("/opt/portable/rh/jdk/java-1.8.0-openjdk-1.8.0.232.b09-0.static.jdk.openjdkportable.x86_64/bin/java");
//		wrapper.isValid("juan", "juan");
		wrapper.getRolesByUserName("juan");
		
	}

	public String getJavaExecLocation() {
		return javaExecLocation;
	}

	public void setJavaExecLocation(String javaExecLocation) {
		this.javaExecLocation = javaExecLocation;
	}

	public String getJarLocation() {
		return jarLocation;
	}

	public void setJarLocation(String jarLocation) {
		this.jarLocation = jarLocation;
	}

	public String getUserCommand() {
		return userCommand;
	}

	public void setUserCommand(String userCommand) {
		this.userCommand = userCommand;
	}

	public String getRoleCommand() {
		return roleCommand;
	}

	public void setRoleCommand(String roleCommand) {
		this.roleCommand = roleCommand;
	}

	
	
	///usr/lib/jvm/java-1.8.0-openjdk/bin/java -cp /opt/eap/standalone/deployments/soaint-sso-custom-login-jar-with-dependencies.jar co.com.soaint.soadoc.sso.core.SoaintCustomAuthenticationSystemCaller user  jorge jorge
	public String executeJava(String[] params) {
		List<String> parameters = new LinkedList<String>();
		for (String param : params) {
			parameters.add(param);
		}
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command(parameters);
		StringBuilder output = new StringBuilder();
		try {
			Process process = processBuilder.start();			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			int exitVal = process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = output.toString();
		log.info("resultado como json: ", result);
		return result;
	}

	@Override
	public String[] getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
