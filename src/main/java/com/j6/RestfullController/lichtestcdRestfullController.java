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
import com.j6.service.lichtestcdService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/lichtest")
public class lichtestcdRestfullController {
	@Autowired
	lichtestcdService lichtestService;
	
	@GetMapping()
	public List<lichtestcd> getAll() {
		return lichtestService.findAll();
	}
	
//	@GetMapping("{id}")
//	public Product getOne(@PathVariable("id") Integer id) {
//		return productService.findById(id);
//	}
	
	@PostMapping
	public lichtestcd create(@RequestBody lichtestcd lichtest) {
		return lichtestService.create(lichtest);
	}
	
	@PutMapping("{id}")
	public lichtestcd update(@PathVariable("id") Integer id,@RequestBody lichtestcd lichtest) {
		return lichtestService.update(lichtest);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		lichtestService.delete(id);
	}
}
