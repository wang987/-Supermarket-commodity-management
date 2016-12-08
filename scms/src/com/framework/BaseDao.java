package com.framework;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import com.entity.Product;
import com.entity.ProductImEx;
import com.entity.UserInfo;

/**
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 这是一个数据库操作的类
 */
public abstract class BaseDao{
	@Resource
	private SessionFactory sessionFactory;
	
	

	//查询存在吗
	public Adminlogin findOne(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
			{
				
				query.setParameter(i, params[i]);
				//query.setString(i, (String) params[i]);
			}
				
		}
		return (Adminlogin) query.uniqueResult();
	}
	//查询用户
	public UserInfo findOneUser(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
			{
				
				query.setParameter(i, params[i]);
				//query.setString(i, (String) params[i]);
			}
				
		}
		return (UserInfo) query.uniqueResult();
	}
	//查看商品的搜索框
	public List<Product> getAllSeeByKey(String sql) throws SQLException {
		Connection connection=ConnectionManager.getInstance().getConnection();
		 Statement statement= connection.createStatement();
		 ResultSet resultSet=statement.executeQuery(sql);
		 List <Product> list=new ArrayList();
		 while(resultSet.next()){
			 Product p=new Product();
			 p.setProductId(resultSet.getInt("productid"));
			 p.setName(resultSet.getString("name"));
			 p.setCount(resultSet.getInt("count"));
			 p.setBid(resultSet.getFloat("bid"));
			 p.setPrice(resultSet.getFloat("price"));
			 p.setProfit(resultSet.getFloat("profit"));
			 list.add(p);
		 }
		 statement.close();
		 connection.close();
		return list;
	}
	public List<ProductImEx> getAllImExByKey(String sql) throws SQLException {
		Connection connection=ConnectionManager.getInstance().getConnection();
		 Statement statement= connection.createStatement();
		 ResultSet resultSet=statement.executeQuery(sql);
		 List <ProductImEx> list=new ArrayList();
		 while(resultSet.next()){
			 ProductImEx p=new ProductImEx();
			 p.setId(resultSet.getInt("productid"));
			 p.setBid(resultSet.getFloat("bid"));
			 p.setCount(resultSet.getInt("count"));
			 p.setName(resultSet.getString("name"));
			 p.setPrice(resultSet.getFloat("price"));
			 p.setProfit( resultSet.getFloat("profit"));
			 p.setSolds(resultSet.getInt("salecount"));
			 p.setProfits(resultSet.getInt("salecount")*resultSet.getFloat("profit"));
			 list.add(p);
		 }
		 statement.close();
		 connection.close();
		return list;
	}
	//查询有多少页
	public int finEndPage(String sql) throws SQLException {
		Connection connection=ConnectionManager.getInstance().getConnection();
		 Statement statement= connection.createStatement();
		 ResultSet resultSet=statement.executeQuery(sql);
		 int size=0;
		 while(resultSet.next()){
			size++;
		 }
		 if(size%4>0){
			 size=size/4+1;
		 }else{
			 size=size/4;
		 }
		 statement.close();
		 connection.close();
		return size;
	}
	//查看 所有商品
	public List<Product> findAllProduct(String sql) throws SQLException {
		Connection connection=ConnectionManager.getInstance().getConnection();
		 Statement statement= connection.createStatement();
		 ResultSet resultSet=statement.executeQuery(sql);
		List<Product> list=new ArrayList();
		while(resultSet.next()){
			Product e=new Product();
			e.setProductId(resultSet.getInt("productId"));
			e.setName(resultSet.getString("name"));
			e.setCount(resultSet.getInt("count"));
			e.setBid(resultSet.getFloat("bid"));
			e.setPrice(resultSet.getFloat("price"));
			e.setProfit(resultSet.getFloat("profit"));
			list.add(e);
		}
		 statement.close();
		 connection.close();
		return list;
	}
	//添加商品
	public String addProduct(String sql) throws SQLException {
		Connection connection=ConnectionManager.getInstance().getConnection();
		Statement statement= connection.createStatement();
		statement.executeUpdate(sql);
		String s="success";
		statement.close();
		connection.close();
		return s;
	}
	//删除商品
		public void delete(String sql)throws Exception{
			Connection connection=ConnectionManager.getInstance().getConnection();
			Statement statement= connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		}
		
		
		
		  //修改商品
		public String alter(String sql)throws SQLException{
			Connection connection=ConnectionManager.getInstance().getConnection();
			Statement statement= connection.createStatement();
			statement.executeUpdate(sql);
			String s="success";
			statement.close();
			connection.close();
			return s;
		}
		
		
		//查询一个商品
		public Product getOneProduct(String sql) throws SQLException{
			Connection connection=ConnectionManager.getInstance().getConnection();
			 Statement statement= connection.createStatement();
			 ResultSet resultSet=statement.executeQuery(sql);
			 Product p=new Product();
			 while(resultSet.next()){
				 p.setBid(resultSet.getFloat("bid"));
				 p.setCount(resultSet.getInt("count"));
				 p.setName(resultSet.getString("name"));
				 p.setPrice(resultSet.getFloat("price"));
				 p.setProductId(resultSet.getInt("productid"));
				 p.setProfit(resultSet.getFloat("profit"));
			 }
			 statement.close();
			 connection.close();
			return p;
		}
		//查找该插入的Id
		public int getNextId(String sql) throws SQLException{
			Connection connection=ConnectionManager.getInstance().getConnection();
			 Statement statement= connection.createStatement();
			 ResultSet resultSet=statement.executeQuery(sql);
			 int id=0;
			 while(resultSet.next()){
				if(resultSet.getInt("salesid")>id){
					id=resultSet.getInt("salesid");
				}
			 }
			 statement.close();
			 connection.close();
			return id+1;
		}
}
