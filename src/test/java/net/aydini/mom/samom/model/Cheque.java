package net.aydini.mom.samom.model;

import net.aydini.mom.common.annotation.MapedField;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class Cheque {

	@MapedField(fieldName = "serial")
	private String serial;
	
	private String chequeNo;
	
	private Account account;
	
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	
	
	
}
