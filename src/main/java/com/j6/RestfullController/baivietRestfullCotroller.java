package com.j6.RestfullController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.j6.entity.blog;
import com.j6.entity.taikhoan;
import com.j6.entity.vacxin;
import com.j6.service.blogService;
import com.j6.service.taikhoanService;
import com.j6.service.vacxinService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/blog")
public class baivietRestfullCotroller {
	@Autowired
	blogService blogservice;
	
	@Autowired
	HttpServletRequest rq;
	
	@Autowired
	taikhoanService taikhoanS;
	
	@GetMapping
	public List<blog> getAll() {
		return blogservice.findAll();
	}
	
	@PostMapping
	public blog create(@RequestBody blog blog) {
		String id = rq.getRemoteUser();
		taikhoan acc = taikhoanS.findById(id);
		blog.setAccount(acc);
		return blogservice.create(blog);
	}
	
	@PutMapping("{idblog}")
	public blog update(@PathVariable("idblog") String id,@RequestBody blog blog) {
		return blogservice.update(blog);
	}
	
	@DeleteMapping("{idblog}")
	public void update(@PathVariable("idblog") String id) {
		blogservice.delete(id);
	}
}
