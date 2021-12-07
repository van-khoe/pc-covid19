package com.j6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.khaibaoyte;
import com.j6.entity.nguoitiem;
import com.j6.entity.phieutiem;
import com.j6.service.dangkytiemchungService;
import com.j6.service.khaibaoyteService;
import com.j6.service.phieudangkylichhenService;

@Controller
public class LichSuController {
	@Autowired
	dangkytiemchungService nguoitiemDao;
	@Autowired
	HttpServletRequest req;
	@Autowired
	phieudangkylichhenService phieutiemDao;
	@Autowired
	khaibaoyteService khaibaoyteService;
	

	@RequestMapping("/lichsukhaibao")
	public String home(Model model) {
		model.addAttribute("lichsu", true);
		String usernamekhaibao = req.getRemoteUser();
		List<khaibaoyte> khaibao = khaibaoyteService.findbyusername(usernamekhaibao);
		model.addAttribute("khaibao", khaibao);
		model.addAttribute("home", true);
		return "lichsu/lichsukhaibao";
	}

	@RequestMapping("/lichsutiem")
	public String home1(Model model) {
		model.addAttribute("lichsutiem", nguoitiemDao.findByAccount(req.getRemoteUser()));
		model.addAttribute("lichsu", true);
		return "lichsu/lichsutiem";
	}

	@RequestMapping("/chitietlichsutiem")
	public String home2(@RequestParam("idnguoitiem") Integer id,Model model) {
		List<phieutiem> pt = phieutiemDao.findByDangkytiemchung(id);
		model.addAttribute("nt", nguoitiemDao.findById(id));
		Date ngay = new Date();
		int so = 1;
		System.out.println(so == 0 ? "Trắng" : so == 1 ? "Vàng" : "Xanh");
		List<Integer> s = phieutiemDao.findCount(id);
		model.addAttribute("somui", s.get(0));
		model.addAttribute("ngay",ngay );
		model.addAttribute("nguoitiem",pt );
		model.addAttribute("lichsu", true);
		return "lichsu/chitietlichsutiem";
	}
}
