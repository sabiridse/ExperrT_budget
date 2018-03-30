package ru.experrt.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.experrt.objects.DateForMainTable;

@Service
public class DataMainTableService {

	private ArrayList<DateForMainTable> mainTable = new ArrayList<>();
	
	@Autowired
	NoteSummByDaysService nsbdService;
		
	public ArrayList addData() {
		mainTable.clear();
		
		int ostat=10000;//В НАСТРОЙКИ
		
		for (Date date:nsbdService.getDate()) {
			
			DateForMainTable dfmTable = new DateForMainTable();			

			dfmTable.setDate(this.dateFormat(date));
			dfmTable.setDayOfWeek(this.getDayOfWeek(date));
			
			int prihod = this.getSummPrihodForDay(date);
			dfmTable.setPrihod(prihod);
			
			int rashod = nsbdService.getSummDay(date)-prihod;
			dfmTable.setRashod(rashod);
			
			ostat=ostat+prihod-rashod;
			dfmTable.setOstatok(ostat);						                    	
			
			mainTable.add(dfmTable);
		}
		return mainTable;
	}
	
	private int getSummPrihodForDay(Date date) {		
		return nsbdService.getPrihodByDay(date);
	}
	
	private String dateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");        
		return dateFormat.format(date);
	}
	
	private String getDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String day="не определено";
		switch(dayOfWeek) {
			case 1: day="воскресенье";break;
			case 2: day="понедельник";break;
			case 3: day="вторник";break;
			case 4: day="среда";break;
			case 5: day="четверг";break;
			case 6: day="пятница";break;
			case 7: day="суббота";break;
		}		
		return day;
	}
	
}
