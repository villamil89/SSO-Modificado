package co.com.soaint.soadoc.sso.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import sic.autenticarda.common.SimpleLogWrapping;

public class SoaintCustomAuthenticationSystemCaller {
	
	public static void main(String args[]) {
		String invokeType = args[0];
		String username=args[1];		
		JsonObject authenticationResult = new JsonObject();
		ByteArrayOutputStream logOut = new ByteArrayOutputStream();
		PrintStream  logPoutput = new PrintStream(logOut);
		SimpleLogWrapping.setStream(new PrintStream(logOut));
		try {
			SoaintCustomAuthentication soaintCustomAuthentication = new SoaintCustomAuthentication();
			if(invokeType.equalsIgnoreCase("user")) {
				String password=args[2];
				if(soaintCustomAuthentication.isValid(username, password)) {
					authenticationResult.addProperty("validUser", true);
				}else {
					authenticationResult.addProperty("validUser", false);
				}
			}else {
				String[] roles = soaintCustomAuthentication.getRoles();
				if(roles == null) {
					roles = new String [] {
							"no-role", "undefine"
					};
					
				}
				JsonArray array = new JsonArray();
				for (String rol : roles) {
					array.add(rol);
				}
				authenticationResult.add("roles", array);
			}
			authenticationResult.addProperty("errors", false);
		}catch(Exception e) {
			JsonObject exception = new JsonObject();
			exception.addProperty("message", e.getMessage());
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			PrintWriter exceptionPout = new PrintWriter(bout);
			e.printStackTrace(exceptionPout);
			try{
				exceptionPout.flush();
				bout.flush();
			}catch(Exception ignored) {}
			exception.addProperty("stacktrace", new String(bout.toByteArray()));
			authenticationResult.addProperty("errors", true);
			authenticationResult.add("exception", exception);
		}
		try {
			logPoutput.flush();
		}catch(Exception ignored) {}
		authenticationResult.addProperty("log", new String(logOut.toByteArray()));
		System.out.println(authenticationResult.toString());
	}

}

