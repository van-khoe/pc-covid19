package com.j6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.blog;
import com.j6.entity.dottiem;
import com.j6.service.blogService;
import com.j6.service.dottiemService;

@Controller
public class TinTucController {
	@Autowired
	blogService blogservice;
	
	@Autowired
	dottiemService dottiemservice;
	
	@RequestMapping("/tintuc")
	public String home(Model model, @RequestParam("timkiem") Optional<String> tieude, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("tintuc", true);
		List<blog> ganday = blogservice.findByNgayTao();
		List<dottiem> dottiem = dottiemservice.findAll();
		int page1 = p.orElse(0);
		if (page1 < 0) {
			page1 = 0;
		}
		
		Pageable pageable = PageRequest.of(page1, 5, Sort.by(Direction.DESC, "ngaytao"));
		Page<blog> pagebl = blogservice.findAllPage(pageable);
		
		if(tieude.isPresent()) {
		
			Page<blog> find = blogservice.findByTieude(tieude.get(), pageable);
			model.addAttribute("bl",find);
		}
		else {
			
			model.addAttribute("bl",pagebl);
		}
		model.addAttribute("ganday",ganday);
		model.addAttribute("dottiem",dottiem);
		return "tintuc/tintuc";
	}
	
	@RequestMapping("/chitiettintuc")
	public String chitiet(Model model,@RequestParam("idtintuc") Integer id) {
		List<blog> ganday = blogservice.findByNgayTao();
		blog chitiet = blogservice.findById(id);
		model.addAttribute("chitiet",chitiet);
		model.addAttribute("ganday",ganday);
		model.addAttribute("tintuc", true);
		return "tintuc/blog-single";
	}
}

