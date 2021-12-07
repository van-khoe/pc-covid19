package com.j6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6.entity.taikhoan;
import com.j6.service.MailerService;
import com.j6.service.taikhoanService;


@Controller
public class QuenMatKhauController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	MailerService mailer;
	@Autowired
	taikhoanService taikhoanservice;
	

	@RequestMapping("/quenmatkhau")
	public String postForgotpassword(Model model) {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		try {
			taikhoan acc = taikhoanservice.findById(username);
			if (acc.getEmail().equalsIgnoreCase(email)) {
				try {
					mailer.send(email, "Mật Khẩu Trả về", acc.getMatkhau());
					model.addAttribute("message", "Mật khẩu của bạn sẽ được gửi về email trong giây lát");
				} catch (Exception e) {
					return e.getMessage();
				}
			} else {
				model.addAttribute("message", "Email không chính xác!");
			}
		} catch (Exception e) {
			model.addAttribute("message", "Không tìm thấy tài khoản này!");
		}

		return "redirect:/home";
	}
}
