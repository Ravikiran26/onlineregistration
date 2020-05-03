package com.registration.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.registration.Model.Roles;
import com.registration.Model.User;
import com.registration.Service.IRoleService;
import com.registration.dao.IRoleJpaDao;

public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleJpaDao dao;
	
	public RoleServiceImpl() {
		super();
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}
	
	
	

}
