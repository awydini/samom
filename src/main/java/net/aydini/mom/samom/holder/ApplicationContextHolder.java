package net.aydini.mom.samom.holder;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class ApplicationContextHolder {
	
	
	private static ConfigurableApplicationContext applicationContext;

	public static ConfigurableApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
		ApplicationContextHolder.applicationContext = applicationContext;
	}
	
	
	

}
