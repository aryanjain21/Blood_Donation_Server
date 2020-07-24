package com.app.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Constraint;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user")
public class User 
{
	private Integer u_id;
	private String fName, lName, email, password;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date u_dob;
	private String contact;
	private Integer weight;
	//private byte[] image;
	private String blood_group;
	private String gender;
	private Role u_role;
	private boolean m_status;
	private List<Donation> donation=new ArrayList<>();
	private Address address;//user has a address
	//one to many
	private List<BloodRequest> requests = new ArrayList<>(); //patient
	private List<Camp> camps = new ArrayList<>();//manager
	public User() {
	System.out.println("User instantiated");	
	}

	

//	public User(String fName, String lName, String email, String password, Date u_dob, String contact, Integer weight,
//			byte[] image, String blood_group, String gender, Role u_role, Address addr) {
//		super();
//		this.fName = fName;
//		this.lName = lName;
//		this.email = email;
//		this.password = password;
//		this.u_dob = u_dob;
//		this.contact = contact;
//		this.weight = weight;
//		this.image = image;
//		this.blood_group = blood_group;
//		this.gender = gender;
//		this.u_role = u_role;
//		this.address = addr;
//	}

	
	
public User(Integer id) {
	this.u_id=id;
}

	public User(String fName, String lName, String email, String password, Date u_dob, String contact, Integer weight,
		 String blood_group, String gender, Role u_role, boolean m_status, Address address) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.email = email;
	this.password = password;
	this.u_dob = u_dob;
	this.contact = contact;
	this.weight = weight;
	//this.image = image;
	this.blood_group = blood_group;
	this.gender = gender;
	this.u_role = u_role;
	this.m_status = m_status;
	this.address = address;
}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	
	@Column(nullable = false)
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(nullable = false)
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Column(length = 50, unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 15, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getU_dob() {
		return u_dob;
	}

	public void setU_dob(Date u_dob) {
		this.u_dob = u_dob;
	}

	public String getContact() {
		return contact;
	}

	@Column(nullable = false)
	public void setContact(String contact) {
		this.contact = contact;
	}

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}

	@Column(nullable = false)
	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	@Column(nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	@Value("false")
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isM_status() {
		return m_status;
	}



	public void setM_status(boolean m_status) {
		this.m_status = m_status;
	}



	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	public Role getU_role() {
		return u_role;
	}

	public void setU_role(Role u_role) {
		this.u_role = u_role;
	}

	@Embedded
	//@OneToOne(mappedBy = "usr", cascade = CascadeType.ALL, orphanRemoval = true)
	public Address getAddr() {
		return address;
	}

	public void setAddr(Address addr) {
		this.address = addr;
	}
	
	
	
//	public void addAddress(Address add)
//	{
//		this.address=add;
//		add.setUsr(this);
//	}	
//	public void removeAddress(Address add)
//	{
//		this.address=null;
//		add.setUsr(null);
//	}

	@Column(nullable = false)
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@OneToMany(mappedBy = "requster_id", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<BloodRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<BloodRequest> requests) {
		this.requests = requests;
	}

	@OneToMany(mappedBy = "organizer_id", cascade = CascadeType.ALL, orphanRemoval = true)
	//@Fetch(FetchMode.JOIN)
	@JsonIgnore
	public List<Camp> getCamps() {
		return camps;
	}

	public void setCamps(List<Camp> camps) {
		this.camps = camps;
	}



	@OneToMany(mappedBy = "donor_id",fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Donation> getDonation() {
		return donation;
	}



	public void setDonation(List<Donation> donation) {
		this.donation = donation;
	}



	//convinence
	public void addCamp(Camp c) {
		this.camps.add(c);
		c.setOrganizer_id(this);
	}
	
	public void removeCamp(Camp c) {
		this.camps.add(c);
		c.setOrganizer_id(null);
	}
	
	public void addRequest(BloodRequest b)
	{
		this.requests.add(b);
		b.setRequster_id(this);
	}
	
	
	public void removeRequest(BloodRequest b)
	{
		this.requests.add(b);
		b.setRequster_id(null);
	}
	
	
	public void addDonation(Donation d) {
		this.donation.add(d);
		d.setDonor_id(this);
		
	}
	public void removeDonation(Donation d) {
		this.donation.add(d);
		d.setDonor_id(null);
		
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", u_dob=" + u_dob + ", contact=" + contact + ", weight=" + weight + ", blood_group="
				+ blood_group + ", gender=" + gender + ", u_role=" + u_role + ", m_status=" + m_status + ", donation="
				+ donation + ", address=" + address + ", requests=" + requests + ", camps=" + camps + "]";
	}
	
	
	




	
	
	
}
