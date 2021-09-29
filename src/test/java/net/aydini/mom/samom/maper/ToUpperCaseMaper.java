package net.aydini.mom.samom.maper;

import net.aydini.mom.common.service.maper.Maper;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */


public class ToUpperCaseMaper implements Maper<String, String>{

	@Override
	public String map(String input) {
		if(input != null)
			return input.toUpperCase();
		return null;
	}

}
