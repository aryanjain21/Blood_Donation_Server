package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.pojos.Donation;
import com.app.pojos.User;

public interface IDonationDao {
	List<Donation> getDonationsList(int u_id);
	Donation addDonationDetails(Donation d);
	User getUser(Integer u_id);
	void getDonationByDate(Date donation_date);
	Donation editDonationDetails(Donation d);
	void removeDonation(Donation d);
	Donation updateBloodBag(Donation donation);
}
