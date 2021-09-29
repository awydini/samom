package net.aydini.mom.samom.model;

import java.util.Date;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.samom.maper.FamilyConverter;
import net.aydini.mom.samom.maper.ToUpperCaseMaper;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class PersonDto {

	@MapedField(fieldName = "name", maper = ToUpperCaseMaper.class)
	private String name;

	@MapedField(fieldName = "family", maper = FamilyConverter.class)
	private String family;

	private Date birthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
