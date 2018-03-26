package ru.experrt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.experrt.Response;
import ru.experrt.entity.Days;

@RestController
public class RestWebController {

	//private static List<Days> daysList = new ArrayList<Days>();	
	
//	@PostMapping(value = "/setUser")
//	public void postCustomer(@RequestBody UsersList userL) {
//		usersList.add(userL);				
//	}
//	
//	@PostMapping(value = "/searchUser")
//	public Response searchByLogin(@RequestBody String login) {	
//		searchByLoginList.clear();
//		for(UsersList rowUsL:usersList) {
//			if (rowUsL.getLogin().contains(login)==true){
//				searchByLoginList.add(rowUsL);
//			}
//		}	
//		Response response = new Response("Done", searchByLoginList);		
//		return response;
//	}
	
//	@GetMapping(value = "/loadAll")
//	public Response loadAllList() {	
//		Response response = new Response("Done", daysList);
//		return response;		
//	}
	
	
}
