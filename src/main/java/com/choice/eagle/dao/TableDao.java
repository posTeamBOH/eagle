package com.choice.eagle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.choice.eagle.entity.Table;


public interface TableDao {
	 //查询所有桌子状态
	List<Table> selectStatus();
	
	//根据桌子号改变桌子状态
	int updateTableStatus(@Param("tableId")String tableId, @Param("status")String status);
    
	
}