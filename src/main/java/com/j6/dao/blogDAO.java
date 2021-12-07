package com.j6.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.j6.entity.blog;

public interface blogDAO extends JpaRepository<blog, Integer>{
	@Query(value="select * from blog b where b.tieude like %?1%", nativeQuery = true)
	Page<blog> findByTieude(@Param("tieude") String tieude, Pageable pageable);
	
	@Query(value = "SELECT * FROM blog b WHERE b.ngaytao ORDER BY b.ngaytao DESC LIMIT 3", nativeQuery = true)
	List<blog> findByNgayTao();

	@Query(value = "SELECT * FROM blog b WHERE b.ngaytao ORDER BY b.ngaytao DESC LIMIT 2", nativeQuery = true)
	List<blog> findTop2ByNgayTao();
}
