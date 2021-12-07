package com.j6.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.capquyenDAO;
import com.j6.entity.capquyen;
import com.j6.service.capquyenService;

@Service
public class capquyenServiceImpl implements capquyenService{
	@Autowired
	capquyenDAO cDao;

	@Override
	public capquyen create(capquyen authority) {
		return cDao.save(authority);
	}

	@Override
	public void delete(String username) {
		cDao.deleteByUsername(username);
		
	}

}
