package com.j6.controller;

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
		model.addAttribute("khaibaoyte", true);
		if(!idkhaibao.isPresent()) {
			khaibaoyte kb = new khaibaoyte();
			model.addAttribute("kb",kb);
		}else {
			khaibaoyte khaibaoytee = khaibao.findById(idkhaibao.get());
			model.addAttribute("kb",khaibaoytee);
		}
		return "khaibaoyte/khaibaoyte";
	}
	
	@PostMapping("/khaibaoyte")
	public String home(Model model, @ModelAttribute("kb") khaibaoyte khaibaoyte) {
		model.addAttribute("home", true);
		System.out.println(khaibaoyte);
		String id = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(id);
		khaibaoyte.setAccount(account);
		khaibao.save(khaibaoyte);

		return "khaibaoyte/khaibaoyte";
	}
}
