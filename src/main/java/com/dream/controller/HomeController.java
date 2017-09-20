package com.dream.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homePage")
public class HomeController {

	 @RequestMapping("/home")
	 public String home(HttpServletRequest request) {
		 return "欢迎你";
	 }
}
