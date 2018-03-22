package ru.experrt.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.experrt.entity.Days;
import ru.experrt.services.DaysService;

@Controller
public class DaysController {

	 @Autowired
	    DaysService daysService;
	
	 @RequestMapping(value = "/list")
	    public @ResponseBody Map<String, Object> getAll(Days dayss) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        List<Days> list = daysService.list();
	 
	        if (list != null) {
	            map.put("status", "200");
	            map.put("message", "Data found");
	            map.put("data", list);
	        } else {
	            map.put("status", "404");
	            map.put("message", "Data not found");
	 
	        }
	 
	        return map;
	    }
}
