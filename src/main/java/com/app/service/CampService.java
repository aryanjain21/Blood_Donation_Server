package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CampDaoImpl;
import com.app.pojos.Camp;

@Service
@Transactional
public class CampService implements ICampService{

	@Autowired
	private CampDaoImpl cdao;

	@Override
	public List<Camp> getCampDate() {
		return cdao.getCampByDate();
	}

	@Override
	public Camp getCampId(int cmpId) {
		return cdao.getCampById(cmpId);
	}

	@Override
	public List<Camp> getAllCamp() {
		return cdao.getAllCampsList();
	}

	@Override
	public void deleteCamp(Camp c) {
		cdao.removeCamp(c);
		
	}

	@Override
	public Camp updateCamp(Camp cmp) {
		return cdao.editCampDetails(cmp);
	}

	@Override
	public Camp addCamp(Camp cmp) {
		return cdao.addCampDetails(cmp);
	}
	
	
}
