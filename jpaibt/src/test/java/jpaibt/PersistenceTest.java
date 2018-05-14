package jpaibt;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.rs.PersistenceContext;
import org.junit.Test;

import it.ibttn.corso.Persona;

public class PersistenceTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaibt");
		EntityManager em = emf.createEntityManager();
		
		Persona p = new Persona();
		p.setNome("Mario");
		p.setCognome("Rossi");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		assertTrue("funziona", true);
	}

}
