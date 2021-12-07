package com.j6.service;

import java.util.List;

import com.j6.entity.lichtestcd;

public interface lichtestcdService {

	List<lichtestcd> findAll();

	lichtestcd create(lichtestcd lichtest);

	lichtestcd update(lichtestcd lichtest);

	void delete(Integer id);

}
