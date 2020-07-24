package com.app.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "camp_details")
public class Camp 
{
	private Integer camp_id;
	private User organizer_id;//fk
	private double blood_amount;
	private String camp_venue;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date camp_date;
	
	public Camp() {
		System.out.println("Camp instantiated");
	}

	public Camp(User organizer_id, String camp_venue, Date camp_date) {
		super();
		this.organizer_id = organizer_id;
//		this.blood_amount = blood_amount;
		this.camp_venue = camp_venue;
		this.camp_date = camp_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCamp_id() {
		return camp_id;
	}

	public void setCamp_id(Integer camp_id) {
		this.camp_id = camp_id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizer_id")
	@Fetch(FetchMode.JOIN)
	//@JsonIgnore
	public User getOrganizer_id() {
		return organizer_id;
	}

	public void setOrganizer_id(User organizer_id) {
		this.organizer_id = organizer_id;
	}

	public double getBlood_amount() {
		return blood_amount;
	}

	public void setBlood_amount(double blood_amount) {
		this.blood_amount = blood_amount;
	}

	public String getCamp_venue() {
		return camp_venue;
	}

	public void setCamp_venue(String camp_venue) {
		this.camp_venue = camp_venue;
	}

	@Temporal(TemporalType.DATE)
	public Date getCamp_date() {
		return camp_date;
	}

	public void setCamp_date(Date camp_date) {
		this.camp_date = camp_date;
	}

	@Override
	public String toString() {
		return "Camp [camp_id=" + camp_id + ", organizer_id=" + organizer_id + ", camp_venue=" + camp_venue
				+ ", camp_date=" + camp_date + "]";
	}


	
	
	
}
