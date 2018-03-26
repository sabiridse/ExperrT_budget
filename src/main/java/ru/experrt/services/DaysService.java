package ru.experrt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.experrt.dao.DaysRepository;
import ru.experrt.entity.Days;


@Service
public class DaysService {

	@Autowired
    DaysRepository daysRepo;	

/*to save an employee*/
	
	public Days save(Days days) {
		return daysRepo.save(days);
	}
	
	
	/* search all employees*/
	
	public List<Days> findAll(){
		return daysRepo.findAll();
	}
	
	
}
