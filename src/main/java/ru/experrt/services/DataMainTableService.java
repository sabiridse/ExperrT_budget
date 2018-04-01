package ru.experrt.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.experrt.objects.DateForMainTable;
import ru.experrt.objects.HotPoints;

@Service
public class DataMainTableService {

	private ArrayList<DateForMainTable> mainTable = new ArrayList<>();
	private ArrayList<HotPoints> dataForHotPoints = new ArrayList<>();
	
	@Autowired
	NoteSummByDaysService nsbdService;

		
	public ArrayList<DateForMainTable> addData() {
		mainTable.clear();
		dataForHotPoints.clear();
		
		int ostat=3200;//В НАСТРОЙКИ
		
		int realOstatok;
		int lastOstatok;
		int iterator=-1;
		int prihod;
		int rashod;
		
		for (Date date:nsbdService.getDate()) {
			
			DateForMainTable dfmTable = new DateForMainTable();	
			HotPoints hotpoints = new HotPoints();
						
			dfmTable.setDate(this.dateFormat(date));
			dfmTable.setDayOfWeek(this.getDayOfWeek(date));
			
			prihod = this.getSummPrihodForDay(date);
			dfmTable.setPrihod(prihod);
			
			rashod = nsbdService.getSummDay(date)-prihod;
			dfmTable.setRashod(rashod);
			
			ostat=ostat+prihod-rashod;
			dfmTable.setOstatok(ostat);						                    	
			
			mainTable.add(dfmTable);
				
				if(iterator !=-1) {
					lastOstatok = mainTable.get(iterator).getOstatok();
					realOstatok = mainTable.get(iterator+1).getOstatok();
					if (realOstatok > lastOstatok){
						hotpoints.setDate(mainTable.get(iterator).getDate());
						hotpoints.setOstatok(mainTable.get(iterator).getOstatok());
						dataForHotPoints.add(hotpoints);
					}
				}
			iterator++;	
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



	public ArrayList<HotPoints> getDataForHotPoints() {
		return dataForHotPoints;
	}

	
}
