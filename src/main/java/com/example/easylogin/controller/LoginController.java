package com.example.easylogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.user;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepos;
	
	@RequestMapping("/")
	public String index() {
		return "Index";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("userName")String userName,
			@RequestParam("password")String password,
			Model m) {
		
		String message = "Welcome!";
		
		List<user> users = userRepos.findByUserNameAndPassword(userName, password);
		if (users.size()>0) {
			user user = users.get(0);
			message += user.getFullName();
		}else {
			message += "guest";
		}
		m.addAttribute("message",message);
		
		return "login";
	}
}
