package jpaibt;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import it.ibttn.corso.Persona;
import it.ibttn.corso.Reparto;

public class JPAQueryTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaibt");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Reparto r = em.find(Reparto.class, 52);
		r.setNome("Cambiato");
		
		if (r != null) {
			for(Persona p : r.getImpiegati()) {
				p.setNome(p.getNome() + " pippo");
				System.out.println(p.getNome());
			}
		}
		
		Persona agg = new Persona();
		agg.setId(51);
		
		em.refresh(agg);
		
		r.getImpiegati().add(agg);
		agg.setReparto(r);
		
		//em.merge(agg);
		
		em.getTransaction().commit();
	}

}
