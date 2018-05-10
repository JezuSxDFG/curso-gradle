package co.ceiba.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {

	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup() {
		emailService = Mockito.mock(EmailService.class);
		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifytest() {
		//Arrange
		Person person = new PersonTestDataBuilder().build();
		Mockito.when(emailService.sendMail(Mockito.anyString())).thenReturn("Hola Mundo");
		//Act
		String message = notifyPersonService.notify(person); 
		//
		System.out.println(message);
		//Assert
		assertNull(message);
	}

}
