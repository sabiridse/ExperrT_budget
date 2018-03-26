package ru.experrt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.entity.NoteSummByDays;
import ru.experrt.services.NoteSummByDaysService;

@RestController
public class NoteSummByDaysController {

	@Autowired
	NoteSummByDaysService nsbdService;
	
	@PostMapping(value = "/newNote")
	public void createNewNote(@RequestBody NoteSummByDays nsbd) {
		nsbdService.save(nsbd);
	}
}
