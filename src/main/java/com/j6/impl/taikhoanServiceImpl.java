package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.taikhoanDAO;
import com.j6.entity.taikhoan;
import com.j6.service.taikhoanService;

@Service
public class taikhoanServiceImpl implements taikhoanService{
	
	@Autowired
	taikhoanDAO tkDao;

	@Override
	public taikhoan findById(String username) {
		return tkDao.findById(username).get();
	}

	@Override
	public taikhoan save(taikhoan acc) {
		// TODO Auto-generated method stub
		
		return tkDao.save(acc);
	}

	@Override
	public List<taikhoan> findAll() {
		return tkDao.findAll();
	}

	@Override
	public taikhoan create(taikhoan account) {
		return tkDao.save(account);
	}

	@Override
	public taikhoan update(taikhoan account) {
		return tkDao.save(account);
	}

	@Override
	public void delete(String username) {
		tkDao.deleteById(username);
		
	}

	@Override
	public List<Integer> findCountAccount() {
		return tkDao.findCountAccount();
	}

}
