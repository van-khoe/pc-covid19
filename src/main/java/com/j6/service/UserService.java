package com.j6.service;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.j6.entity.taikhoan;


@Service
public class UserService implements UserDetailsService{
	@Autowired
	taikhoanService taikhoanS;
	@Autowired
	capquyenService capquyen;
	@Autowired
	vaitroService vaitro;

	
	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Tới đây ch bro");
		try {
			System.out.println("Tới đây ch bro2");
			taikhoan taikhoan1 = taikhoanS.findById(username);
			System.out.println(username);
			String matkhau = taikhoan1.getMatkhau();
			System.out.println(matkhau);
			String [] vaitro = taikhoan1.getCapquyen().stream()
					.map(au -> au.getRole().getIdvaitro())
					.collect(Collectors.toList()).toArray(new String [0]);
			System.out.println(vaitro[0]);
			return User.withUsername(username).password(pe.encode(matkhau)).roles(vaitro).build();
		} catch (Exception e) {
			System.out.println("Tới đây ch bro5");
			throw new UsernameNotFoundException(username + "not found");
		}
	}
	

}
