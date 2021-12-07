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

import com.j6.entity.capquyen;
import com.j6.entity.taikhoan;
import com.j6.service.capquyenService;
import com.j6.service.taikhoanService;
import com.j6.service.vaitroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/taikhoan")
public class taikhoanRestfullController {
	
	@Autowired
	taikhoanService tkService;
	@Autowired
	capquyenService cService;
	@Autowired
	vaitroService vService;
	
	
	@GetMapping("all")
	public List<taikhoan> getAll(){
		return tkService.findAll();
	}
	
	@GetMapping("counttk")
	public List<Integer> getCount(){
		return tkService.findCountAccount();
	}
	
	@PostMapping()
	public taikhoan create(@RequestBody taikhoan account) {	
		return tkService.create(account);
	}
	
	@PostMapping("vaitro")
	public capquyen create1(@RequestBody capquyen authority) {
		return cService.create(authority);
	}
	
	@PutMapping("{username}")
	public taikhoan update(@RequestBody taikhoan account, @PathVariable("username") String username) {
		return tkService.update(account);
	}
	
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		tkService.delete(username);
	}
}
