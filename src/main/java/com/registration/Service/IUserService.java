package com.registration.Service;

import java.util.List;

import com.registration.Model.User;

public interface IUserService {
	
	List<User>findByPhoneNumber(String phoneNumber);
	User findByProSportsId(String proSportsId);

}
