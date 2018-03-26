package ru.experrt.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tbl_noteSummDays")
@EntityListeners(AuditingEntityListener.class)
public class NoteSummByDays {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int id;
	
	@Column(name = "DATE")
	private Timestamp date;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "SUMM")
	private int summ;
	
	@Column(name = "OTHERS")
	private String others;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSumm() {
		return summ;
	}

	public void setSumm(int summ) {
		this.summ = summ;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	
	
	
	
}
