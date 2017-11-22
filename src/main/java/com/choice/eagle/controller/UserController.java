package com.choice.eagle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.User;
import com.choice.eagle.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/insertUser")
	@ResponseBody
	public boolean insertUser(@RequestParam("userName") String userName,@RequestParam("userPhone") String userPhone) {
		User user=new User();
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		int i=userService.insertUser(user);
		if(i==0) {
			return false;
		}
		return true;
}
}
