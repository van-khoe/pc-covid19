package com.j6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.j6.entity.dottiem;


public interface dottiemService {
	
	dottiem findById(String id);

    List<dottiem> findAll();

	 dottiem create(dottiem dottiem);

	dottiem update(dottiem dottiem);
}
