package ru.experrt.dao;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.experrt.entity.Days;


@Repository
@Transactional
public class DaysDao {

	@Autowired
    SessionFactory session;
	
	public boolean saveOrUpdate(Days days) {
        session.getCurrentSession(). saveOrUpdate(days);
        return true;
    }
	
	 public List<Days> list() {
	        return session.getCurrentSession().createQuery("from tbl_days").list();
	    }
	
}
