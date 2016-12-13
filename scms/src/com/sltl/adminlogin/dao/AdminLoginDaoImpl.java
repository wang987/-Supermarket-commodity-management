package com.sltl.adminlogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;

import com.entity.Adminlogin;
import com.entity.UserInfo;
import com.framework.BaseDao;
import com.framework.ConnectionManager;
/**
 * @author  吴森
 * @Time 2016-12-6 9:53
 * @describe 管理员管理用户，包括增删改查
 */
@Repository
public class AdminLoginDaoImpl extends BaseDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//登陆check
	public Adminlogin check(Adminlogin adminlogin) throws Exception
	{
		return super.findOne("from Adminlogin lu where lu.adminName=? and lu.adminpassword=?", new Object[]{adminlogin.getAdminName(),adminlogin.getAdminpassword()});
	}
	//展示用户列表
	public List<UserInfo> list() throws Exception
	{
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery("select * from userinfo").addEntity(UserInfo.class);
		 List<UserInfo> list = new ArrayList<UserInfo>();
		list = query.list();
		
		 return list;
	}
	//通过id查找
	public List<UserInfo> byId(UserInfo userInfo) throws Exception
	{
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery("select * from userinfo where userinfoid="+userInfo.getUserinfoid()).addEntity(UserInfo.class);
		 List<UserInfo> list = new ArrayList<UserInfo>();
			list = query.list();
		return list;
	}
	
	public void save(UserInfo userInfo)throws Exception
	{
		String sql="";
			sql="update userinfo set username=\""+userInfo.getUsername()+"\",  "
					+"userpassword=\""+userInfo.getUserpassword()+"\", "
					+"realname=\""+userInfo.getRealname()+"\", "
					+"sex=\""+userInfo.getSex()+"\", "
					+"tel=\""+userInfo.getTel()+"\", "
					+"email=\""+userInfo.getEmail()+"\", "
					+"school=\""+userInfo.getSchool()+"\" where userinfoid="+userInfo.getUserinfoid();
			this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();

	}
	public void add(UserInfo userInfo)throws Exception
	{
		String sql="insert into userinfo(username,userpassword,realname,sex,tel,email,school) values"
				+"(\""+
				userInfo.getUsername()+"\",\""+
				userInfo.getUserpassword()+"\",\""+
				userInfo.getRealname()+"\",\""+
				userInfo.getSex()+"\",\""+
				userInfo.getTel()+"\",\""+
				userInfo.getEmail()+"\",\""+
				userInfo.getSchool()
				+"\")";
		System.out.println(sql);
		this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		createDateBase(userInfo.getUsername());
		createTable(userInfo.getUsername());
		
	}
	public void del(UserInfo userInfo)throws Exception
	{
		System.out.println("1  "+userInfo.getUsername());
		dropDataBase(userInfo.getUsername());
		String sql="delete from userinfo where userinfoid="+userInfo.getUserinfoid();
		System.out.println(sql);
		this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		
	}
	
	static void createDateBase(String name) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user_information?useUnicode=true&characterEncoding=UTF-8";
		Connection c=DriverManager.getConnection(url, "root", "123456");
		Statement s=c.createStatement();
		String sql="create database "+ name;
		s.execute(sql);
		s.close();
		c.close();
	}
	static void createTable(String name) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/"+name+"?useUnicode=true&characterEncoding=UTF-8";
		Connection c=DriverManager.getConnection(url, "root", "123456");
		Statement s=c.createStatement();
		String sql1=" create table product(productid int auto_increment primary key,name varchar(20),count int,bid float,price float,profit float );";
		String sql2=" create table sales(salesid int auto_increment primary key,date date,salecount int);";
		String sql3=" create table productsales(productsales int auto_increment primary key,productid int,salesid int)";
		s.execute(sql1);
		s.execute(sql2);
		s.execute(sql3);
		s.close();
		c.close();
	}
	static void dropDataBase(String name) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8";
		Connection c=DriverManager.getConnection(url, "root", "123456");
		Statement s=c.createStatement();
		String sql="drop database "+name;
		s.execute(sql);
		s.close();
		c.close();
	}
}
