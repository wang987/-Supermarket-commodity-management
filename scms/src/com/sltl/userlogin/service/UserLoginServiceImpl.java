package com.sltl.userlogin.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.sltl.userlogin.dao.UserLoginDaoImpl;
/**
 * @author  ��ɭ
 * @Time 2016-11-22 23:30
 * @describe ��½service��
 */
@Service
public class UserLoginServiceImpl {
	
	@Resource
	UserLoginDaoImpl userLoginDaoImpl;
	
	public UserInfo login(String name,String pwd){
		return this.userLoginDaoImpl.daooperate(name, pwd);
	}
	
	
}
