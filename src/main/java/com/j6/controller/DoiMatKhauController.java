package com.j6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6.entity.taikhoan;
import com.j6.service.taikhoanService;


@Controller
public class DoiMatKhauController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	taikhoanService taikhoanService;
	
//	@RequestMapping("/taikhoan/doimatkhau")
//	public String home(Model model) {
//		model.addAttribute("home", true);
//		return "security/doimatkhau";
//	}
	
	@GetMapping("/taikhoan/doimatkhau")
	public String changepassword(Model model) {
		String username = request.getRemoteUser();
		taikhoan acc = taikhoanService.findById(username);
		model.addAttribute("acc", acc);
		model.addAttribute("taikhoan", true);
		return "security/doimatkhau";
	}

	@PostMapping("/taikhoan/doimatkhau")
	public String postChangepassword(Model model, @ModelAttribute("acc") taikhoan taikhoan) {
		String username = request.getRemoteUser();
		taikhoan acc = taikhoanService.findById(username);
		String password = request.getParameter("password");

		if (password.equalsIgnoreCase(acc.getMatkhau())) {
			taikhoan.setHoten(acc.getHoten());
			taikhoan.setDiachi(acc.getDiachi());
			taikhoan.setGioitinh(acc.getGioitinh());
			taikhoan.setSdt(acc.getSdt());
			taikhoan.setNgaysinh(acc.getNgaysinh());
			taikhoan.setTrangthai(acc.getTrangthai());
			taikhoan.setEmail(acc.getEmail());
			String newpass = request.getParameter("newpass");
			String conpass = request.getParameter("conpass");
			
			if(newpass.equals("")) {
				model.addAttribute("message", "Vui lòng nhập mật khẩu mới");
			}else {
				if(conpass.equals("")) {
					model.addAttribute("message", "Vui lòng nhập xác nhận mật khẩu");
				}else {
					
					if (newpass.equalsIgnoreCase(conpass)) {
						taikhoan.setMatkhau(newpass);
						taikhoanService.create(taikhoan);
						model.addAttribute("message", "Cập nhật thành công");
					} else {
						model.addAttribute("message", "Mật khẩu mới và mật khẩu xác nhận không khớp!");
					}
				}
			}
		} else {
			model.addAttribute("message", "Mật khẩu không chính xác!");
		}
		
		
		return "security/doimatkhau";
	}
}
