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
	public String login(@RequestParam("yzm") String yzm,@RequestParam("username") String name,@RequestParam("pwd") String pwd, HttpSession session) throws SQLException, ClassNotFoundException{
		
		System.out.println("������");
		System.out.println("�˺ţ�"+name);
		System.out.println("���룺"+pwd);
		System.out.println("��֤�룺"+yzm);
		String sRand=(String) session.getAttribute("post_validate_code");
		
		String errormessage="";//������Ϣ
		//�����ݿ�
		Adminlogin lu=this.userLoginServiceImpl.login(name, pwd);
		if(lu==null){//�˺��������
			errormessage="�˺��������";
			session.setAttribute("errormessage", errormessage);
			return "user-login";
		}
		System.out.println(lu);
		DataSourceContextHolder.setDbInfo(lu.getAdminName()+ "," + "root" + ","+ "123456");
		session.setAttribute("dbInfo",lu.getAdminName()+ "," + "root" + ","+ "123456");
		if(yzm.equalsIgnoreCase(sRand)==false){//��֤��
			errormessage="��֤�����";
			session.setAttribute("errormessage", errormessage);
			return "user-login";
		}
		System.out.println("�ɹ�");
		String admin=this.userLoginServiceImpl.findRealName(name);
		System.out.println("admin"+admin);
		session.setAttribute("admin", admin);
		return "index";
	
		
	}
}
