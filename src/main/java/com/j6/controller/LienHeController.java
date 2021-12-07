package com.j6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6.service.MailerService;
@Controller
public class LienHeController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	MailerService mailer;
	@RequestMapping("/lienhe")
	public String home(Model model) {
		model.addAttribute("lienhe", true);
		String email = "nghialtpc00727@fpt.edu.vn";
		String hoten = request.getParameter("hoten");
		String Emailnguoilienhe = request.getParameter("email");
		String tieude = request.getParameter("tieude");
		String noidung = request.getParameter("noidung");
		try {
			mailer.send(email, "Người dùng gửi liên hệ", Emailnguoilienhe+ '\n' + hoten + '\n' + tieude + '\n'+ noidung);
			System.out.println(Emailnguoilienhe+ '\n' + hoten + '\n' + tieude + '\n'+ noidung);
			
		} catch (Exception e) {
			return e.getMessage();
		}
		return "lienhe/lienhe";
	}
	
}

