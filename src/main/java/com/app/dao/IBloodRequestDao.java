package com.app.dao;

import java.util.List;

import com.app.pojos.BloodRequest;

public interface IBloodRequestDao {
	List<BloodRequest> getRequestList();
	List<BloodRequest> getRequestByDate(int u_id) ;
	List<BloodRequest> getRequestByBloodGroup(String blood_group);
	List<BloodRequest> getAllPendingRequestList();
	List<BloodRequest> getAllAppovedRequestList();
	BloodRequest addRequestDetails(BloodRequest b);
	BloodRequest getRequestById(int req_id);
	BloodRequest getRequestStatusByUserId(int requster_id);
	BloodRequest editRequestDetails(BloodRequest b);
	void removeRequest(BloodRequest b);
	void updateRequestStatus(int req_id);
}
