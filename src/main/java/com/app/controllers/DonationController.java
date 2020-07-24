package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.DonationDaoImpl;
import com.app.pojos.Donation;
import com.app.pojos.StockDetails;
import com.app.pojos.User;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
@RequestMapping("/donation")
public class DonationController {

	@Autowired
	DonationDaoImpl ddao;
	
	@GetMapping("/donate/{u_id}")
	public ResponseEntity<?> listDonation(@PathVariable int u_id)
	{
		//http://localhost:7070/test_boot/donation/donate
		System.out.println("Donation list");
		List<Donation> donation = ddao.getDonationsList(u_id);
		if(donation.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Donation>>(donation, HttpStatus.OK);
	}
	
	@GetMapping("/donate")
	public ResponseEntity<?> listDonation()
	{
		//http://localhost:7070/test_boot/donation/donate
		System.out.println("Donation list");
		List<Donation> donation = ddao.getDonationsList();
		if(donation.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Donation>>(donation, HttpStatus.OK);
	}
	
	@PostMapping("/{donate_id}")
	public ResponseEntity<?> addDonationDetails(@RequestBody Donation donation, @PathVariable int donate_id)
	{
		System.out.println("getting user details"+donate_id);
		User u = ddao.getUser(donate_id);
		
		String grp = u.getBlood_group();
		StockDetails stock = new StockDetails(grp, donation.getDonated_amount());
		stock.addBlood(donation);
		donation.getDonate_id();
		Donation d = ddao.addDonationDetails(donation);
		System.out.println(d);
		if (d == null) 
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Donation>(d, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Donation updateDonation(@PathVariable int id,@RequestBody Donation donate)
	{
		//http://localhost:7070/test_boot/donation/4
		System.out.println("update Donation");
		donate.setDonate_id(id);
		return ddao.editDonationDetails(donate);	
	}
}
