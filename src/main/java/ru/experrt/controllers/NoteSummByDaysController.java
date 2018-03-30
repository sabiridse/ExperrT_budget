package ru.experrt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.entity.NoteSummByDays;
import ru.experrt.objects.DateForMainTable;
import ru.experrt.objects.Response;
import ru.experrt.services.DataMainTableService;
import ru.experrt.services.NoteSummByDaysService;

@RestController
public class NoteSummByDaysController {

	@Autowired
	NoteSummByDaysService nsbdService;
	
	@Autowired
	DataMainTableService dmtService;
	
	@Autowired
	DateForMainTable dfmTable;
	
	@PostMapping(value = "/newNoteByDays")
	public void createNewNote(@RequestBody NoteSummByDays nsbd) {
		nsbdService.save(nsbd);		
	}
	
	@GetMapping(value = "/updateMainTable")
	public Response getDataForMainTable() {
		Response response = new Response("Done", dmtService.addData());
		
		return response;
	}
	
}
