package ru.experrt.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	
	public void saveList(NoteSummByDays noteSumm) {
		nsbdDao.save(this.addListNotes(noteSumm));
	}
	
	public void saveListEvrDay(NoteSummByDays noteSumm) {
		nsbdDao.save(this.addListNotesEvrDay(noteSumm));
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
	
	private ArrayList<NoteSummByDays> addListNotes(NoteSummByDays nsbd){		
		Date date;
		ArrayList<NoteSummByDays> listNotes = new ArrayList<>();		
		listNotes.add(nsbd);
		
		for(int i = 1; i < 6; i++) {
			NoteSummByDays notes = new NoteSummByDays();
			notes.setId(0);
			notes.setCategory(nsbd.getCategory());
			notes.setSumm(nsbd.getSumm());
			notes.setOthers(nsbd.getOthers());		
			Calendar c = new GregorianCalendar();
			c.setTime(nsbd.getDate());
			c.add(Calendar.MONTH, +i);					
		    date = c.getTime();		
		    notes.setDate(new Timestamp(date.getTime()));		
		    listNotes.add(notes);
		}
		return listNotes;
	}
	
	private ArrayList<NoteSummByDays> addListNotesEvrDay(NoteSummByDays nsbd){		
		Date date;
		ArrayList<NoteSummByDays> listNotes = new ArrayList<>();		
		listNotes.add(nsbd);
		
		for(int i = 4; i < 180; i=i+4) {
			NoteSummByDays notes = new NoteSummByDays();
			notes.setId(0);
			notes.setCategory(nsbd.getCategory());
			notes.setSumm(nsbd.getSumm());
			notes.setOthers(nsbd.getOthers());		
			Calendar c = new GregorianCalendar();
			c.setTime(nsbd.getDate());
			c.add(Calendar.DAY_OF_YEAR, +i);					
		    date = c.getTime();		
		    notes.setDate(new Timestamp(date.getTime()));		
		    listNotes.add(notes);
		}
		return listNotes;
	}
	
}
