package com.alireza.sixproject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeWorldController {
	@RequestMapping("")
	public String index(HttpSession session,@ModelAttribute("error") String error) {
		session.setAttribute("error", error);
		session.setAttribute("correct", "false");
		return "index.jsp";
	}
	@RequestMapping(value="", method=RequestMethod.POST)
	public String guess(HttpSession session, @RequestParam("codeName") String codeName, RedirectAttributes redirectAttributes) {
		if(codeName.equals("bushido")) {
			session.removeAttribute("error");
			session.setAttribute("correct", "true");
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	@RequestMapping("/code")
	public String correct(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println(session.getAttribute("error"));
		if(session.getAttribute("correct") == "true") {
			return "dashboard.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "YOU CAN NOT ENTER WITHOUT THE CODE.");
			return "redirect:/";
		}
	}

	

}



