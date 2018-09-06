package net.eimarketing.eim20180410.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.eimarketing.eim20180410.dao.UserDao;
import net.eimarketing.eim20180410.entity.User;
import net.eimarketing.eim20180410.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public User findUser(String openid) {
		return userdao.findUser(openid);
	}

	@Override
	public int addUser(User user) {
		return userdao.addUser(user);
	}

}
