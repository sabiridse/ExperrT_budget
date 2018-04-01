package ru.experrt.objects;

import org.springframework.stereotype.Component;

@Component
public class HotPoints {

	private String date;
	private int ostatok;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOstatok() {
		return ostatok;
	}
	public void setOstatok(int ostatok) {
		this.ostatok = ostatok;
	}
	
}
