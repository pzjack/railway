package org.pz.railway.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Task {

	@ModelAttribute("page")
    public String module() {
        return "tasks";
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "task", method = RequestMethod.GET)
    public String messages(Model model) {
    	
        model.addAttribute("tasks", new ArrayList());
        return "task/list";
    }
}
