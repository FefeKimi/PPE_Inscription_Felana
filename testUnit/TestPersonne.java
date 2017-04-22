package testUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestPersonne {
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p = i.createPersonne("Lemien","Lucie","LL@gmail.com");
	
	protected void setUp() throws Exception {
		Inscriptions.getInscriptions();
		p = i.createPersonne("Lemien","Lucie","LL@gmail.com");
	}

	@Test
	public void testGetEquipes() {
		assertNotNull(p.getEquipes());
	}
	
	@Test
	public void testGetPrenom() {
		assertNotNull(p.getPrenom());
	}
	
	@Test
	public void testGetMail() {
		assertNotNull(p.getMail());
	}
	
	@Test
	public void testSetPrenom() {
		String ancienPrenom = p.getNom();
		
		p.setNom("Julia");
		
		assertNotEquals(p.getNom(),ancienPrenom);
	}
	
	@Test
	public void testSetMail() {
		String ancienMail = p.getMail();
		
		p.setMail("j@gmail.com");
		
		assertNotEquals(p.getMail(),ancienMail);
	}
}
