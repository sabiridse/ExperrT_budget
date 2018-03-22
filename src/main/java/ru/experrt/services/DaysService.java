package ru.experrt.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.experrt.dao.DaysDao;
import ru.experrt.entity.Days;


@Service
public class DaysService {

	@Autowired
    DaysDao daysDao;
	
	 public boolean saveOrUpdate(Days days) {
	        return daysDao.saveOrUpdate(days);
	    }
	 
	    public List<Days> list() {
	       
	        return daysDao.list();
	    }
	
}
