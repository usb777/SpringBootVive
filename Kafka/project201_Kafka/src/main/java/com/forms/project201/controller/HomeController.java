package com.forms.project201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/loadform")
	public String loadFormPage()
	{
		return "formtemplate";
	}
	
	@RequestMapping("/processform")
	public String loadFromPage(@RequestParam("login") String login, Model model)
	{
		model.addAttribute("loginval", login);
		return "confirm";
	}
	
	

}
