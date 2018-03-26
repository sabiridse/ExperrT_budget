package ru.experrt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="tbl_days")
@EntityListeners(AuditingEntityListener.class)

public class Days {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int id;
	
	@NotNull
    @Size(min=2, max=35)
	@Column(name = "DAY_OF_WEEK")
	private String dayOfWeek;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

//	 public Days(){
//	    }
//
//	    public Days(int id, String dayOfWeek) {
//	        this.id = id;
//	        this.dayOfWeek = dayOfWeek;
//	    }
		
}
