package ru.experrt.services;

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
	
	
}
