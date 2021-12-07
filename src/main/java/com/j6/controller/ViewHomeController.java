package com.j6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6.entity.blog;
import com.j6.service.blogService;

@Controller
public class ViewHomeController {
	
	@Autowired
	blogService blS;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("trangchu", true);
		List<blog> bl3 = blS.findByNgayTao();
		model.addAttribute("bl3", bl3);
		return "layout/home";
	}
}
