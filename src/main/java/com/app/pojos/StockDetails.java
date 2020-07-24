package com.app.pojos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "stock_details")
public class StockDetails
{
	private Integer bloodbag_id;
	private String blood_group;
	private double blood_amt;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rec_date;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expire_date;
	private User mgr_id;//fk
	
	private Donation donation;
	public StockDetails() {
System.out.println("StockDetails instantiated");	}

	
	
	public StockDetails(String blood_group, double blood_amt) {
		super();
		//this.bloodbag_id = bloodbag_id;
		this.blood_group = blood_group;
		this.blood_amt = blood_amt;
		
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBloodbag_id() {
		return bloodbag_id;
	}

	public void setBloodbag_id(Integer bloodbag_id) {
		this.bloodbag_id = bloodbag_id;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public double getBlood_amt() {
		return blood_amt;
	}

	public void setBlood_amt(double blood_amt) {
		this.blood_amt = blood_amt;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
//	@Temporal(TemporalType.DATE)
	@Column(name = "recieve_date")
	public Date getRec_date() {
		return rec_date;
	}

	public void setRec_date(Date rec_date) {
		this.rec_date = rec_date;
	}
	
	


	@Temporal(TemporalType.DATE)
	@Column(name = "expire_date")
	public Date getExpire_date() {
		Date date = new Date();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 2);
		return cal.getTime();
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	@OneToOne
	@JoinColumn(name = "mgr_id")
	public User getM_id() {
		return mgr_id;
	}

	public void setM_id(User m_id) {
		this.mgr_id = m_id;
	}
	
	
	

	//convinence
	
	@OneToOne
	@JoinColumn(name = "bloodbag_id")
	public Donation getDonation() {
		return donation;
	}



	public void setDonation(Donation donation) {
		this.donation = donation;
	}



	//con method
	public void addBlood(Donation stock) {
		this.donation=stock;
		stock.setBloodbag_id(this);
		
	}
	public void removeBlood(Donation stock) {
		this.donation=stock;
		stock.setBloodbag_id(null);
		
	}
	
	
	
	
}
