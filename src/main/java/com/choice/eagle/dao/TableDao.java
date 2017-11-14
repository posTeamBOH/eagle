package com.choice.eagle.dao;

import java.util.List;

import com.choice.eagle.entity.Table;


public interface TableDao {
	 //查询所有桌子状态
	List<Table> selectStatus();
    
	
}