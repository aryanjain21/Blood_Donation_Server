package com.app.dao;

import java.util.List;

import com.app.pojos.Camp;

public interface ICampDao {
	List<Camp> getAllCampsList();
	//List<Object[]> getAllCamps();
	Camp addCampDetails(Camp c);
	Camp getCampById(int campId);
	List<Camp> getCampByDate();
	Camp editCampDetails(Camp c);
	void removeCamp(Camp c);
}
