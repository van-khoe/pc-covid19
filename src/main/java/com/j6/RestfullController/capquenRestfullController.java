package com.j6.RestfullController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6.service.capquyenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/capquyen")
public class capquenRestfullController {
	@Autowired
	capquyenService cService;
	
	@DeleteMapping("username/{username}")
	public void delete(@PathVariable("username") String username) {
		cService.delete(username);
	}
}
