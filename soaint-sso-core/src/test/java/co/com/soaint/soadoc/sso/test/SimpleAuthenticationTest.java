package co.com.soaint.soadoc.sso.test;

import co.com.soaint.soadoc.sso.core.AuthenticationWrapper;
import sic.autenticarda.common.SimpleLogWrapping;
import sic.autenticarda.common.SoaintPropiedades;

public class SimpleAuthenticationTest {

	
	
	public static void main(String[] args) {
		SimpleLogWrapping log = new SimpleLogWrapping(SimpleAuthenticationTest.class.getClass()); 
		
		SoaintPropiedades.overWritePropertiesLocation("src/main/resources/soaint-sic-authertication.properties");
		AuthenticationWrapper  authenticationWrapper  = new AuthenticationWrapper();
		
		log.info("autenticacion de super-admin : " ,  (new Boolean(authenticationWrapper.isValid("super-admin", "not really a password"))).toString() ) ;
		log.info("roles asociados : ", log.compoundMessage(authenticationWrapper.getRolesByUserName("super-admin")) );
		
		//
		log.info("autenticacion de super-admin : " ,  (new Boolean(authenticationWrapper.isValid("jose", "not really a password"))).toString() ) ;
		log.info("roles asociados : ", log.compoundMessage(authenticationWrapper.getRolesByUserName("jose")) );

	}

}
