package com.idc.hes.dao;

import java.util.List;

import com.idc.hes.model.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	public void saveOrUpdate(User user);
	
	public void delete(int id);
}