package sic.autenticarda.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SoaintPropiedades {

	private static Properties soaintproperties;

	private static String propertiesLocation  =  "/U01/jbpm/soaint-authertication/soaint-authertication.properties";
	

	public static void overWritePropertiesLocation(String newPropertiesLocation) {
		propertiesLocation = newPropertiesLocation;
	}

	public Properties getProperties() {
		if (soaintproperties == null) {
			Properties props = new Properties();
			File propertiesFile = new File(propertiesLocation);
			InputStream ins = null;

			try {
				if (propertiesFile.exists()) {
					ins = new FileInputStream(propertiesFile);
					props.load(ins);
				} else {
					throw new IOException("Archivo no existe " + propertiesFile.getAbsolutePath());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (ins != null)
					try {
						ins.close();
					} catch (IOException e) {
					}
			}
			
			if (props.getProperty("load-once") != null && props.getProperty("load-once").equalsIgnoreCase("true")) {
				soaintproperties = props;
			}
			
			return props;
		} else {
			return soaintproperties;
		}
	}

	public String getPropiedad(final String propiedad) {
		return getProperties().getProperty(propiedad);
	}

}
