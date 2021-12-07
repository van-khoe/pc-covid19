package com.j6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.j6.entity.blog;
import com.j6.entity.vacxin;

public interface blogService{
	
	

	List<blog> findAll();

	Page<blog> findByTieude(String tieude, Pageable pageable);

	List<blog> findByNgayTao();

	blog findById(Integer id);

	Page<blog> findAllPage(Pageable pageable);

	blog create(blog blog);

	blog update(blog blog);

	void delete(String id);

	List<blog> findTop2ByNgayTao();
		

}
