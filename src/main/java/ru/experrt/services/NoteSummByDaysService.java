package ru.experrt.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.experrt.dao.NoteSummByDaysDao;
import ru.experrt.entity.NoteSummByDays;

@Service
public class NoteSummByDaysService {

	@Autowired
	NoteSummByDaysDao nsbdDao;
	
	public NoteSummByDays save(NoteSummByDays noteSumm) {
		return nsbdDao.save(noteSumm);
	}
	
	public List<NoteSummByDays> getList(){				
		return nsbdDao.findAll();
	}
	
	public List<Date> getDate(){
		return nsbdDao.getAllUnicalDate();
	}
	
	public int getSummDay(Date date){
		return nsbdDao.getSummDate(date);
	}
	
	public int getPrihodByDay(Date date) {
		
		try {
			return nsbdDao.getPrihodDate(date);
		} catch(Exception e) {return 0;}
	}
	
}
