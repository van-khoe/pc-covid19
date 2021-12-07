package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.j6.entity.phieutiem;

public interface phieudangkylichhenDAO extends JpaRepository<phieutiem, Long> {
	@Query("SELECT o FROM phieutiem o WHERE o.dangkytiemchung.account.username=?1")
	List<phieutiem> findByAccount(String username);

	@Query("SELECT o FROM phieutiem o WHERE o.dangkytiemchung.idnguoitiem=?1")
	List<phieutiem> findByDangkytiemchung(Integer id);

	@Modifying
	@Transactional
	@Query(value = "SELECT Count(*) FROM phieutiem as pt join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem WHERE pt.dangkytiemchung_iddangkytiemchung = ?1 and dt.ngaytiem < CURDATE()", nativeQuery = true)
	List<Integer> findCount(Integer id);

}
