package com.choice.eagle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.Table;
import com.choice.eagle.service.TableService;

@Controller
@RequestMapping("/tables")
public class TableController {

	@Autowired
	private TableService tableService;
	
	@RequestMapping("/selectStatus")
	@ResponseBody
	public List<Table> selectStatus(){
		return tableService.selectStatus();
	}
}
