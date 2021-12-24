package com.j6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.khaibaoyte;
import com.j6.entity.taikhoan;
import com.j6.service.khaibaoyteService;
import com.j6.service.taikhoanService;
@Controller
public class KhaiBaoYteController {
	@Autowired
	khaibaoyteService khaibao;
	@Autowired
	taikhoanService taikhoanS;
	@Autowired
	HttpServletRequest rq;
	
	@GetMapping("/khaibaoyte")
	public String home(Model model, @RequestParam("kb") Optional<Long> idkhaibao) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newdate = new Date("2021/01/01");
		model.addAttribute("newd", sdf.format(newdate));
		if(idkhaibao == null) {
			khaibaoyte khaibaoytee = khaibao.findById(idkhaibao.get());
			model.addAttribute("kb",khaibaoytee);
		}else {
			khaibaoyte kb = new khaibaoyte();
			System.err.print(kb);
			model.addAttribute("kb",kb);
		}
		return "khaibaoyte/khaibaoyte";
	}
	
	@PostMapping("/khaibaoyte")
	public String home(Model model, @ModelAttribute("kb") khaibaoyte khaibaoyte) {
		model.addAttribute("home", true);
		String id = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(id);
		khaibaoyte.setAccount(account);
		khaibao.save(khaibaoyte);
		return "redirect:/lichsukhaibao";
	}
}
