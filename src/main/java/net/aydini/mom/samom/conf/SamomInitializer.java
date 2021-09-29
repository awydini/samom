package net.aydini.mom.samom.conf;

import javax.annotation.PostConstruct;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import net.aydini.mom.samom.holder.ApplicationContextHolder;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */


@Component
public class SamomInitializer {
	
	private ConfigurableApplicationContext applicationContext;

	public SamomInitializer(ConfigurableApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	
	@PostConstruct
	public void init()
	{
		ApplicationContextHolder.setApplicationContext(applicationContext);
	}
	
	
}
