package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserDaoImpl;
import com.app.pojos.User;
import com.app.service.IUserService;
import com.app.service.UserService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService usrservice;
	@Autowired
	UserDaoImpl udao;
	@Autowired
	UserService sdao;
	
	

	@GetMapping("/list")
	public ResponseEntity<?> listUsers()
	{
		//http://localhost:7070/test_boot/user/list
		System.out.println("user list");
		List<User> allUsers = usrservice.getAllUsers();
		if(allUsers.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int user_id)
	{
		//http://localhost:7070/test_boot/user/34
		System.out.println("getting user details"+user_id);
		User u = usrservice.getUserById(user_id);
		if (u == null) 
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@GetMapping("/myprofile/{id}")
	public ResponseEntity<?> getMyProfile(@PathVariable int id) {
		// System.out.println(id);
		User cust = udao.getMyDetails(id);
		// System.out.println(listOfOrders);
		if (cust == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(cust, HttpStatus.OK);
	}
	
	@GetMapping("/donor")
	public ResponseEntity<?> listDonors() {
		//http://localhost:7070/test_boot/user/donor
		System.out.println("in list donors Controller");
		List<User> allDonors = usrservice.getDonors();
		if (allDonors.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<?>>(allDonors, HttpStatus.OK);
	}
	
	@GetMapping("/patient")
	public ResponseEntity<?> listRequesters() {
		//http://localhost:7070/test_boot/user/patient
		System.out.println("in list requesters Controller");
		List<User> allPatients = usrservice.getRequesters();
		if (allPatients.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<?>>(allPatients, HttpStatus.OK);
	}
	
	@GetMapping("/manager")
	public ResponseEntity<?> listManagers() {
		//http://localhost:7070/test_boot/user/manager
		System.out.println("in list managers:Controller");
		List<User> allManagers = usrservice.getManagers();
		if (allManagers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<?>>(allManagers, HttpStatus.OK);
	}
	
	@GetMapping("/manager/pending")
	public ResponseEntity<?> listPendingManagers() {
		//http://localhost:7070/test_boot/user/manager/pending
		System.out.println("in list managers:Controller");
		List<User> allManagers = usrservice.getPendingManagers();
		if (allManagers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<?>>(allManagers, HttpStatus.OK);
	}
	
	@GetMapping("/manager/approved")
	public ResponseEntity<?> listApprovedManagers() {
		//http://localhost:7070/test_boot/user/manager/approved
		System.out.println("in list managers:Controller");
		List<User> allManagers = usrservice.getApprovedManagers();
		if (allManagers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<?>>(allManagers, HttpStatus.OK);
	}
	
	@GetMapping("/manager/list/{u_id}")
	public ResponseEntity<?> listPendingRequests(@PathVariable int u_id) {
		System.out.println("in list request");
		List<User> allRequests = usrservice.getPendingStatusList(u_id);
		if (allRequests.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(allRequests, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> insertUser(@RequestBody User user)
	{
		//http://localhost:7070/test_boot/user/
		System.out.println("add user in database");
		System.out.println(user.getfName() + "  " + user.getEmail());
		try {
			User u = usrservice.addUser(user);
			sdao.sendNotification(user);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			
			return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
		}
	
		
	
	}
	
//	@PostMapping("/{u_id}")
//	public void deleteUserDetails(@PathVariable int u_id)
//	{
//		System.out.println("deleting user from db...");
//		usrservice.deleteUser(u_id);
//	}
	
	@PutMapping("/{u_id}")
	public void updateUser(@PathVariable int u_id,@RequestBody User u)
	{
		//http://localhost:7070/test_boot/user/39
		System.out.println("update user");
		u.setU_id(u_id);
		usrservice.updateUser(u);	
	}
	
	@PutMapping("/update/{id}")
	public User updateManager(@PathVariable int id)
	{
		//http://localhost:7070/test_boot/user/update/39
		System.out.println("in update manager user "+id);
		return usrservice.updateManagerStatus(id);
	}
	
	@PostMapping("/updatepassword/{npass}")
	public ResponseEntity<?> updatePassword(@RequestBody User user,@PathVariable String npass)//,@RequestBody String newpassword)
	{
		System.out.println("in Update password");
		System.out.println(user.getEmail()+user.getPassword());
		User u = usrservice.validatePassword(user.getEmail(), user.getPassword(), npass);
		
		if (u == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else
		{
			u.setPassword(npass);
			usrservice.updateUser(u);
		return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody User user)
	{
		//http://localhost:7070/test_boot/user/validate
		System.out.println("validating user");
		User u = usrservice.validateUser(user.getEmail(), user.getPassword());
		if (u == null) 
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
}
