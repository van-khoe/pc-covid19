package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.j6.dao.blogDAO;
import com.j6.entity.blog;
import com.j6.entity.vacxin;
import com.j6.service.blogService;

@Service
public class blogServiceImpl implements blogService{
	
	@Autowired
	blogDAO blogdao;

	@Override
	public List<blog> findAll() {
		// TODO Auto-generated method stub
		return blogdao.findAll();
	}

	@Override
	public List<blog> findByNgayTao() {
		// TODO Auto-generated method stub
		return blogdao.findByNgayTao();
	}

	@Override
	public blog findById(Integer id) {
		// TODO Auto-generated method stub
		return blogdao.findById(id).get();
	}

	@Override
	public Page<blog> findAllPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return blogdao.findAll(pageable);
	}

	@Override
	public Page<blog> findByTieude(String tieude, Pageable pageable) {
		// TODO Auto-generated method stub
		return blogdao.findByTieude(tieude, pageable);
	}

	@Override
	public blog create(blog blog) {
		// TODO Auto-generated method stub
		return blogdao.save(blog);
	}

	@Override
	public blog update(blog blog) {
		// TODO Auto-generated method stub
		return blogdao.save(blog);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<blog> findTop2ByNgayTao() {
		// TODO Auto-generated method stub
		return blogdao.findTop2ByNgayTao();
	}

}
