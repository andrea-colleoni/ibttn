package it.ibttn.corso;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestJPAQuery {

	@Test
	public void testLazy() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		Reparto r = em.find(Reparto.class, -41);
		
		for(Persona p : r.getImpiegati()) {
			System.out.println(p.getCognome());
		}
	}
	
	
	@Test
	public void testCascade() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corso-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = em.find(Reparto.class, -41);
		
		for(Persona p : r.getImpiegati()) {
			System.out.println(p.getCognome());
			
			p.setNome(p.getNome() + "***");
		}
		
//		Persona x = new Persona();
//		x.setCodiceFiscale("NEW3NEW3");
//		x.setReparto(r);
//		x.setCognome("XYZ");
//		em.persist(x);
//		//r.getImpiegati().add(x);
		
		em.getTransaction().commit();
	}

}
