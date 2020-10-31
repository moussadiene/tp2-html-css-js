package sn.senforage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sn.senforage.entities.Village;

public class VillageRepository implements JpaRepository<Village>{

	private EntityManager em;
	
	public VillageRepository() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("senforagePU");
		em = emf.createEntityManager();
	}
	@Override
	public int add(Village o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public Village get(int id) {
		Village village = em.find(Village.class, id);
		return village;
	}

	@Override
	public int update(Village o) {
		try {
			em.merge(o);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(this.get(id));
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Village> findAll() {
		Query query = em.createQuery("select v from Village v");
		return query.getResultList();
	}
	

}
