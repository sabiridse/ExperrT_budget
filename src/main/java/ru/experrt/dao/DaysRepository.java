package ru.experrt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.experrt.entity.Days;

@Repository
@Transactional
public interface DaysRepository extends JpaRepository <Days, Integer>{
	
	
	
}
