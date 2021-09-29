package net.aydini.mom.samom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import net.aydini.mom.samom.maper.SpringAwareObjectMapper;
import net.aydini.mom.samom.model.Account;
import net.aydini.mom.samom.model.Cheque;
import net.aydini.mom.samom.model.ChequeDto;
import net.aydini.mom.samom.model.Person;

@SpringBootTest
class SamomApplicationTests {

	
	
	private Cheque cheque;
	
	
	@BeforeEach
	public void init()
	{
		Person owner = new Person();
		owner.setBirthDate(new Date());
		owner.setName("Aydin");
		owner.setFamily("Nasrollahpour");
		
		
		Account account = new Account();
		account.setBalance(BigDecimal.ONE);
		account.setOwner(owner);
		account.setAccountNo(null);
		
		cheque = new Cheque();
		cheque.setChequeNo("123456");
		cheque.setSerial("serial");
		cheque.setAccount(account);
		
		
	}
	
	@Test
	void contextLoads() {
	
		ChequeDto chequeDto = new SpringAwareObjectMapper().map(cheque, ChequeDto.class);
		
		assertNotNull(chequeDto);
		assertNotNull(chequeDto.getAccount());
		assertNotNull(chequeDto.getAccount().getOwner());
		
		assertEquals(cheque.getSerial(), chequeDto.getSerial());
		assertEquals(cheque.getChequeNo(), chequeDto.getChequeNo());
		
		assertEquals(cheque.getAccount().getBalance(), chequeDto.getAccount().getBalance());
		assertEquals(cheque.getAccount().getAccountNo(), chequeDto.getAccount().getAccountNo());
		
		
		assertEquals(cheque.getAccount().getOwner().getName().toUpperCase(), chequeDto.getAccount().getOwner().getName());
		String expectedFamily = cheque.getAccount().getOwner().getFamily() +cheque.getAccount().getOwner().getFamily();
		assertEquals(expectedFamily, chequeDto.getAccount().getOwner().getFamily());
		assertEquals(cheque.getAccount().getOwner().getBirthDate(), chequeDto.getAccount().getOwner().getBirthDate());
		
	}

}
