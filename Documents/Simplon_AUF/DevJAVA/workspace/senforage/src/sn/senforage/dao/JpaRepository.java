package sn.senforage.dao;

import java.util.List;


public interface JpaRepository <Objet>{

	public int add(Objet o);
	public Objet get(int id);
	public int update(Objet o);
	public int delete(int id);
	public List<Objet> findAll();
}
