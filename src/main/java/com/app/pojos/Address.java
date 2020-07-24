package com.app.pojos;

import javax.persistence.*;

@Embeddable
@Table(name = "address")
public class Address {
	
	
	//private Integer a_id;
	private String city,state,country,pincode;
	//private User usr;
	
	public Address() {
		System.out.println("Address instantiated");
		}
	
	public Address(String city, String state, String country, String pincode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Integer getA_id() {
//		return a_id;
//	}
//
//
//	public void setA_id(Integer a_id) {
//		this.a_id = a_id;
//	}

	@Column(nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(nullable = false)
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	@Column(nullable = false)
	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
//
//	@OneToOne
//	@JoinColumn(name = "u_id")
//	public User getUsr() {
//		return usr;
//	}
//
//
//	public void setUsr(User usr) {
//		this.usr = usr;
//	}
	
	
	
	
	
	
	
	
}
