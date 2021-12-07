package com.j6.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.dottiemDAO;
import com.j6.entity.dottiem;
import com.j6.service.dottiemService;

@Service
public class dottiemServiceImpl implements dottiemService {
@Autowired
dottiemDAO dtDao;

@Override
public dottiem findById(String id) {
	
	return dtDao.findById(id).get();
}

@Override
public List<dottiem> findAll() {
	
	return dtDao.findAll() ;
}

@Override
public dottiem create(dottiem dottiem) {
	return dtDao.save(dottiem);
}

@Override
public dottiem update(dottiem dottiem) {
	return dtDao.save(dottiem);
}

	

}
