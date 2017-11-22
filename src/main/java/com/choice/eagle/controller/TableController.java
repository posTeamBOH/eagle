package com.choice.eagle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.Table;
import com.choice.eagle.service.TableService;

@Controller
@RequestMapping("/tables")
public class TableController {
	
	//日志记录
	Logger logger = LoggerFactory.getLogger(TableController.class);

	@Autowired
	private TableService tableService;
	
	/**
	 * 获取桌子编号 和状态
	 * @return
	 */
	@RequestMapping("/selectStatus")
	@ResponseBody
	public List<Table> selectStatus(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("====start====");
		List<Table> tablelist = tableService.selectStatus();
		logger.debug("TableController类    selectStatus方法");
		logger.error("TableController类    selectStatus方法");
		logger.info("====end====");
		return tablelist;
	}
}
