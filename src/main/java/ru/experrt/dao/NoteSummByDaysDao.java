package ru.experrt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.experrt.entity.NoteSummByDays;

@Repository
@Transactional
public interface NoteSummByDaysDao extends JpaRepository <NoteSummByDays, Integer>{

}
