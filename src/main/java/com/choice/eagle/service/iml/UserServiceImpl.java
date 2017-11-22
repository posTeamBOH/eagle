package com.choice.eagle.service.iml;

import com.choice.eagle.dao.UserDao;
import com.choice.eagle.entity.User;
import com.choice.eagle.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

}
