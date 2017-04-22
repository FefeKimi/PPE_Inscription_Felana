package testUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetitions {
	Equipe e;
	Personne p;
	Inscriptions i = Inscriptions.getInscriptions();
	Competition compet = i.createCompetition("Tennis",LocalDate.of(2017,Month.APRIL,14),true);

	protected void setUp() throws Exception
	{
		i = Inscriptions.getInscriptions();
		compet = i.createCompetition("Tennis",null,true);
		p = i.createPersonne("Daurelle","Jul","j@gmail.com");
		
	}
	
	@Test
	public void testAddCandidat() {
		compet.add(p);
		p = (Personne) ((SortedSet<Candidat>) compet.getCandidats()).first();
		assertEquals(p.getNom(),"Daurelle");
		assertEquals(p.getPrenom(),"Jul");
		assertEquals(p.getMail(),"j@gmail.com");
	}
	
	@Test
	public void testRemoveCandidat() {
		compet.add(p);
		compet.remove(p);
		p = (Personne) ((SortedSet<Candidat>) compet.getCandidats()).first();
		assertNotEquals(p.getNom(),"Daurelle");
		assertNotEquals(p.getPrenom(),"Jul");
		assertNotEquals(p.getMail(),"j@gmail.com");
	}
	
	@Test
	public void testDelete() {
		compet.delete();
		Competition c = (Competition) i.getCompetitions().first();
		assertNotEquals(c.getNom(), "Tennis");
		assertEquals(c.getDateCloture(),LocalDate.of(2017,Month.APRIL,10));
		assertEquals(c.estEnEquipe(), true);
	}
	
	@Test
	public void testCompareTo() {
		Competition compet2 = i.createCompetition("golf", null, false);
		assertNotNull(compet.compareTo(compet2));
	}

	
	@Test
	public void estEnEquipe() {
		assert(compet.estEnEquipe());
	}
	
	@Test
	public void testGetCandidats() {
		assertNotNull(compet.getCandidats());
	}
	
	
	@Test
	public void testInscriptionsOuvertes() {
		assert(compet.inscriptionsOuvertes());
	}
	
	@Test
	public void testRemove() {
		assert(compet.remove(e));
	}
	
	@Test
	public void testSetDateCloture() {
		compet.setDateCloture(LocalDate.of(2017,Month.APRIL,10));
		assertEquals(compet.getDateCloture(),LocalDate.of(2017,Month.APRIL,10));
	}
	
	@Test
	public void testSetNom() {
		String ancienNom = compet.getNom();
		
		compet.setNom("Basket");
		
		assertNotEquals(compet.getNom(),ancienNom);
	}
	
	
	
}
package testUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetitions {
	Equipe e;
	Personne p;
	Inscriptions i = Inscriptions.getInscriptions();
	Competition compet = i.createCompetition("Tennis",LocalDate.of(2017,Month.APRIL,14),true);

	protected void setUp() throws Exception
	{
		i = Inscriptions.getInscriptions();
		compet = i.createCompetition("Tennis",null,true);
		p = i.createPersonne("Daurelle","Jul","j@gmail.com");
		
	}
	
	@Test
	public void testAddCandidat() {
		compet.add(p);
		p = (Personne) ((SortedSet<Candidat>) compet.getCandidats()).first();
		assertEquals(p.getNom(),"Daurelle");
		assertEquals(p.getPrenom(),"Jul");
		assertEquals(p.getMail(),"j@gmail.com");
	}
	
	@Test
	public void testRemoveCandidat() {
		compet.add(p);
		compet.remove(p);
		p = (Personne) ((SortedSet<Candidat>) compet.getCandidats()).first();
		assertNotEquals(p.getNom(),"Daurelle");
		assertNotEquals(p.getPrenom(),"Jul");
		assertNotEquals(p.getMail(),"j@gmail.com");
	}
	
	@Test
	public void testDelete() {
		compet.delete();
		Competition c = (Competition) i.getCompetitions().first();
		assertNotEquals(c.getNom(), "Tennis");
		assertEquals(c.getDateCloture(),LocalDate.of(2017,Month.APRIL,10));
		assertEquals(c.estEnEquipe(), true);
	}
	
	@Test
	public void testCompareTo() {
		Competition compet2 = i.createCompetition("golf", null, false);
		assertNotNull(compet.compareTo(compet2));
	}

	
	@Test
	public void estEnEquipe() {
		assert(compet.estEnEquipe());
	}
	
	@Test
	public void testGetCandidats() {
		assertNotNull(compet.getCandidats());
	}
	
	
	@Test
	public void testInscriptionsOuvertes() {
		assert(compet.inscriptionsOuvertes());
	}
	
	@Test
	public void testRemove() {
		assert(compet.remove(e));
	}
	
	@Test
	public void testSetDateCloture() {
		compet.setDateCloture(LocalDate.of(2017,Month.APRIL,10));
		assertEquals(compet.getDateCloture(),LocalDate.of(2017,Month.APRIL,10));
	}
	
	@Test
	public void testSetNom() {
		String ancienNom = compet.getNom();
		
		compet.setNom("Basket");
		
		assertNotEquals(compet.getNom(),ancienNom);
	}
	
	
	
}
