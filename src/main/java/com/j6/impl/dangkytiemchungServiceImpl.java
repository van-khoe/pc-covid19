package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.dangkytiemchungDAO;
import com.j6.entity.lichtestcd;
import com.j6.entity.nguoitiem;
import com.j6.service.dangkytiemchungService;

@Service
public class dangkytiemchungServiceImpl implements dangkytiemchungService{
	@Autowired
	dangkytiemchungDAO dangkyDAO;

	@Override
	public nguoitiem save(nguoitiem dk) {
		return dangkyDAO.save(dk);
	}

	@Override
	public List<nguoitiem> findAll() {
		return dangkyDAO.findAll();
	}

	@Override
	public List<nguoitiem> findByAccount(String remoteUser) {
		return dangkyDAO.findByAccount(remoteUser);
	}

	@Override
	public nguoitiem findById(Integer id) {
		return dangkyDAO.findById(id).get();
	}

	@Override
	public List<Integer> findCountUser() {
		return dangkyDAO.findCountUser();
	}

	@Override
	public List<Integer> findCountM1() {
		return dangkyDAO.findCountM1();
	}

	@Override
	public List<Integer> findCountM2() {
		return dangkyDAO.findCountM2();
	}

	@Override
	public List<Object> findCT() {
		return dangkyDAO.findCT();
	}

	@Override
	public List<Object> findM1() {
		return dangkyDAO.findM1();
	}
	
	@Override
	public List<Object> findM2() {
		return dangkyDAO.findM2();
	}

	@Override
	public List<Object> findCT1() {
		return dangkyDAO.findCT1();
	}

}
