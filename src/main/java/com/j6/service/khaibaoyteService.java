package com.j6.service;

import java.util.List;

import com.j6.entity.khaibaoyte;

public interface khaibaoyteService {
	List<khaibaoyte> findbyusername(String usernamekhaibao);

	khaibaoyte findById(Long long1);
	
	khaibaoyte save(khaibaoyte khaibaoyte);
}
