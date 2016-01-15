package org.pz.railway.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@ModelAttribute("page")
    public String module() {
        return "home";
    }
	
	@RequestMapping("/")
	public String home() {
		return "home/homeNotSignedIn";
	}

	@RequestMapping("/signin")
	public String signin() {
		return "home/signin";
	}

	@RequestMapping("/signup")
	public String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		model.addAttribute(new Object());
		if(requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false) {
			return "home/signup :: signupForm";
		}
		return "home/signup";
	}
}
