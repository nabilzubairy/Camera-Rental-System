package com.zubairy.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubairy.crs.dao.UserDao;
import com.zubairy.crs.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public String registerUser(User user) {
		user.setRole(user.getRole().toUpperCase());
		userDao.save(user);
		return "user register successfully";
	}

	public User loginUser(String email, String password) {
		System.out.println(email+password);
	    User user = userDao.findByEmail(email);
	    if(user == null) return null;
	    if(!user.getPassword().equals(password)) return null;

	    return user; // return valid user object
	}
	
	

}
