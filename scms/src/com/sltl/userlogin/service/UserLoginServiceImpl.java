package com.sltl.userlogin.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.sltl.userlogin.dao.UserLoginDaoImpl;
/**
 * @author  ÎâÉ­
 * @Time 2016-11-22 23:30
 * @describe µÇÂ½service²ã
 */
@Service
public class UserLoginServiceImpl {
	
	@Resource
	UserLoginDaoImpl userLoginDaoImpl;
	
	public Adminlogin login(String name,String pwd){
		return this.userLoginDaoImpl.daooperate(name, pwd);
	}
	
	public String findRealName(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return this.userLoginDaoImpl.daooperate(name);
	}
}
