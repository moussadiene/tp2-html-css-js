package sn.senforage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sn.senforage.entities.User;

public class UserRepository implements IUserRepository{

	private EntityManager em;
	
	public UserRepository() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("senforagePU");
		em = emf.createEntityManager();
	}

	@Override
	public int add(User o) {
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
	public User get(int id) {
		User u = em.find(User.class, id);
		return u;
	}

	@Override
	public int update(User o) {
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
			em.getTransaction().begin();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> findAll() {
		Query query = em.createQuery("SELECT u from User u");
		return query.getResultList();
	}
	
	public User getUserByLog(String email, String password) {
		
		try {
			String select = "SELECT u FROM User u WHERE u.email=:email and u.password=:password";
			Query query = em.createQuery(select);
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
