package testUnit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import org.junit.Before;
import org.junit.Test;

public class TestInscription extends TestCase {
	Inscriptions i ;
	SortedSet<Candidat> candidats;
	SortedSet<Competition> compets;
	Personne p;
	
	protected void setUp() throws Exception
	{
		Inscriptions.SERIALIZE = true;
		i = Inscriptions.getInscriptions();
		candidats = i.getCandidats();
		compets = i.getCompetitions();
		Personne p  = i.createPersonne("Dupuis", "Michel", "dm@gmail.com");
	}
	@Test
	public void testAddcompetition() {
		LocalDate dateCloture = LocalDate.of(2017,Month.APRIL,10);
		Competition c = i.createCompetition("TestCreate", dateCloture, false);
		assertNotNull(c);
		assertEquals(c.getNom(), "TestCreate");
		assertEquals(c.getDateCloture(),dateCloture);
		assertEquals(c.estEnEquipe(), false);
		/*vérifie l'insertion a bien été effectuée*/
		i.closeConnection();
		i.openConnection();
		c = i.getCompetitions().first();
		assertNotNull(c);
		assertEquals(c.getNom(), "TestCreate");
		assertEquals(c.getDateCloture(),dateCloture);
		assertEquals(c.estEnEquipe(), false);
	}
	
	@Test
	public void testAddPersonne() {
		Personne p  = i.createPersonne("Dupuis", "Michel", "dm@gmail.com");
		assertNotNull(p);
		assertEquals(p.getNom(), "Dupuis");
		//assertEquals(p.getPrenom(), "Michel");
		/*assertEquals(p.getMail(), "dm@gmail.com");*/
		/*vérifie l'insertion a bien été effectuée*/
		/*i.closeConnection();
		i.openConnection();
		p = (Personne) i.getCandidats().first();
		assertNotNull(p);
		assertEquals(p.getNom(), "Dupuis");
		assertEquals(p.getPrenom(), "Michel");
		assertEquals(p.getMail(), "dm@gmail.com");*/
	}
	
	@Test
	public void testAddEquipe() {
		Equipe e = i.createEquipe("FRANCE");
		assertNotNull(e);
		assertEquals(e.getNom(), "FRANCE");
		i.closeConnection();
		i.openConnection();
		e = (Equipe) i.getCandidats().first();
		assertNotNull(e);
		assertNotNull(e);
		assertEquals(e.getNom(), "FRANCE");
	}
	
	@Test
	public void testGetCandidats() {
		assertNotNull(i);
		assertEquals(i.getCandidats(),cand);
	}
	
	@Test
	public void testGetCompetitions() {
		assertNotNull(i);
		assertEquals(i.getCompetitions(),compet);
	}

	@Test
	public void testGetInscription() {
		assertNotNull(i);
		assertEquals(Inscriptions.getInscriptions(),i);
	}
	
	@Test
	public void testGetEquipes() {
		SortedSet<Equipe> equipes = new TreeSet<>();
		equipes = i.getEquipes();
		assertNotNull(i);
		assertEquals(i.getEquipes(),equipes);
	}
	
	@Test
	public void testRemoveCompet() {
		candidats.add(p);
		i.remove(p);
	}
	
	@Test
	public void testRemoveCandidat() {
		SortedSet<Equipe> equipes = new TreeSet<>();
		equipes = i.getEquipes();
		assertNotNull(i);
		assertEquals(i.getEquipes(),equipes);
	}
	
	
	@Test
	public void testRecharger() {
		i.recharger();
	}
	
	@Test
	public void testReinit() {
		i.reinitialiser();
		assertNotEquals(Inscriptions.getInscriptions(),i);
	}
	
	@Test
	public void testSauvegarder() throws IOException {
		i.sauvegarder();
	}

}
