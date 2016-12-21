package com.sltl.adminlogin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aop.DataSourceContextHolder;
import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.google.gson.JsonArray;
import com.sltl.adminlogin.service.AdminLoginServiceImpl;

/**
 * @author  ��ɭ
 * @Time 2016-12-6 9:53
 * @describe ����Ա�����û���������ɾ�Ĳ�
 */
@Controller
@RequestMapping("adminlogin")
public class AdminLoginController {
	@Resource(name="adminLoginServiceImpl")
	private AdminLoginServiceImpl adminLoginServiceImpl;
	//��½���
	@RequestMapping(value="checkAdmin",method={RequestMethod.POST,RequestMethod.GET})
	public String login(Adminlogin adminlogin, HttpSession session,Model model)
	{	
		String url="";
		String errormessage="";//������Ϣ
		try {
		List<UserInfo> list =adminLoginServiceImpl.list();
		if(session.getAttribute("admin")!=null)
		{
			model.addAttribute("list",list);
			url="user-design";
		}else{
		
		
			//�����ݿ�
				Adminlogin admin = adminLoginServiceImpl.check(adminlogin);
				
				if(admin==null)
				{
					errormessage="<font color='red'>�˺��������</font>";
					model.addAttribute("errormessage", errormessage);
					url= "admin-login";
				}else
				{
					session.setAttribute("admin", admin);
					model.addAttribute("list",list);
					url="user-design";
				}
			
			}	
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		
		return url;
	}
	//��ת����û�
	@RequestMapping(value="addAdmin",method={RequestMethod.GET,RequestMethod.POST})
	public String addAdmin()
	{
		return "user-insert";
	}
	//��ת�޸��û�ҳ��
	@RequestMapping(value="modifyAdmin",method={RequestMethod.GET,RequestMethod.POST})
	public String modifyAdmin(UserInfo userInfo,Model model,HttpServletRequest request)
	{
		String message = request.getParameter("message");
		int userinfoid = Integer.parseInt(request.getParameter("userinfoid"));
		userInfo.setUserinfoid(userinfoid);
		System.out.println(message);
		try {
			List<UserInfo> u =adminLoginServiceImpl.byId(userInfo);
			model.addAttribute("ui", u);
			model.addAttribute("message",message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user-update";
	}
	//����
	@RequestMapping(value="save",method={RequestMethod.GET,RequestMethod.POST})
	public String save(UserInfo userInfo,RedirectAttributes model)
	{
		String url="";
		{
		try {
			adminLoginServiceImpl.save(userInfo);
			url="redirect:checkAdmin";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return url;
	}
	//ɾ��
	@RequestMapping(value="del",method={RequestMethod.GET,RequestMethod.POST})
	public String del(UserInfo userInfo)
	{
		String url="";
		try {
			adminLoginServiceImpl.del(userInfo);
			url="redirect:checkAdmin";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
}
