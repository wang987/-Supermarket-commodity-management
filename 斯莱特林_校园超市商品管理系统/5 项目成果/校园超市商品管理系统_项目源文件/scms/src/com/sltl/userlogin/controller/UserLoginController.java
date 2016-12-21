package com.sltl.userlogin.controller;

import java.sql.SQLException;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.aop.DataSourceContextHolder;
import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.sltl.userlogin.service.UserLoginServiceImpl;



/**
 * @author  ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe �û������̨��Ҫ��֤
 */
@Controller
@RequestMapping("userlogin")
public class UserLoginController {
	@Resource
	private UserLoginServiceImpl userLoginServiceImpl;
	@RequestMapping("login")
	public String login(Model model,@RequestParam("yzm") String yzm,@RequestParam("username") String name,@RequestParam("pwd") String pwd, HttpSession session) throws SQLException, ClassNotFoundException{
		
		String sRand=(String) session.getAttribute("post_validate_code");
		
		String errormessage="";//������Ϣ
		//�����ݿ�
		UserInfo lu=this.userLoginServiceImpl.login(name, pwd);
		if(lu==null){//�˺��������
			errormessage="�˺��������";
			model.addAttribute("errormessage", errormessage);
			return "user-login";
		}
		System.out.println(lu);
		DataSourceContextHolder.setDbInfo(lu.getUsername()+ "," + "root" + ","+ "123456");
		session.setAttribute("dbInfo",lu.getUsername()+ "," + "root" + ","+ "123456");
		System.out.println("�̣߳�"+DataSourceContextHolder.getDbInfo());
		if(yzm.equalsIgnoreCase(sRand)==false){//��֤��
			errormessage="��֤�����";
			model.addAttribute("errormessage", errormessage);
			return "user-login";
		}
		session.setAttribute("user", lu.getRealname());
		return "index";
	}
}
