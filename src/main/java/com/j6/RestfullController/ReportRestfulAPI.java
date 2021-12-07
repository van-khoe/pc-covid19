package com.j6.RestfullController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6.service.dangkytiemchungService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/reports")
public class ReportRestfulAPI {
	@Autowired
	dangkytiemchungService nguoitiemService;
	
	@GetMapping("chuatiem")
	public List<Object> getCount() {
		return nguoitiemService.findCT();
	}
	
	@GetMapping("chuatiem1")
	public List<Object> getCount1() {
		return nguoitiemService.findCT1();
	}
	
	@GetMapping("tiemmui1")
	public List<Object> getCountM1() {
		return nguoitiemService.findM1();
	}
	
	@GetMapping("tiemmui2")
	public List<Object> getCountM2() {
		return nguoitiemService.findM2();
	}
}
