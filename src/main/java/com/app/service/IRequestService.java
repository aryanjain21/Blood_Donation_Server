package com.app.service;

import java.util.List;

import com.app.pojos.BloodRequest;

public interface IRequestService {

	List<BloodRequest> getRequestDate(int u_id);
	List<BloodRequest> getRequestDate();
	List<BloodRequest> getRequestBloodGroup(String bloodGroup);
	BloodRequest getRequestId(int reqId);
	BloodRequest getRequestStatusUserId(int requster_id);
	List<BloodRequest> getAllRequester();
	List<BloodRequest> getPendingRequestList();
//	List<BloodRequest> getPendingRequestList(int u_id);
	List<BloodRequest> getAppovedRequestList();
	void deleteRequester(BloodRequest b);
	void updateRequesterStatus(int req_id);
	BloodRequest updateRequester(BloodRequest br);
	BloodRequest addRequester(BloodRequest br);
}
