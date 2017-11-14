package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.TableDao;
import com.choice.eagle.entity.Table;
import com.choice.eagle.service.TableService;

public class TableServiceImpl implements TableService{
	@Autowired
	private TableDao tableDao;
	@Override
	public List<Table> selectStatus() {
		// TODO Auto-generated method stub
		return tableDao.selectStatus();
	}

}
