package com.j6.RestfullController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6.entity.dottiem;
import com.j6.service.dottiemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/dottiem")
public class DotTiemRestController {
	@Autowired
	dottiemService dottiemservice;

	@GetMapping
	public List<dottiem> getAll() {
		return dottiemservice.findAll();
	}

	@PostMapping
	public dottiem create(@RequestBody dottiem dottiem) {
		return dottiemservice.create(dottiem);
	}

	@PutMapping("{iddottiem}")
	public dottiem update(@PathVariable("iddottiem") String id, @RequestBody dottiem dottiem) {
		return dottiemservice.update(dottiem);
	}
}
