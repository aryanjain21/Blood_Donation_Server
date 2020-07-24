package com.app.dao;

import java.util.List;

import com.app.pojos.StockDetails;

public interface IStockDao {

	List<StockDetails> getAllStockList();
	StockDetails addStockDetails(StockDetails s);
	List<StockDetails> getAllStockOfApos(String blood_group);
	List<StockDetails> getAllStockOfAneg(String blood_group);
	List<StockDetails> getAllStockOfBpos(String blood_group);
	List<StockDetails> getAllStockOfBneg(String blood_group);
	List<StockDetails> getAllStockOfOpos(String blood_group);
	List<StockDetails> getAllStockOfOneg(String blood_group);
	List<StockDetails> getAllStockOfABpos(String blood_group);
	List<StockDetails> getAllStockOfABneg(String blood_group);
}
