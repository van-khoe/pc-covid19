//package com.j6.controller;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.j6.dao.taikhoanDAO;
//import com.j6.entity.taikhoan;
//import com.j6.service.UserService;
//
//
//@CrossOrigin("*")
//@Controller
//public class SecurityController {
//	@Autowired
//	HttpServletRequest req;
//	@Autowired
//	taikhoanDAO tkdao;
//	
//	@RequestMapping("/security/login/form")
//	public String loginForm(Model model) {
//		
//			model.addAttribute("message", "Vui lòng đăng nhập!");
//			return "security/dangnhap";
//		
//		
//	}
//	
//	@RequestMapping("/security/login/error")
//	public String erroe(Model model) {
//		model.addAttribute("message", "Tài khoản hoặc mật khẩu sai");
//		return "security/dangnhap";
//	}
//	
//	@RequestMapping("/security/login/success")
//	public String loginSuccess(Model model) {		
//		model.addAttribute("message", "Đăng nhập thành công");
//		return "security/dangnhap";
//	}
//	
//	
//	@RequestMapping("/security/logoff/success")
//	public String logoffSuccess(Model model) {
//		model.addAttribute("message", "Bạn đã đăng xuất");
//		return "security/dangnhap";
//	}
//	
//	@Autowired
//	UserService userService;
//	
//}
