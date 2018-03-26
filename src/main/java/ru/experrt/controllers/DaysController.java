package ru.experrt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.Response;
import ru.experrt.entity.Days;
import ru.experrt.services.DaysService;

@RestController
public class DaysController {

	 @Autowired
	    DaysService daysServ;
	 //private static List<Days> daysList = new ArrayList<Days>();	
	
	 
	 @PostMapping(value = "/newDay")
		public void createEmployee(@RequestBody Days day) {
			daysServ.save(day);
		}
	 
	 @GetMapping(value = "/getCategoryList")
	   public Response getAll() {
		 Response response = new Response("Done", daysServ.findAll());
			return response;		
	    }

}
