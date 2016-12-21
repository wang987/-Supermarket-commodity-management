package com.sltl.userlogin.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.framework.BaseDao;
import com.entity.Adminlogin;
import com.entity.UserInfo;
/**
 * @author  ÎâÉ­
 * @Time 2016-11-22 23:30
 * @describe µÇÂ½Dao²ã
 */
@Repository
public class UserLoginDaoImpl extends BaseDao{
	
	public UserInfo daooperate(String name,String pwd){
		try{
			return super.findOneUser("from UserInfo lu where lu.username=? and lu.userpassword=?", new Object[]{name,pwd});
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
}
