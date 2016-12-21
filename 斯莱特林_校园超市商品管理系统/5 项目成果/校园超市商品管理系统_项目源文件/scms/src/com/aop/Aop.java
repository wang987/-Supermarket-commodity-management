package com.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.jolbox.bonecp.BoneCPDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe ����Aop����
 */
public class Aop {
	/**
	 * @describe �����ĳ���
	 */
	private static HttpSession session;
	private static ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	/**
	 * @param ��ʼ��Aop
	 */
	public Aop() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @describe ǰ�÷���
	 * @throws Throwable
	 */
	public void before() throws Throwable {
		System.out.println("before");
		/*String dbInfo=DataSourceContextHolder.getDbInfo();	
		System.out.println("deinfo:"+dbInfo);
		if(dbInfo!=null&&!dbInfo.equals("")){
			System.out.println("�����ˣ�������NULL");
			String infos[]=dbInfo.split(",");
			for(int i=0;i<infos.length;i++){
				System.out.println(infos[i]);
			}
			
			BoneCPDataSource  basicDataSource = (BoneCPDataSource)context.getBean("dataSource1");
			System.out.println("δ�ı�ã�"+basicDataSource.getJdbcUrl());
			basicDataSource.getConnection().close();
			basicDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/"+infos[0]+"?useUnicode=true&characterEncoding=UTF-8");
			basicDataSource.setUsername(infos[1]);
			if(infos.length>2 && infos[2]!=null && !infos[2].equals(""))
				basicDataSource.setPassword(infos[2]);
			else
				basicDataSource.setPassword("");

			
		}*/
	}

	
	/**
	 * @describe ����֪ͨ
	 */
	public void afterReturning() {
		System.out.println("after");

	}
	
}
