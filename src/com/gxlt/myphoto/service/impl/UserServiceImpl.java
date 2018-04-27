package com.gxlt.myphoto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxlt.myphoto.dao.IUserDao;
import com.gxlt.myphoto.entity.User;
import com.gxlt.myphoto.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User login(String username, String password) {
		List<User> list = userDao.queryByNameAndPwd2(username, password);
		if (list != null && list.size() > 0) {
			System.out.println("ÕÒµ½ÁË");
			System.out.println(list.get(0));
			return list.get(0);
		}
		return null;
	}

	/**
	 * ×¢²á
	 */
	@Override
	public int register(String username, String password) {
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		int insert = userDao.insert(user);
		return insert;
	}
}
