package net.eimarketing.eim20180410.service;

import net.eimarketing.eim20180410.entity.User;

public interface UserService {

	public User findUser(String openid);	//查找微信用户
	public int addUser(User user);	//添加微信用户
}
