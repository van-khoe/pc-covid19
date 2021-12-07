package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.j6.entity.taikhoan;

public interface taikhoanDAO extends JpaRepository<taikhoan, String>{
	
	
	@Modifying
	@Transactional
	@Query(value = "SELECT Count(*) FROM taikhoan ", nativeQuery = true)
	List<Integer> findCountAccount();

}
