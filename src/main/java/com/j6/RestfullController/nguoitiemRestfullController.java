package com.j6.RestfullController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6.entity.lichtestcd;
import com.j6.entity.nguoitiem;
import com.j6.service.dangkytiemchungService;
import com.j6.service.lichtestcdService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/nguoitiem")
public class nguoitiemRestfullController {
	@Autowired
	dangkytiemchungService nguoitiemService;
	
	@GetMapping()
	public List<nguoitiem> getAll() {
		return nguoitiemService.findAll();
	}
	
	@GetMapping("counttc")
	public List<Integer> getCount() {
		return nguoitiemService.findCountUser();
	}
	
	@GetMapping("countm1")
	public List<Integer> getCountM1() {
		return nguoitiemService.findCountM1();
	}
	
	@GetMapping("countm2")
	public List<Integer> getCountM2() {
		return nguoitiemService.findCountM2();
	}
	
}
