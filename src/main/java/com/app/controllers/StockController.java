package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.StockDaoImpl;
import com.app.pojos.StockDetails;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	StockDaoImpl sdao;
	
	@GetMapping
	public ResponseEntity<?> listStock() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockList();
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	
	@GetMapping("/A+")
	public ResponseEntity<?> listStockofApos() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfApos("A+");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	@GetMapping("/A-")
	public ResponseEntity<?> listStockofAnsg() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfAneg("A-");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	
	
	@GetMapping("/B+")
	public ResponseEntity<?> listStockofBpos() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfBpos("B+");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	@GetMapping("/B-")
	public ResponseEntity<?> listStockofBneg() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfBneg("B-");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	
	@GetMapping("/O+")
	public ResponseEntity<?> listStockofOpos() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfOpos("O+");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	@GetMapping("/O-")
	public ResponseEntity<?> listStockofOneg() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfOneg("O-");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	
	@GetMapping("/AB+")
	public ResponseEntity<?> listStockofABpos() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfABpos("AB+");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	@GetMapping("/AB-")
	public ResponseEntity<?> listStockofABneg() {
		System.out.println("in list request");
		List<StockDetails> allStock = sdao.getAllStockOfOneg("AB-");
		if (allStock.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<StockDetails>>(allStock, HttpStatus.OK);
	}
	
	@PostMapping("/d")
	public ResponseEntity<?> addStock(@RequestBody StockDetails stock)
	{		
		System.out.println("in process stock controller form : "+ stock.getBlood_amt());
	
		StockDetails s=sdao.addStockDetails(stock);

		System.out.println(s);
			if(s!= null)
			{
				System.out.println("Everthing is fine");
				return new ResponseEntity<StockDetails>(s, HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	
	}

}
