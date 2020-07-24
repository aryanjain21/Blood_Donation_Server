package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BloodRequestDaoImpl;
import com.app.pojos.BloodRequest;

@Service
@Transactional
public class RequesterService implements IRequestService {
	
	@Autowired
	private BloodRequestDaoImpl rdao;

	@Override
	public List<BloodRequest> getRequestDate(int u_id) {
		return rdao.getRequestByDate(u_id);
	}
	
	@Override
	public List<BloodRequest> getRequestDate() {
		return rdao.getRequestByDate();
	}

	@Override
	public List<BloodRequest> getRequestBloodGroup(String bloodGroup) {
		return rdao.getRequestByBloodGroup(bloodGroup);
	}

	@Override
	public BloodRequest getRequestId(int reqId) {
		return rdao.getRequestById(reqId);
	}

	@Override
	public List<BloodRequest> getAllRequester() {
		// TODO Auto-generated method stub
		return rdao.getRequestList();
	}

	@Override
	public void deleteRequester(BloodRequest b) {
		rdao.removeRequest(b);
		
	}

	@Override
	public BloodRequest updateRequester(BloodRequest br) {
		return rdao.editRequestDetails(br);
	}

	@Override
	public BloodRequest addRequester(BloodRequest br) {
		return rdao.addRequestDetails(br);
	}

	@Override
	public BloodRequest getRequestStatusUserId(int requster_id) {
		return rdao.getRequestStatusByUserId(requster_id);
	}

	@Override
	public List<BloodRequest> getPendingRequestList() {
		return rdao.getAllPendingRequestList();
	}
	
//	@Override
//	public List<BloodRequest> getPendingRequestList(int u_id) {
//		return rdao.getAllPendingRequestList(u_id);
//	}

	@Override
	public List<BloodRequest> getAppovedRequestList() {
		return rdao.getAllAppovedRequestList();
	}

	@Override
	public void updateRequesterStatus(int req_id) {
		rdao.updateRequestStatus(req_id);
		
	}

}
