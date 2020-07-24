package com.app.pojos;

import java.util.Date;

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

@Entity
@Table(name = "blood_request")
public class BloodRequest 
{
	private Integer req_id;
	private User requster_id;//fk
	private double requsted_qty;
	private String blood_group;
	private Date require_date;
	private String request_msg;
	private boolean request_status;
	public BloodRequest() {
System.out.println("Blood Request instantiated");	}

	public BloodRequest(User requster_id, double requsted_qty, Date require_date, String request_msg) {
		super();
		this.requster_id = requster_id;
		this.requsted_qty = requsted_qty;
		this.require_date = require_date;
		this.request_msg = request_msg;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReq_id() {
		return req_id;
	}

	public void setReq_id(Integer req_id) {
		this.req_id = req_id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requster_id")
	
	public User getRequster_id() {
		return requster_id;
	}

	public void setRequster_id(User requster_id) {
		this.requster_id = requster_id;
	}

	public double getRequsted_qty() {
		return requsted_qty;
	}

	public void setRequsted_qty(double requsted_qty) {
		this.requsted_qty = requsted_qty;
	}

	@Temporal(TemporalType.DATE)
	public Date getRequire_date() {
		return require_date;
	}

	public void setRequire_date(Date require_date) {
		this.require_date = require_date;
	}

	public String getRequest_msg() {
		return request_msg;
	}

	public void setRequest_msg(String request_msg) {
		this.request_msg = request_msg;
	}
	
	
	
	
	@Column(columnDefinition = "TINYINT(1)")
	public boolean isRequest_status() {
		return request_status;
	}

	public void setRequest_status(boolean request_status) {
		this.request_status = request_status;
	}

	@Override
	public String toString() {
		return "BloodRequest [req_id=" + req_id + ", requster_id=" + requster_id + ", requsted_qty=" + requsted_qty
				+ ", blood_group=" + blood_group + ", require_date=" + require_date + ", request_msg=" + request_msg
				+ "]";
	}
	
	
	
	
}
