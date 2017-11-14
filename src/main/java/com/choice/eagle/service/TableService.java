package com.choice.eagle.service;

import java.util.List;

import com.choice.eagle.entity.Table;

public interface TableService {
	 //查询所有桌子状态
		List<Table> selectStatus();
	    
}
