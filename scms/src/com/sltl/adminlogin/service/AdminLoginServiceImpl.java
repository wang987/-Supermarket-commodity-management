package com.sltl.adminlogin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.sltl.adminlogin.dao.AdminLoginDaoImpl;
/**
 * @author  吴森
 * @Time 2016-12-6 9:53
 * @describe 管理员管理用户，包括增删改查
 */
@Service
public class AdminLoginServiceImpl {

	@Resource(name="adminLoginDaoImpl")
	private AdminLoginDaoImpl adminLoginDaoImpl;
	//检查登陆
	public Adminlogin check(Adminlogin adminlogin) throws Exception
	{
		return adminLoginDaoImpl.check(adminlogin);
	}
	//展示用户信息
	public List<UserInfo> list() throws Exception
	{
		return adminLoginDaoImpl.list();
	}
	//通过id查找
	public List<UserInfo> byId(UserInfo userInfo) throws Exception
	{
		return adminLoginDaoImpl.byId(userInfo);
	}
	//保存
	public void save(UserInfo userInfo) throws Exception
	{
		if(userInfo.getUserinfoid()!=0)
		{
			adminLoginDaoImpl.save(userInfo);
		}else
		{
			adminLoginDaoImpl.add(userInfo);
		}
	}
	public void del(UserInfo userInfo)throws Exception
	{
		adminLoginDaoImpl.del(userInfo);
	}
}
