package com.registration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.Model.User;

public interface IUserJpaDao extends JpaRepository<User, Long> {

	List<User> findByPhoneNumber(String phoneNumber);
	User findByProSportsUerId(String proSportId);
	User findByName(String name);
}
