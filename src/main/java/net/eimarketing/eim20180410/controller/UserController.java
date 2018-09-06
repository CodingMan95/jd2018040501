package net.eimarketing.eim20180410.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import net.eimarketing.eim20180410.entity.User;
import net.eimarketing.eim20180410.exception.AppException;
import net.eimarketing.eim20180410.service.impl.UserServiceImpl;

@Controller
public class UserController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userServiceImpl;
	@ResponseBody
	@RequestMapping("findUser.do")
	public User findUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		//URLDecoder.decode(URLDecoder.decode(json, "GBK"), "UTF-8");
		//resp.setContentType("text/html;charset=utf-8");
		String openid = req.getParameter("openid");
		User resultUser = userServiceImpl.findUser(openid);
		if (resultUser == null) {
			throw new AppException("User is null");
		}

		System.out.println("resultUser:"+JSONObject.toJSONString(resultUser));
		
		return resultUser;
	}
}
