package sn.senforage.dao;

import java.util.List;

import sn.senforage.entities.Client;

public interface IClientRepository {

	public int add(Client o);
	public Client get(int id);
	public int update(Client o);
	public int delete(int id);
	public List<Client> findAll();
}
