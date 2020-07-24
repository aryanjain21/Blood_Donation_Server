package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.dao.UserDaoImpl;
import com.app.pojos.Camp;
import com.app.pojos.User;

@Service
@Transactional
public class UserService implements IUserService {

//	List<User> getAllManagers();
	@Autowired
	private UserDaoImpl udao;
	
	private JavaMailSender javaMailSender;
	
	
	@Autowired
	 public UserService(JavaMailSender javaMailSender) {
		// TODO Auto-generated constructor stub
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException
	{
		//sending email
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("BLOOD DONATION BANK");
		mail.setText("Dear "+" "+user.getU_role()+" " + user.getfName()+" " + "You have registered succesfully.\n Your Username is"
				+" " + user.getEmail() +" "+"and password is " + user.getPassword() + ".\n Thank you for Register.\n Khoon dekhe dekho accha lagta hey");
		javaMailSender.send(mail);
	}
	
	@Override
	public User validateUser(String email, String password) 
	{
		return udao.validateUser(email, password);
	}
	
	public User validatePassword(String email, String password, String newPass) 
	{
		return udao.validatePassword(email, password, newPass);
	}
	
	@Override
	public User addUser(User u) 
	{
		return udao.addUserDetails(u);
	}
	
	@Override
	public List<User> getDonors()
	{
		return udao.getAllDonors();
	}
	
	@Override
	public List<User> getDonorName(String fName)
	{
		return udao.getDonorByName(fName);
	}
	
	@Override
	public Camp addCamp(Camp c) 
	{
		return udao.addCampDetails(c);
	}

	@Override
	public User getUserById(int userId) 
	{
		return udao.getUser(userId);
	}

	@Override
	public List<User> getAllUsers() 
	{
		return udao.getUserList();
	}	
	
	@Override
	public List<User> getPendingStatusList(int u_id) {
		return udao.getAllPendingStatusList(u_id);
	}

//	@Override
//	public void deleteUser(int id) 
//	{
//		udao.deleteUserDetails(id);
//	}

	@Override
	public void updateUser(User u) 
	{
		udao.editUserDetails(u);
	}

	@Override
	public List<User> getRequesters() {
		return udao.getAllRequesters();
	}

	@Override
	public List<User> getManagers() {
		return udao.getAllManagers();
	}

	@Override
	public User updateManagerStatus(int uid) {
		return udao.editManagerStatus(uid);
	}

	@Override
	public List<User> getPendingManagers() {
		return udao.getAllPendingManagers();
	}

	@Override
	public List<User> getApprovedManagers() {
		return udao.getAllApprovedManagers();
	}
	
	
	{
		
	}
}
