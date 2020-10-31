package sn.senforage.dao;

import java.util.List;

import sn.senforage.entities.User;

public interface IUserRepository {

	public int add(User o);
	public User get(int id);
	public int update(User o);
	public int delete(int id);
	public List<User> findAll();
}
