package com.sltl.userlogin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.LoginUser;
import com.sltl.userlogin.service.UserLoginServiceImpl;


/**
 * @author ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe ��½�ĺ�̨��֤
 */
@Controller
@RequestMapping("userlogin")
public class UserLoginController {
	@Resource
	private UserLoginServiceImpl userLoginServiceImpl;
	@RequestMapping("login")
	public String login(@RequestParam("Verification") String verification,
			@RequestParam("loginName") String name,@RequestParam("password") String password,
			HttpSession session){
	
		//��֤�˺����룬������֤��

		return password;
		
	}
}
