package sn.senforage.dao;

import java.util.List;

import sn.senforage.entities.Village;

public interface IVillageRepository {

	public int add(Village o);
	public Village get(int id);
	public int update(Village o);
	public int delete(int id);
	public List<Village> findAll();
}
