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

import com.app.pojos.Camp;
import com.app.service.ICampService;

@RestController
@CrossOrigin
@RequestMapping("/camps")
public class CampController {
	
	@Autowired
	ICampService cservice;
	
	@GetMapping("/camplist")
	public ResponseEntity<?> listCamp()
	{
		//http://localhost:7070/test_boot/camps/camplist
		System.out.println("listCamp()");
		List<Camp> allCamp = cservice.getAllCamp();
		if(allCamp.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Camp>>(allCamp, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCampDetails(@PathVariable int id) {
		//http://localhost:7070/test_boot/camps/1
		System.out.println("in camp dtls " + id);
		Camp c = cservice.getCampId(id);
		if (c == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Camp>(c, HttpStatus.OK);
	}
	
	@GetMapping("/date")
	public ResponseEntity<?> getCampDetailsByDate() {
		//http://localhost:7070/test_boot/camps/date
		System.out.println("in request search by date:controller ");
		List<Camp> cmpDate = cservice.getCampDate();
		if (cmpDate == null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Camp>>(cmpDate, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addCampDetails(@RequestBody Camp c) {
		//http://localhost:7070/test_boot/camps/
		System.out.println("in add camp dtls " + c);
		try {
			return new ResponseEntity<Camp>(cservice.addCamp(c), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/camp/{id}")
	public Camp editCampDetails(@PathVariable int id,@RequestBody Camp c)
	{
		//http://localhost:7070/test_boot/camps/camp/3
		c.setCamp_id(id);
		
		System.out.println("in edit camp "+id);
		return cservice.updateCamp(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequester(@PathVariable int id)
	{
		//http://localhost:7070/test_boot/camps/2
		Camp c = cservice.getCampId(id);
		cservice.deleteCamp(c);
		 
	}
}
