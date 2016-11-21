package scms.ssms.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 类，线程实现管理配置的信息
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
