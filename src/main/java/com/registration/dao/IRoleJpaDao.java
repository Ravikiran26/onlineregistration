package com.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.Model.Roles;
import com.registration.Model.User;

public interface IRoleJpaDao extends JpaRepository<Roles,Long>{

	Roles findByName(String name);

}
