package testUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCandidat {
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p = i.createPersonne("Julien","Jul","j@gmail.com");
	
	protected void setUp() throws Exception
	{
		i = Inscriptions.getInscriptions();
		p = i.createPersonne("Julien","Jul","j@gmail.com");
	}
	
	@Test
	public void testCompareTo() {
		Personne p2 =i.createPersonne("Karim","Karis","j@gmail.com");
		assertNotNull(p.compareTo(p2));
	}
	
	@Test
	public void testDelete() {
		p.delete();
	}

	@Test
	public void testGetCompetitions() {
		assertNotNull(p.getCompetitions());
	}
	
	@Test
	public void testGetNom() {
		assertNotNull(p.getNom());
	}
	
	@Test
	public void testGetSetNom() {
		String nom = p.getNom();
		p.setNom("Felana");
		
		assertNotEquals(p.getNom(),nom);
	}
	

}
