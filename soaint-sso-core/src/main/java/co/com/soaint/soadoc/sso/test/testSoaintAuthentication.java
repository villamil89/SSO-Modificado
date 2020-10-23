package co.com.soaint.soadoc.sso.test;

import co.com.soaint.soadoc.sso.core.SoaintCustomAuthentication;

public class testSoaintAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usiario = "pruebasoaint2";
		String password = "Soaint2@";

		boolean Resp = false;

		SoaintCustomAuthentication CustomAuthen = new SoaintCustomAuthentication();

		System.out.println("Validando las Credenciales");
		Resp = CustomAuthen.isValid(usiario, password);

		System.out.println("Resp = " + Resp);
		if (Resp) {
			System.out.println("El usuario y la Contrase�a ingresada son Validos...");
			System.out.println("Buscando Roles");
			String[] roles = CustomAuthen.getRoles();
			System.out.println("roles: " + roles);
		} else {
			System.out.println("!!! No son validad el usuario y la Contrase�a ingresada !!!");
		}
	}

}
