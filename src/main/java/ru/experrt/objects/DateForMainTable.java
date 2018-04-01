package ru.experrt.objects;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateForMainTable {

	private String date;
	private int prihod;
	private int rashod;
	private int ostatok;
	private String dayOfWeek;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrihod() {
		return prihod;
	}
	public void setPrihod(int prihod) {
		this.prihod = prihod;
	}
	public int getRashod() {
		return rashod;
	}
	public void setRashod(int rashod) {
		this.rashod = rashod;
	}
	public int getOstatok() {
		return ostatok;
	}
	public void setOstatok(int ostatok) {
		this.ostatok = ostatok;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	
	
}
