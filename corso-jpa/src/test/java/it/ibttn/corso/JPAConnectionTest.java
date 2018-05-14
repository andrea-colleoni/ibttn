package it.ibttn.corso;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JPAConnectionTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Persona p = new Persona();
		p.setCodiceFiscale("ABCX45678");
		p.setNome("Mario");
		p.setCognome("Rossi");
		
		em.persist(p);
		
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	@Test
	public void testLetturaPerChiave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();

		Persona p = em.find(Persona.class, "ABCXYZ45678");
		
		if( p != null ) {
			System.out.println(p.getCognome());
		}
		
		assertNotNull("funziona!", p);
	}
	
	@Test
	public void testInserimentoReparto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Reparto r = em.find(Reparto.class, dammiUnReparto().getCodice());
		Reparto r = em.merge(dammiUnReparto());
		
		r.setNome("modificato");
		//em.persist(r);
		
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	private Reparto dammiUnReparto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		return em.find(Reparto.class, 3);
	}
	
	
	
	@Test
	public void testTransientNoAuto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Persona p = new Persona();
		//p.setCodiceFiscale("23456");
		
		em.persist(p);
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	@Test
	public void testTransientAuto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = new Reparto();
		//p.setCodiceFiscale("23456");
		
		em.persist(r);
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	@Test
	public void testTransientAutoManual() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = new Reparto();
		r.setCodice(123);
		
		em.persist(r);
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	@Test
	public void testTransientAutoManualEsiste() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = new Reparto();
		r.setCodice(3);
		
		em.merge(r);
		
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}
	
	@Test
	public void testTransientAutoManualNonEsiste() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = new Reparto();
		r.setCodice(10);
		
		em.merge(r);
		r.setNome("jkkjbkjb");
		
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}	
	
	@Test
	public void testTransientAutoManualNonEsistePersist() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = new Reparto();
		r.setCodice(10);
		
		r = em.merge(r);
		
		r.setNome("jkkjbkjb");
		
		em.getTransaction().commit();
		
		assertTrue("funziona!", true);
	}	
	

}
