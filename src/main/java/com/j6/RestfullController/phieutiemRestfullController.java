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
import com.j6.entity.phieutiem;
import com.j6.service.lichtestcdService;
import com.j6.service.phieudangkylichhenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/phieutiem")
public class phieutiemRestfullController {
	@Autowired
	phieudangkylichhenService phieudangkylichhenservice;
	
	@GetMapping
	public List<phieutiem> getAll() {
		return phieudangkylichhenservice.findAll();
	}
	
	@PostMapping
	public phieutiem create(@RequestBody phieutiem phieutiem) {
		return phieudangkylichhenservice.create(phieutiem);
	}
	
	@PutMapping("{idphieutiem}")
	public phieutiem update(@PathVariable("idphieutiem") Long id,@RequestBody phieutiem phieutiem) {
		return phieudangkylichhenservice.update(phieutiem);
	}
	
	@DeleteMapping("{idphieutiem}")
	public void update(@PathVariable("idphieutiem") Long id) {
		phieudangkylichhenservice.delete(id);
	}
}
