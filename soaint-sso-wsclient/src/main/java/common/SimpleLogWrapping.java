package common;

import java.io.PrintStream;

public class SimpleLogWrapping {
	
	private Class<?> clazz;

	private static PrintStream stream = System.out;
	
	
	
	public static PrintStream getStream() {
		return stream;
	}

	public static void setStream(PrintStream stream) {
		SimpleLogWrapping.stream = stream;
	}

	public SimpleLogWrapping(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}

	public void debug(String ...message) {
		debug(clazz,message);
	}
	
	public void info(String ...message) {
		info(clazz, message);
	}
	
	public static String compoundMessage(String ...message) {
		StringBuffer buffer = new StringBuffer();
		for (String msg : message) {
			buffer.append(msg);
		}
		return buffer.toString();
	}
	
	public void err(Throwable e, String ...message) {
		err(clazz, e, compoundMessage(message));
	}
	
	public void err(String ...message) {
		err(clazz, compoundMessage(message));
	}

	
	public static void debug(Class<?> clazz, String ...message)  {		
		getStream().println(compoundMessage(message));
		
	}
	
	public static void info(Class<?> clazz, String ...message) {
		getStream().println(compoundMessage(message));
	}

	public static void err(Class<?> clazz,   String ...message) {		
		getStream().println(compoundMessage(message));
	}
	
	
	public static void err(Class<?> clazz,  Throwable e , String ...message) {
		e.printStackTrace(getStream());
		getStream().println(compoundMessage(message));
	}

}
