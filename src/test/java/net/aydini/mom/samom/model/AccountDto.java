package net.aydini.mom.samom.model;

import java.math.BigDecimal;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class AccountDto {

	private String accountNo;

	private BigDecimal balance;

	private PersonDto owner;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public PersonDto getOwner() {
		return owner;
	}

	public void setOwner(PersonDto owner) {
		this.owner = owner;
	}

}
