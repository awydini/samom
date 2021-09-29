package net.aydini.mom.samom.maper;

import org.springframework.stereotype.Component;

import net.aydini.mom.common.service.maper.Maper;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */


@Component
public class FamilyConverter implements Maper<String, String>{

	@Override
	public String map(String input) {
        System.out.println("mapping with SpringAwareEntityMapper is fun!!!");
        if(input==null )
        	return null;
        return input+input;
	}

}
