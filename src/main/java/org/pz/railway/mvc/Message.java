package org.pz.railway.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Message {

	@ModelAttribute("page")
    public String module() {
        return "messages";
    }
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
//        model.addAttribute("messages", messageRepository.findAll());
		model.addAttribute("messages", new ArrayList());
        // the view will match 'messages/*'; see /WEB-INF/views/message/tiles-defs.xml
        return "message/list";
    }
}
