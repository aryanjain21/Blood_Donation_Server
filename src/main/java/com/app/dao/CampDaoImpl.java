package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Camp;

@Repository
public class CampDaoImpl implements ICampDao {

	@PersistenceContext
	private EntityManager sf;
	
	public CampDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Camp> getAllCampsList() {
		System.out.println("in getAllCampsList()");
		String jpql="select c from Camp c left outer join fetch c.organizer_id";
		List<Camp> campList = sf.unwrap(Session.class).createQuery(jpql, Camp.class).getResultList();
		return campList;
	}
	
//	@Override
//	public List<Camp> getAllCampsList()
//	{
//		System.out.println("in camp list");
//		//SELECT c, p.name FROM Country c LEFT OUTER JOIN c.capital p
//		//String jpql="select c from Camp c";
//		//SELECT DISTINCT e FROM Employee e INNER JOIN FETCH e.tasks t");
//		String jpql="select c from Camp c left outer join fetch c.organizer_id";
//		List<Camp> camp_list=sf.unwrap(Session.class).createQuery(jpql,Camp.class).getResultList();
////		for (Camp camps : camp_list) {
////			System.out.println(camps.toString());
////		}
//		return camp_list;
//	}

	@Override
	public Camp addCampDetails(Camp c) {
		sf.unwrap(Session.class).persist(c);
		return c;
	}

	@Override
	public Camp getCampById(int campId) {
		return sf.unwrap(Session.class).get(Camp.class, campId);
	}

	@Override
	public List<Camp> getCampByDate() {
		String jpql="select c from Camp c order by c.camp_date desc";
		return sf.unwrap(Session.class).createQuery(jpql, Camp.class).getResultList();
	}

	@Override
	public Camp editCampDetails(Camp c) {
		sf.unwrap(Session.class).update(c);		
		return c;
	}

	@Override
	public void removeCamp(Camp c) {
		
		sf.unwrap(Session.class).delete(c);
		
	}

}
