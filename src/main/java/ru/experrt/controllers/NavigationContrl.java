package ru.experrt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationContrl {

	@RequestMapping(value = "/hotPoints")
    public String getHotPointsPage() {
        return "veiw/hotPoints";
    }
	
	@RequestMapping(value = "/properties")
    public String getPropPage() {
        return "veiw/properties";
    }
	
//	@RequestMapping(value = "/testPage")
//    public String getTestPage() {
//        return "forms/testPage";
//    }
	
}
