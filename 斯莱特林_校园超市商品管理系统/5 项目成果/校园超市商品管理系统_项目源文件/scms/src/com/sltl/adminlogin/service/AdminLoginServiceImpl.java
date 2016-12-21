package com.sltl.adminlogin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.sltl.adminlogin.dao.AdminLoginDaoImpl;
/**
 * @author  ��ɭ
 * @Time 2016-12-6 9:53
 * @describe ����Ա�����û���������ɾ�Ĳ�
 */
@Service
public class AdminLoginServiceImpl {

	@Resource(name="adminLoginDaoImpl")
	private AdminLoginDaoImpl adminLoginDaoImpl;
	//����½
	public Adminlogin check(Adminlogin adminlogin) throws Exception
	{
		return adminLoginDaoImpl.check(adminlogin);
	}
	//չʾ�û���Ϣ
	public List<UserInfo> list() throws Exception
	{
		return adminLoginDaoImpl.list();
	}
	//ͨ��id����
	public List<UserInfo> byId(UserInfo userInfo) throws Exception
	{
		return adminLoginDaoImpl.byId(userInfo);
	}
	//����
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
