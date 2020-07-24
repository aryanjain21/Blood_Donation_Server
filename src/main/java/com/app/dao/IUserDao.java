package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	User validateUser(String email, String pass);
	User getMyDetails(int id);
	User editManagerStatus(int uid);
//	User addUserDetails(User user);
//	User editUserDetails(User u);
//	Camp addCampDetails(Camp c);
//	List<User> getAllDonors();
//	List<User> getDonorByName(String fName);
//	List<User> getUserList();
//	List<User> getAllRequesters();
//	User getUser(int id);
//	List<User> getAllManagers();
}
