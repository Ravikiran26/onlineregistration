package com.registration.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.registration.Model.User;
import com.registration.Service.IUserService;
import com.registration.dao.IUserJpaDao;

public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserJpaDao dao;

	public UserServiceImpl() {
		super();
	}

	public User findByName(String name) {
		return dao.findByName(name);
	}

	protected final IUserJpaDao getDao() {
		return dao;
	}

	@Override
	public List<User> findByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return dao.findByPhoneNumber(phoneNumber);
	}

	@Override
	public User findByProSportsId(String ProSportsId) {
		// TODO Auto-generated method stub
		return dao.findByProSportsUerId(ProSportsId);
	}

}
