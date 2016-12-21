package com.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe �࣬�߳�ʵ�ֹ������õ���Ϣ
 */
public class DataSourceContextHolder{
	static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); 
	public static void setDbInfo(String dbInfo){
		contextHolder.set(dbInfo);
	}
	public static String getDbInfo(){
		return (String)contextHolder.get();
	}
	public static void clearDbInfo(){
		contextHolder.remove();
	}
	
}
