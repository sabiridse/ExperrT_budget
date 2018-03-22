package ru.experrt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="tbl_days")
public class Days {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private Long Id;
	
	@Column(name = "DATE")
	private Date DateDay;

	@Column(name = "DAY_OF_WEEK")
	private String DayOfWeek;

	@Column(name = "PRIHOD")
	private int Prihod;

	@Column(name = "RASHOD")
	private int Rashod;

	@Column(name = "BALANSE")
	private int Balanse;

	@Column(name = "HOSTOVAR")
	private int Hostovar;

	@Column(name = "ALKO")
	private int Alko;

	@Column(name = "PRODUKTS")
	private int Produkts;

	@Column(name = "CREDITS")
	private int Credits;
	
	@Column(name = "TELEPHONES")
	private int Telephones;

	@Column(name = "GASOLINE")
	private int Gasoline;

	@Column(name = "CAFE")
	private int Cafe;

	@Column(name = "CASH")
	private int Cash;

	@Column(name = "KVARTPLATA")
	private int Kvartplata;

	@Column(name = "INTERNET")
	private int Internet;

	@Column(name = "KVITANC")
	private int Kvitanc;
	
	@Column(name = "LINA")
	private int Lina;

	@Column(name = "OTHERS")
	private int Others;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDateDay() {
		return DateDay;
	}

	public void setDateDay(Date dateDay) {
		DateDay = dateDay;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

	public int getPrihod() {
		return Prihod;
	}

	public void setPrihod(int prihod) {
		Prihod = prihod;
	}

	public int getRashod() {
		return Rashod;
	}

	public void setRashod(int rashod) {
		Rashod = rashod;
	}

	public int getBalanse() {
		return Balanse;
	}

	public void setBalanse(int balanse) {
		Balanse = balanse;
	}

	public int getHostovar() {
		return Hostovar;
	}

	public void setHostovar(int hostovar) {
		Hostovar = hostovar;
	}

	public int getAlko() {
		return Alko;
	}

	public void setAlko(int alko) {
		Alko = alko;
	}

	public int getProdukts() {
		return Produkts;
	}

	public void setProdukts(int produkts) {
		Produkts = produkts;
	}

	public int getCredits() {
		return Credits;
	}

	public void setCredits(int credits) {
		Credits = credits;
	}

	public int getTelephones() {
		return Telephones;
	}

	public void setTelephones(int telephones) {
		Telephones = telephones;
	}

	public int getGasoline() {
		return Gasoline;
	}

	public void setGasoline(int gasoline) {
		Gasoline = gasoline;
	}

	public int getCafe() {
		return Cafe;
	}

	public void setCafe(int cafe) {
		Cafe = cafe;
	}

	public int getCash() {
		return Cash;
	}

	public void setCash(int cash) {
		Cash = cash;
	}

	public int getKvartplata() {
		return Kvartplata;
	}

	public void setKvartplata(int kvartplata) {
		Kvartplata = kvartplata;
	}

	public int getInternet() {
		return Internet;
	}

	public void setInternet(int internet) {
		Internet = internet;
	}

	public int getKvitanc() {
		return Kvitanc;
	}

	public void setKvitanc(int kvitanc) {
		Kvitanc = kvitanc;
	}

	public int getLina() {
		return Lina;
	}

	public void setLina(int lina) {
		Lina = lina;
	}

	public int getOthers() {
		return Others;
	}

	public void setOthers(int others) {
		Others = others;
	}
	
}
