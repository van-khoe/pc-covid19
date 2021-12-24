package com.j6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.nguoitiem;
import com.j6.entity.phieutiem;
import com.j6.entity.taikhoan;
import com.j6.service.dangkytiemchungService;
import com.j6.service.phieudangkylichhenService;
import com.j6.service.taikhoanService;
import com.j6.service.vacxinService;

@Controller
public class NguoiTiemController {
	
	@Autowired
	HttpServletRequest rq;
	@Autowired
	taikhoanService taikhoanS;
	@Autowired
	dangkytiemchungService dangkyS;
	@Autowired
	vacxinService vacS;
	@Autowired
	phieudangkylichhenService lichhenS;
	
	@RequestMapping("/lichhentiemchung")
	public String phieutiem(Model model) {
		String id = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(id);
		List<phieutiem> pt = lichhenS.findByAccount(account.getUsername());
		model.addAttribute("pt", pt);
		model.addAttribute("home", true);
		return "tiemchung/lichhentiemchung";
	}
	@RequestMapping("/chitietlichtiem")
	public String phieutiem1(@RequestParam("idphieu") Long id,Model model) {
		String ida = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(ida);
		List<phieutiem> pt = lichhenS.findByAccount(account.getUsername());
		for(phieutiem p : pt){
			if(p.getIdphieutiem().equals(id) ) {
				phieutiem phieutiem = lichhenS.findById(id);
				model.addAttribute("phieutiem", phieutiem);
				model.addAttribute("home", true);
				return "tiemchung/chitietlichtiem";
			}
		}
		
		return "tiemchung/lichhentiemchung";
	}
	
	@GetMapping("/dangkytiemchung")
	public String home1(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newdate = new Date();
		model.addAttribute("newd", sdf.format(newdate));
		nguoitiem dk = new nguoitiem();
		dk.setGioitinh(true);
		model.addAttribute("dk", dk);

		model.addAttribute("home", true);
		return "tiemchung/dangkytiemchung";
	}
	
	@PostMapping("/dangkytiemchung")
	public String home1n(Model model,@Validated @ModelAttribute("dk") nguoitiem dk, Errors err) {
		try {
			int l=0;
			List<nguoitiem> nguoitiem = dangkyS.findAll();
			String id = rq.getRemoteUser();
			taikhoan account = taikhoanS.findById(id);

			dk.setAccount(account);
			for(nguoitiem n : nguoitiem) {
				if(!n.getCmnd().equalsIgnoreCase(dk.getCmnd())) {
					l=0;
				}else {
					l=1;
					break;
				}
			}
			if(l==0) {
			if(!err.hasErrors()) {
				dangkyS.save(dk);
				model.addAttribute("message", "Đăng ký thành công");
			}
			else {
				System.out.println(err.getAllErrors());
				model.addAttribute("message", "Đăng ký thất bại");
			}
			}else {
				model.addAttribute("tb", "CMND đã tồn tại");
				System.out.println("CMND đã tồn tại");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("home", true);
		return "tiemchung/dangkytiemchung";
	}
	
	@RequestMapping("/nhacnhotiemchung")
	public String home2(Model model) {
		model.addAttribute("home", true);
		return "tiemchung/nhacnhotiemchung";
	}
}
