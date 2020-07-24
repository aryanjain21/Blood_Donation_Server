package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.annotations.QueryHints;
import org.springframework.stereotype.Repository;

import com.app.pojos.BloodRequest;
import com.app.pojos.Camp;
import com.app.pojos.Role;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao
{
	@PersistenceContext
	private EntityManager sf;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public User validateUser(String email, String pass) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return sf.unwrap(Session.class).createQuery(jpql, User.class)
				 .setParameter("em", email).setParameter("pass", pass).getSingleResult();
	}
	
	public User validatePassword(String email, String pass, String newpss) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User u= sf.unwrap(Session.class).createQuery(jpql, User.class)
				 .setParameter("em", email).setParameter("pass", pass).getSingleResult();
		u.setPassword(newpss);
		return u;
	}
	
	public User addUserDetails(User user) {
		sf.unwrap(Session.class).persist(user);
		return user;
	}
	
	public User editUserDetails(User u) {
		sf.unwrap(Session.class).update(u);
		return u;
		}
	
	@Override
	public User editManagerStatus(int uid) {
		
		User u=sf.unwrap(Session.class).get(User.class, uid);  
				  
		String jpql="update user u SET u.m_status=1 where u.uid=:uid";

			sf.unwrap(Session.class).createNativeQuery(jpql, User.class).setParameter("uid", uid).executeUpdate();
			return u;
			}

	public Camp addCampDetails(Camp c) {
		sf.unwrap(Session.class).persist(c);;
		return c;
	}
	
	public List<User> getAllDonors()
	{
		System.out.println("in donor list");
		String jpql="select distinct u from User u where u.u_role=:role";
		List<User> donor_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("role", Role.DONOR)
			    .setHint(QueryHints.PASS_DISTINCT_THROUGH, false).getResultList();
		return donor_list;
	}
	
	public List<User> getDonorByName(String fName) {
		System.out.println("");
		String jpql="select u from User u where u.fName=:fName";
		return sf.unwrap(Session.class).createQuery(jpql,User.class).getResultList();
	}
	
	public List<User> getUserList()
	{
		System.out.println("getUserList");
		String jpql = "select u from User u";
		return sf.unwrap(Session.class).createQuery(jpql, User.class).getResultList();
	}
	
	public List<User> getAllRequesters()
	{
		System.out.println("in getAllRequesters");
		String jpql="select distinct u from User u left join fetch u.requests  where u.u_role=:role";
		List<User> patient_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("role", Role.PATIENT)
			    .setHint(QueryHints.PASS_DISTINCT_THROUGH, false).getResultList();
		return patient_list;
	}
	
	public List<User> getAllPendingManagers()
	{
		System.out.println("in manager list");
	
		String jpql="select distinct u from User u where u.u_role=:role and u.m_status=0";
		List<User> manager_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("role", Role.MANAGER)
			    .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
				.getResultList();

		return manager_list;
	}
	
	public List<User> getAllApprovedManagers()
	{
		System.out.println("in donor list");
		//select distinct c from Course c left outer join fetch c.students"
		String jpql="select distinct u from User u where u.u_role=:role and u.m_status=1";
		List<User> manager_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("role", Role.MANAGER)
			    .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
				.getResultList();

		return manager_list;
	}
	
	public User getUser(int id)
	{
		return sf.unwrap(Session.class).get(User.class, id);
	}
	
	public List<User> getAllManagers()
	{
		System.out.println("in getAllManagers");
		String jpql="select distinct u from User u where u.u_role=:role";
		List<User> manager_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("role", Role.MANAGER)
			    .setHint(QueryHints.PASS_DISTINCT_THROUGH, false).getResultList();
		return manager_list;
	}

	@Override
	public User getMyDetails(int id) {
		return sf.unwrap(Session.class).get(User.class, id);
	}	

	public List<User> getAllPendingStatusList(int u_id)
	{
		System.out.println("in request list");
	
		String jpql="select u from User u where u.m_status=0 and u.u_id=:u_id";
	
		List<User> request_list=sf.unwrap(Session.class).createQuery(jpql,User.class).setParameter("u_id", u_id).getResultList();

		return request_list;
	}

//	@Override
//	public List<Donation> donorhistory() {
//		String jpql = "select d from Donation d";
//		return sf.unwrap(Session.class).createQuery(jpql, Donation.class).getResultList();
//	}
//	
//	public User addUser(User u)
//	{
//		return  (User) sf.unwrap(Session.class).save(u);
//	}
//	
//	public void updateUserDetails(User u)
//	{
//		sf.unwrap(Session.class).update(u);
//	}
//	
//	public void deleteUserDetails(int id)
//	{
//		User user = sf.unwrap(Session.class).get(User.class, id);
//		sf.unwrap(Session.class).delete(user);
//	}

}
