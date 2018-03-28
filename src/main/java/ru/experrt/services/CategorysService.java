package ru.experrt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.experrt.dao.CategorysDao;
import ru.experrt.entity.Categorys;

@Service
public class CategorysService {

	
	@Autowired
    CategorysDao categorysDao;
	
	public Categorys save(Categorys categorys) {
		return categorysDao.save(categorys);
	}

	public List<Categorys> findAll(){
		return categorysDao.findAll();
	}
	
}
