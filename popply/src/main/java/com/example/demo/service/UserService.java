package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;

	public String getUserId(String userId) {
		Optional<Users> user = ur.findById(userId);
		if(user.isPresent()) {
			return user.get().getUserId();
		}
		return "";
	}

	public String getUserPhone(String phone) {
		Optional<Users> user = ur.findByPhone(phone);
		if(user.isPresent()) {
			return user.get().getUserId();
		}
		return "";
	}

	public boolean enrollUserData(Users u) {
		return ur.save(u) != null;
	}


}
