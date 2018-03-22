package ru.experrt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationContrl {

	@RequestMapping(value = "/godbay")
    public String getPage() {
        return "veiw/bay";
    }
	
	@RequestMapping(value = "/hello")
    public String getPage1() {
        return "forms/hello";
    }
	
	@RequestMapping(value = "/testPage")
    public String getTestPage() {
        return "forms/testPage";
    }
	
}
