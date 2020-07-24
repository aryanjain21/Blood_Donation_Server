package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.BloodRequest;
import com.app.service.IRequestService;

@RestController
@CrossOrigin
@RequestMapping("/requester")
public class RequestController {
	
	@Autowired
	IRequestService reqservice;

	@GetMapping("/list")
	public ResponseEntity<?> listRequester()
	{
		//http://localhost:7070/test_boot/requester/list
		System.out.println("listRequester()");
		List<BloodRequest> allRequester = reqservice.getAllRequester();
		if(allRequester.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BloodRequest>>(allRequester, HttpStatus.OK);
	} 	
	
	@GetMapping("/pending/list")
	public ResponseEntity<?> listPendingRequests() {
		System.out.println("in list request");
		List<BloodRequest> allRequests = reqservice.getPendingRequestList();
		if (allRequests.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<BloodRequest>>(allRequests, HttpStatus.OK);
	}

//	@GetMapping("/pending/list/{u_id}")
//	public ResponseEntity<?> listPendingRequests(@PathVariable int u_id) {
//		System.out.println("in list request");
//		List<BloodRequest> allRequests = reqservice.getPendingRequestList(u_id);
//		if (allRequests.size() == 0)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		return new ResponseEntity<List<BloodRequest>>(allRequests, HttpStatus.OK);
//	}
	
	@GetMapping("/approved/list")
	public ResponseEntity<?> listApprovedRequests() {
		System.out.println("in list request");
		List<BloodRequest> allRequests = reqservice.getAppovedRequestList();
		if (allRequests.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<BloodRequest>>(allRequests, HttpStatus.OK);
	}
	
	@GetMapping("/request/{requster_id}")
	public ResponseEntity<?> getRequestStatusByUserId(@PathVariable int requster_id) {
		System.out.println("in request search by requster_id " + requster_id);
		BloodRequest b = reqservice.getRequestStatusUserId(requster_id);
		if (b == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<BloodRequest>(b, HttpStatus.OK);
	}
	
	@GetMapping("/date/{u_id}")
	public ResponseEntity<?> getRequestDetailsByDate(@PathVariable int u_id) {
		//http://localhost:7070/test_boot/requester/date
		System.out.println("in request search by date:controller ");
		List<BloodRequest> reqDate = reqservice.getRequestDate(u_id);
		if (reqDate == null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BloodRequest>>(reqDate, HttpStatus.OK);
	}
	
	@GetMapping("/date")
	public ResponseEntity<?> getRequestDetailsByDate() {
		//http://localhost:7070/test_boot/requester/date
		System.out.println("in request search by date:controller ");
		List<BloodRequest> reqDate = reqservice.getRequestDate();
		if (reqDate == null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BloodRequest>>(reqDate, HttpStatus.OK);
	}
	
	@GetMapping("/{blood_group}")
	public ResponseEntity<?> getRequestDetailsByBloodGroup(@PathVariable String blood_group) {
		//http://localhost:7070/test_boot/requester/O+
		System.out.println("in request search by date:controller " + blood_group);
		List<BloodRequest> b = reqservice.getRequestBloodGroup(blood_group);
		if (b == null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BloodRequest>>(b, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addRequestDetails(@RequestBody BloodRequest b){//,@PathVariable int uid) {
		//http://localhost:7070/test_boot/requester/
		System.out.println("in add request dtls:add new request " + b);
		try {
			return new ResponseEntity<BloodRequest>(reqservice.addRequester(b), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/req/{id}")
	public BloodRequest editRequestDetails(@PathVariable int id,@RequestBody BloodRequest b)
	{
		//http://localhost:7070/test_boot/requester/req/3
		b.setReq_id(id);
		
		System.out.println("in edit camp "+id);
		return reqservice.updateRequester(b);
	}
	
	
	@PutMapping(value ="/update/{req_id}", produces = "application/json")
	public void updateManager(@PathVariable int req_id)
	{
		System.out.println("in update request "+req_id);
		reqservice.updateRequesterStatus(req_id);
	}
	
	@PutMapping("/request/{request_id}")
	public void updateRequester(@PathVariable int request_id)
	{
		System.out.println("in update requester status " + request_id);
		reqservice.updateRequesterStatus(request_id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequester(@PathVariable int id)
	{
		BloodRequest b=reqservice.getRequestId(id);
		reqservice.deleteRequester(b);
		 
	}
}
