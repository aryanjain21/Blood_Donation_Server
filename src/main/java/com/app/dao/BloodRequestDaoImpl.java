package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.BloodRequest;

@Repository
public class BloodRequestDaoImpl implements IBloodRequestDao{

	@PersistenceContext
	private EntityManager sf;

	@Override
	public List<BloodRequest> getRequestList() {
		System.out.println("in getRequestList");
		String jpql="select b from BloodRequest b";
		return sf.unwrap(Session.class).createQuery(jpql, BloodRequest.class).getResultList();
	}
	
	@Override
	public List<BloodRequest> getAllPendingRequestList()
	{
		System.out.println("in request list");
	
		String jpql="select b from BloodRequest b where b.request_status=0";
	
		List<BloodRequest> request_list=sf.unwrap(Session.class).createQuery(jpql,BloodRequest.class).getResultList();

		return request_list;
	}
	
//	public List<BloodRequest> getAllPendingRequestList(int u_id)
//	{
//		System.out.println("in request list");
//	
//		String jpql="select b from BloodRequest b where b.request_status=0 and b.requster_id.u_id=:u_id";
//	
//		List<BloodRequest> request_list=sf.unwrap(Session.class).createQuery(jpql,BloodRequest.class).setParameter("u_id", u_id).getResultList();
//
//		return request_list;
//	}
	
	@Override
	public List<BloodRequest> getAllAppovedRequestList()
	{
		System.out.println("in request list");
	
		String jpql="select b from BloodRequest b where b.request_status=1";
		
		List<BloodRequest> request_list=sf.unwrap(Session.class).createQuery(jpql,BloodRequest.class).getResultList();

		return request_list;
	}

	@Override
	public List<BloodRequest> getRequestByDate(int u_id) {
		String jpql="select b from BloodRequest b where b.requster_id.u_id=:u_id order by b.require_date desc ";
		return sf.unwrap(Session.class).createQuery(jpql, BloodRequest.class).setParameter("u_id", u_id).getResultList();
	}
	
	public List<BloodRequest> getRequestByDate() {
		String jpql="select b from BloodRequest b order by b.require_date desc ";
		return sf.unwrap(Session.class).createQuery(jpql, BloodRequest.class).getResultList();
	}
	
	@Override
	public void updateRequestStatus(int req_id) {
		
		String jpql="update blood_request b SET b.request_status=1 where req_id=:req_id";
		sf.unwrap(Session.class).createNativeQuery(jpql, BloodRequest.class).setParameter("req_id", req_id).executeUpdate();
		
	}

	@Override
	public List<BloodRequest> getRequestByBloodGroup(String blood_group) {
		System.out.println("in getRequestByBloodGroup"+blood_group);
		String jpql = "select b from BloodRequest b where b.blood_group=:blood_group";
		return sf.unwrap(Session.class).createQuery(jpql, BloodRequest.class).setParameter("blood_group", blood_group).getResultList();
	}

	@Override
	public BloodRequest addRequestDetails(BloodRequest b) {
		sf.unwrap(Session.class).persist(b);
		return b;
	}

	@Override
	public BloodRequest getRequestById(int req_id) {
		return sf.unwrap(Session.class).get(BloodRequest.class, req_id);
	}
	
	@Override
	public BloodRequest getRequestStatusByUserId(int requster_id) {
		BloodRequest b= sf.unwrap(Session.class).get(BloodRequest.class, requster_id);
		return b;
		
	}

	@Override
	public BloodRequest editRequestDetails(BloodRequest b) {
		sf.unwrap(Session.class).update(b);
		return b;
	}

	@Override
	public void removeRequest(BloodRequest b) {
		sf.unwrap(Session.class).delete(b);;		
	}
	
	

}
