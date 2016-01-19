package org.pz.railway.mvc;

import javax.validation.Valid;

import org.pz.railway.form.OrgForm;
import org.pz.railway.form.UserForm;
import org.pz.railway.service.OrgService;
import org.pz.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

	@Autowired
	private OrgService orgService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("page")
    public String module() {
        return "admin";
    }
	
	//-------------org manager---------------------------//
	@RequestMapping(value = "/manager/orgs", method = RequestMethod.GET)
    public String orgList(Model model) {
		model.addAttribute("orgs", orgService.findOrg());
        // the view will match 'messages/*'; see /WEB-INF/views/message/tiles-defs.xml
        return "tileview/orglist";
    }
	
	@RequestMapping("/manager/org/new")
	public String orgnew(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		model.addAttribute(new OrgForm());
		if(requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false) {
			return "notileview/org/new :: orgForm";
		}
		return "notileview/org/new";
	}
	
	@RequestMapping("/manager/org/save")
	public String orgsave(@Valid @ModelAttribute OrgForm model, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return "notileview/org/new";
		}
		orgService.saveOrg(model);
//        MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/manager/orgs";
	}
	
	
	//-------------org manager end---------------------------//

	//-------------user manager---------------------------//
	@RequestMapping(value = "/manager/users", method = RequestMethod.GET)
    public String userList(Model model) {
		model.addAttribute("users", userService.findUser());
        // the view will match 'messages/*'; see /WEB-INF/views/message/tiles-defs.xml
        return "tileview/userlist";
    }
	
	@RequestMapping("/manager/user/new")
	public String usernew(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		model.addAttribute(new UserForm());
		if(requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false) {
			return "notileview/user/new :: userForm";
		}
		return "notileview/user/new";
	}
	
	@RequestMapping("/manager/user/save")
	public String usersave(@Valid @ModelAttribute UserForm model, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return "notileview/user/new";
		}
		userService.saveUser(model, errors);
		return "redirect:/manager/users";
	}

	//-------------user manager end---------------------------//
}
