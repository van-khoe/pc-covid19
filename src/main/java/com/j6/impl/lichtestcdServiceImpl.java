package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.lichtestcdDAO;
import com.j6.entity.lichtestcd;
import com.j6.service.lichtestcdService;

@Service
public class lichtestcdServiceImpl implements lichtestcdService{
	@Autowired
	lichtestcdDAO ldao;
	
	@Override
	public List<lichtestcd> findAll() {
		return ldao.findAll();
	}

	@Override
	public lichtestcd create(lichtestcd lichtest) {
		return ldao.save(lichtest);
	}

	@Override
	public lichtestcd update(lichtestcd lichtest) {
		return ldao.save(lichtest);
	}

	@Override
	public void delete(Integer id) {
		ldao.deleteById(id);
	}
}
