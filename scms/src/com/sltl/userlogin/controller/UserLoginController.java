package com.sltl.userlogin.controller;

import java.sql.SQLException;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.aop.DataSourceContextHolder;
import com.entity.Adminlogin;
import com.sltl.userlogin.service.UserLoginServiceImpl;



/**
 * @author  吴森
 * @Time 2016-11-20 14:49:01
 * @describe 用户进入后台需要验证
 */
@Controller
@RequestMapping("userlogin")
public class UserLoginController {
	@Resource
	private UserLoginServiceImpl userLoginServiceImpl;
	@RequestMapping("login")
	public String login(@RequestParam("yzm") String yzm,@RequestParam("username") String name,@RequestParam("pwd") String pwd, HttpSession session) throws SQLException, ClassNotFoundException{
		
		System.out.println("进来了");
		System.out.println("账号："+name);
		System.out.println("密码："+pwd);
		System.out.println("验证码："+yzm);
		String sRand=(String) session.getAttribute("post_validate_code");
		
		String errormessage="";//错误信息
		//查数据库
		Adminlogin lu=this.userLoginServiceImpl.login(name, pwd);
		if(lu==null){//账号密码存在
			errormessage="账号密码错误";
			session.setAttribute("errormessage", errormessage);
			return "user-login";
		}
		System.out.println(lu);
		DataSourceContextHolder.setDbInfo(lu.getAdminName()+ "," + "root" + ","+ "123456");
		session.setAttribute("dbInfo",lu.getAdminName()+ "," + "root" + ","+ "123456");
		if(yzm.equalsIgnoreCase(sRand)==false){//验证码
			errormessage="验证码错误";
			session.setAttribute("errormessage", errormessage);
			return "user-login";
		}
		System.out.println("成功");
		String admin=this.userLoginServiceImpl.findRealName(name);
		System.out.println("admin"+admin);
		session.setAttribute("admin", admin);
		return "index";
	
		
	}
}
