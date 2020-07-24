package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "donation_details")
public class Donation {
	
	private Integer donate_id;//pk
	private double donated_amount;
	private User donor_id;
	//private Camp camp_id;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date donate_date;
	private boolean hepatitsB, hiv, malaria, hepatitsC;
	private boolean email_status;
	private StockDetails bloodbag_id;
	
	public Donation() {
		System.out.println("Donation instantiated");	}



	public Donation(double donated_amount, boolean hepatitsB, boolean hiv, boolean malaria,
			boolean hepatitsC) {
		super();
		this.donated_amount = donated_amount;
	
		this.hepatitsB = hepatitsB;
		this.hiv = hiv;
		this.malaria = malaria;
		this.hepatitsC = hepatitsC;
		//this.email_status = email_status;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDonate_id() {
		return donate_id;
	}

	
	public void setDonate_id(Integer donate_id) {
		this.donate_id = donate_id;
	}

	public double getDonated_amount() {
		return donated_amount;
	}

	public void setDonated_amount(double donated_amount) {
		this.donated_amount = donated_amount;
	}

	@OneToOne
	@JoinColumn(name = "donor_id")
	public User getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(User donor_id) {
		this.donor_id = donor_id;
	}
//
//	@OneToOne
//	@JoinColumn(name = "camp_id")
//	public Camp getCamp_id() {
//		return camp_id;
//	}
//
//	public void setCamp_id(Camp camp_id) {
//		this.camp_id = camp_id;
//	}
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isEmail_status() {
		return email_status;
	}

	public void setEmail_status(boolean email_status) {
		this.email_status = email_status;
	}

	@OneToOne(mappedBy = "donation",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	public StockDetails getBloodbag_id() {
		return bloodbag_id;
	}


	public void setBloodbag_id(StockDetails bloodbag_id) {
		this.bloodbag_id = bloodbag_id;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDonate_date() {
		return donate_date;
	}

	
	public void setDonate_date(Date donate_date) {
		this.donate_date = donate_date;
	}
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isHepatitsB() {
		return hepatitsB;
	}

	public void setHepatitsB(boolean hepatitsB) {
		this.hepatitsB = hepatitsB;
	}
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isHiv() {
		return hiv;
	}

	public void setHiv(boolean hiv) {
		this.hiv = hiv;
	}
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isMalaria() {
		return malaria;
	}

	public void setMalaria(boolean malaria) {
		this.malaria = malaria;
	}
	@Value("0")
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isHepatitsC() {
		return hepatitsC;
	}

	public void setHepatitsC(boolean hepatitsC) {
		this.hepatitsC = hepatitsC;
	}
	
	

	//conv
	public void addBloodBagID(Integer bagid) {
		//StockDetails s;
		
		this.bloodbag_id.setBloodbag_id(bagid);
		
	}


}
