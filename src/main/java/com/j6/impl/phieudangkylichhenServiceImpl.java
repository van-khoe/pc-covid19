package com.j6.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.dangkytiemchungDAO;
import com.j6.dao.phieudangkylichhenDAO;
import com.j6.entity.nguoitiem;
import com.j6.entity.phieutiem;
import com.j6.service.MailerService;
import com.j6.service.phieudangkylichhenService;

@Service
public class phieudangkylichhenServiceImpl implements phieudangkylichhenService{
	@Autowired
	phieudangkylichhenDAO phieutiemDAO;
	@Autowired
	dangkytiemchungDAO nguoitiemDAO;
	@Autowired
	MailerService mailer;

	@Override
	public List<phieutiem> findAll() {
		// TODO Auto-generated method stub
		return phieutiemDAO.findAll();
	}

	@Override
	public phieutiem create(phieutiem phieutiem) {		
		int email = phieutiem.getDangkytiemchung().getIdnguoitiem();
		nguoitiem mailnguoitiem = nguoitiemDAO.findById(email).get();
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(phieutiem.getDottiem().getNgaytiem());
		System.out.println(date);
		
		try {
			mailer.send(mailnguoitiem.getEmail(), "Thông báo nhận lịch hẹn tiêm chủng", "Thông báo Ông/Bà : " 
					+ mailnguoitiem.getHoten() + " nhận lịch tiêm chủng vào ngày : " + date + 
					", tại cơ sở y tế : " + phieutiem.getCosoyte() + ", địa chỉ: " + phieutiem.getDiachi());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phieutiemDAO.save(phieutiem);
	}

	@Override
	public phieutiem update(phieutiem phieutiem) {
		// TODO Auto-generated method stub
		return phieutiemDAO.save(phieutiem);
	}

	@Override
	public void delete(Long id) {
		phieutiemDAO.deleteById(id);
		
	}

	@Override
	public List<phieutiem> findByAccount(String username) {
		// TODO Auto-generated method stub
		return phieutiemDAO.findByAccount(username);
	}

	@Override
	public phieutiem findById(Long id) {
		// TODO Auto-generated method stub
		return phieutiemDAO.findById(id).get();
	}

	@Override
	public List<phieutiem> findByDangkytiemchung(Integer id) {
		return phieutiemDAO.findByDangkytiemchung(id);
	}

	@Override
	public List<Integer> findCount(Integer id) {
		return phieutiemDAO.findCount(id);
	}

}
