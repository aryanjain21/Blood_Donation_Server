package com.app.service;

import java.util.List;

import com.app.pojos.Camp;

public interface ICampService {
	
	List<Camp> getCampDate();
	Camp getCampId(int cmpId);
	List<Camp> getAllCamp();
	void deleteCamp(Camp c);
	Camp updateCamp(Camp cmp);
	Camp addCamp(Camp cmp);
}
