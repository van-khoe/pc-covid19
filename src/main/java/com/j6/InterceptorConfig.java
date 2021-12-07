package com.j6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.j6.interceptor.GlobalInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	GlobalInterceptor gi;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(gi)
		.addPathPatterns("/khaibaoyte","/lichsutiem","/lichsukhaibao","/lichhentiemchung","/dangkytiemchung","/nhacnhotiemchung","/taikhoan/**","/home","/tintuc","/lienhe")
		.excludePathPatterns("/assert/admin/**");
	}
}
