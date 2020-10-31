package sn.senforage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sn.senforage.entities.Client;

public class ClientRepository implements JpaRepository<Client>{
	
	private EntityManager em;
	
	public ClientRepository() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("senforagePU");
		em = emf.createEntityManager();
	}
	@Override
	public int add(Client o) {
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
	public Client get(int id) {
		Client client = em.find(Client.class, id);
		return client;
	}

	@Override
	public int update(Client o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(this.get(id));
			em.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Client> findAll() {
		Query query = em.createQuery("select c from Client c");
		return query.getResultList();
	}

}
