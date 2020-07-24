package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Donation;
import com.app.pojos.User;

@Repository
public class DonationDaoImpl implements IDonationDao{

	@PersistenceContext
	private EntityManager sf;
	
//	@Override
//	public List<Donation> donorhistory(String role) {
//		String jpql = "select d from Donation d where d.donor_id.role=:rl";
//		return sf.unwrap(Session.class).createQuery(jpql, Donation.class).setParameter("rl", role).getResultList();
//	}

	@Override
	public List<Donation> getDonationsList(int u_id) {
		System.out.println(" in getDonationList");
		String jpql = "select d from Donation d where d.donor_id.u_id=:u_id";
		return sf.unwrap(Session.class).createQuery(jpql, Donation.class).setParameter("u_id", u_id).getResultList();
	}
	
	public List<Donation> getDonationsList() {
		System.out.println(" in getDonationList");
		String jpql = "select d from Donation d";
		return sf.unwrap(Session.class).createQuery(jpql, Donation.class).getResultList();
	}

	@Override
	public Donation addDonationDetails(Donation d) {
		sf.unwrap(Session.class).save(d);
		return d;
	}

	@Override
	public User getUser(Integer u_id) {
		return sf.unwrap(Session.class).get(User.class, u_id);
	}
	
	@Override
	public Donation updateBloodBag(Donation donation) {
		sf.unwrap(Session.class).update(donation);
		return donation;
	}

	@Override
	public void getDonationByDate(Date donated_date) {
		System.out.println("in getDonationByDate");
		String jpql = "select d from Donation d where d.donate_date=:donation_date";
		sf.unwrap(Session.class).createQuery(jpql, Donation.class).setParameter("donation_date", donated_date).getResultList();
	}

	@Override
	public Donation editDonationDetails(Donation d) {
		sf.unwrap(Session.class).update(d);
		return d;
	}

	@Override
	public void removeDonation(Donation d) {
		sf.unwrap(Session.class).delete(d);
		
	}
	
}
