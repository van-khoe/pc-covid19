package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.j6.entity.khaibaoyte;

public interface khaibaoyteDAO extends JpaRepository<khaibaoyte, Long>{
	@Query("SELECT o FROM khaibaoyte o WHERE o.account.username=?1 ")
	List<khaibaoyte> findByUsername(String usernamekhaibao);
}
