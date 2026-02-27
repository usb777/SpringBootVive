package com.forms.project201.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Value("${dda.event.enabled:false}")
	private boolean startstop;
	
	@RequestMapping("/")
	public String homePage() {
         if (startstop) {return "index";}
		 else return "about";

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

	@RequestMapping("/about")
	public String aboutPage(){
			return "about";
			}
	
	

}
