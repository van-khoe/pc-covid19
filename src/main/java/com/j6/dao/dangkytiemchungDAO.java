package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.j6.entity.nguoitiem;

public interface dangkytiemchungDAO extends JpaRepository<nguoitiem, Integer>{

	@Query("SELECT o FROM nguoitiem o WHERE o.account.username=?1")
	List<nguoitiem> findByAccount(String remoteUser);

	
	@Modifying
	@Transactional
	@Query(value = "SELECT Count(*) FROM nguoitiem ", nativeQuery = true)
	List<Integer> findCountUser();

	@Modifying
	@Transactional
	@Query(value = "SELECT count(distinct(nt.idnguoitiem)) FROM (nguoitiem as nt join phieutiem as pt on nt.idnguoitiem = pt.dangkytiemchung_iddangkytiemchung) join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem where dt.ngaytiem < CURDATE() ", nativeQuery = true)
	List<Integer> findCountM1();

	@Modifying
	@Transactional
	@Query(value = "select count(distinct(nt.idnguoitiem)) from (nguoitiem as nt join phieutiem as pt on nt.idnguoitiem = pt.dangkytiemchung_iddangkytiemchung) join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem where dt.ngaytiem < CURDATE() and pt.dangkytiemchung_iddangkytiemchung In (select pt.dangkytiemchung_iddangkytiemchung as tc from phieutiem as pt join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem where dt.ngaytiem < CURDATE() group by tc having count(tc) >= 2) ", nativeQuery = true)
	List<Integer> findCountM2();

	@Modifying
	@Transactional
	@Query(value = "select nt.hoten, nt.ngaysinh, nt.cmnd, nt.tiensubenh from nguoitiem as nt  where nt.idnguoitiem NOT IN (select pt.dangkytiemchung_iddangkytiemchung from phieutiem as pt)", nativeQuery = true)
	List<Object> findCT();

	@Modifying
	@Transactional
	@Query(value = "select distinct(nt.hoten), nt.ngaysinh, nt.cmnd, nt.tiensubenh, pt.diachi, pt.cosoyte, dt.ngaytiem, vx.tenvacxin from ((nguoitiem as nt join phieutiem as pt on nt.idnguoitiem = pt.dangkytiemchung_iddangkytiemchung) join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem) join vacxin as vx on dt.vacxin_idvacxin = vx.idvacxin where dt.ngaytiem < CURDATE() ", nativeQuery = true)
	List<Object> findM1();

	@Modifying
	@Transactional
	@Query(value = "select nt.hoten, nt.ngaysinh, nt.cmnd, nt.tiensubenh, pt.diachi, pt.cosoyte, dt.ngaytiem, vx.tenvacxin from ((nguoitiem as nt join phieutiem as pt on nt.idnguoitiem = pt.dangkytiemchung_iddangkytiemchung) join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem) join vacxin as vx on dt.vacxin_idvacxin = vx.idvacxin where dt.ngaytiem < CURDATE() and pt.dangkytiemchung_iddangkytiemchung In (select pt.dangkytiemchung_iddangkytiemchung as tc from phieutiem as pt join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem where dt.ngaytiem < CURDATE() group by tc having count(tc) >= 2) ", nativeQuery = true)
	List<Object> findM2();

	@Modifying
	@Transactional
	@Query(value = "select nt.hoten, nt.ngaysinh, nt.cmnd, nt.tiensubenh, pt.diachi, pt.cosoyte, dt.ngaytiem, vx.tenvacxin from ((nguoitiem as nt join phieutiem as pt on nt.idnguoitiem = pt.dangkytiemchung_iddangkytiemchung) join dottiem as dt on pt.dottiem_iddottiem = dt.iddottiem) join vacxin as vx on dt.vacxin_idvacxin = vx.idvacxin where dt.ngaytiem > CURDATE() ", nativeQuery = true)
	List<Object> findCT1();

}
