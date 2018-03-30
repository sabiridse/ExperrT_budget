package ru.experrt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.experrt.entity.NoteSummByDays;

@Repository
@Transactional
public interface NoteSummByDaysDao extends JpaRepository <NoteSummByDays, Integer>{

	@Query("select DISTINCT date FROM NoteSummByDays order by date")
	List<Date> getAllUnicalDate();

	@Query("select SUM(summ) from NoteSummByDays where date = :date")
	int getSummDate(@Param("date") Date date);

	@Query("select SUM(summ) from NoteSummByDays where date = :date and category = 'приход'")
	int getPrihodDate(@Param("date") Date date);
}
