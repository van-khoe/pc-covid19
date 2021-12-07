package com.j6.service;

import java.util.List;

import com.j6.entity.taikhoan;

public interface taikhoanService {

	taikhoan findById(String username);

	taikhoan save(taikhoan acc);

	List<taikhoan> findAll();

	taikhoan create(taikhoan account);

	taikhoan update(taikhoan account);

	void delete(String username);

	List<Integer> findCountAccount();

}
