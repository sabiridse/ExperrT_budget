package ru.experrt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.entity.Categorys;
import ru.experrt.objects.Response;
import ru.experrt.services.CategorysService;

@RestController
public class CategorysController {

	 @Autowired
	    CategorysService categorysServ;
	 //private static List<Days> daysList = new ArrayList<Days>();	
	
	 
	 @PostMapping(value = "/newCategory")
		public void createEmployee(@RequestBody Categorys categorys) {
		 categorysServ.save(categorys);
		}
	 
	 @GetMapping(value = "/getCategoryList")
	   public Response getAll() {
		 Response response = new Response("Done", categorysServ.findAll());
			return response;		
	    }

}
