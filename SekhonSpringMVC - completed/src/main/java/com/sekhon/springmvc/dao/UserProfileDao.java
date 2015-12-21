package com.sekhon.springmvc.dao;

import java.util.List;

import com.sekhon.springmvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
