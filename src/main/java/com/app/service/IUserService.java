package com.app.service;

import java.util.List;

import com.app.pojos.Camp;
import com.app.pojos.User;

public interface IUserService 
{
	User getUserById(int userId);
	List<User> getAllUsers();
	//void deleteUser(int id);
	User validatePassword(String email, String password, String newPass) ;
	User validateUser(String email,String password);
	List<User> getPendingStatusList(int u_id);
	void updateUser(User u);
	User updateManagerStatus(int uid);
	List<User> getDonors();
	List<User> getDonorName(String fName);
	List<User> getRequesters();
	List<User> getManagers();
	List<User> getPendingManagers();
	List<User> getApprovedManagers();
	User addUser(User u);
	Camp addCamp(Camp c);
}
