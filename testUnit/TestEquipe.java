package testUnit;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestEquipe {
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p = i.createPersonne("Ben Laden", "Oussama", "b.ouss@gmail.com");
	Equipe e = i.createEquipe("Al Quaïda");
	
	protected void setUp() throws Exception {
		i = Inscriptions.getInscriptions();
		p = i.createPersonne("Ben Laden", "Oussama", "b.ouss@gmail.com");
	}

	@Test
	public void testAddPersonne() {
		assert(e.add(p));
	}
	
	@Test
	public void testGetMembres() {
		assertNotNull(e.getMembres());
	}
	
	@Test
	public void testRemove() {
		assert(e.remove(p));
	}
	
}
