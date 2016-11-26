package com.sltl.userlogin.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.framework.BaseDao;
import com.entity.Adminlogin;
/**
 * @author  ÎâÉ­
 * @Time 2016-11-22 23:30
 * @describe µÇÂ½Dao²ã
 */
@Repository
public class UserLoginDaoImpl extends BaseDao{
	
	public Adminlogin daooperate(String name,String pwd){
		try{
			return super.findOne("from Adminlogin lu where lu.adminName=? and lu.adminpassword=?", new Object[]{name,pwd});
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public String daooperate(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql="select * from product where productid='"+name+"'";
		
		return super.findrealNameByLoginname("select * from product where productid=1");
	}
}
