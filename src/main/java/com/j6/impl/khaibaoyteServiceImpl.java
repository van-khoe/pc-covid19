package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.khaibaoyteDAO;
import com.j6.entity.khaibaoyte;
import com.j6.service.khaibaoyteService;

@Service
public class khaibaoyteServiceImpl implements khaibaoyteService{
	@Autowired
	khaibaoyteDAO khaibaoDAO;

	@Override
	public List<khaibaoyte> findbyusername(String usernamekhaibao) {
		return khaibaoDAO.findByUsername(usernamekhaibao);
	}

	@Override
	public khaibaoyte findById(Long long1) {
		return khaibaoDAO.findById(long1).get();
	}
	
	@Override
	public khaibaoyte save(khaibaoyte khaibaoyte) {
		
		return khaibaoDAO.save(khaibaoyte);
	}
}
