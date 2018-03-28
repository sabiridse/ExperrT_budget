package ru.experrt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tbl_categorys")
@EntityListeners(AuditingEntityListener.class)
public class Categorys {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int id;
	
	@Column(name = "CATEGORY")
	private String category;

	
	public Categorys(String category){
		this.category = category;		
	}
	
	public Categorys(){
	}
	
	
	public int getId() {
		return id;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
