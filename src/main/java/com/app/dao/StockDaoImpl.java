package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.StockDetails;

@Repository
public class StockDaoImpl implements IStockDao {

	@PersistenceContext
	private EntityManager sf;
	@Override
	public List<StockDetails> getAllStockList() {
		System.out.println("in donation list");
		
		String jpql="select s from StockDetails s";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfApos(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="A+";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfAneg(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="A-";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfBpos(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="B+";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfBneg(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="B-";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfOpos(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="O+";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfOneg(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="O-";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfABpos(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="AB+";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}
	
	@Override
	public List<StockDetails> getAllStockOfABneg(String blood_group)
	{
		System.out.println("in donation list");
		blood_group="AB-";
		String jpql="select s from StockDetails s where s.blood_group=:blood_group";
		List<StockDetails> stock_list=sf.unwrap(Session.class).createQuery(jpql,StockDetails.class).setParameter("blood_group", blood_group).getResultList();

		return stock_list;
	}

	@Override
	public StockDetails addStockDetails(StockDetails s) {
		sf.unwrap(Session.class).persist(s);
		return s;
	}

}
