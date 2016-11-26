package com.framework;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.DataSourceContextHolder;
import com.jolbox.bonecp.BoneCPDataSource;
import com.entity.Adminlogin;

/**
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 这是一个数据库操作的类
 */
public abstract class BaseDao{
	@Resource
	private SessionFactory sessionFactory;
	
	

	//查询真实姓名
	public String findrealNameByLoginname(String sql) throws SQLException, ClassNotFoundException {
//		 Statement statement= this.getConnection().createStatement();
//		 ResultSet resultSet=statement.executeQuery(sql);
//		 while(resultSet.next()){
//			 //return resultSet.getString("realname");
//			 return resultSet.getString("name");
//		 }
//		return null;
		
		 Statement statement= ConnectionManager.getInstance().getConnection().createStatement();
		 ResultSet resultSet=statement.executeQuery(sql);
		 while(resultSet.next()){
			 //return resultSet.getString("realname");
			 return resultSet.getString("name");
		 }
		return null;
		
		
	}
	//查询存在吗
	public Adminlogin findOne(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
			{
				System.out.println(params[i]);
				query.setParameter(i, params[i]);
				//query.setString(i, (String) params[i]);
			}
				
		}
		return (Adminlogin) query.uniqueResult();
	}
	
}
