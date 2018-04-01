package ru.experrt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.objects.Response;
import ru.experrt.services.DataMainTableService;

@RestController
public class HotPoinsController {

	@Autowired
	DataMainTableService dmtService;
	
	@GetMapping(value = "/updateHotPointsTable")
	public Response getHotPointsTable() {
		Response response = new Response("Done", dmtService.getDataForHotPoints());		
		return response;
	}
	
}
