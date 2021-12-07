package com.j6.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.j6.entity.capquyen;

public interface capquyenDAO extends JpaRepository<capquyen, Integer> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM capquyen WHERE taikhoan_username = ?1", nativeQuery = true)
	void deleteByUsername(String username);

}
