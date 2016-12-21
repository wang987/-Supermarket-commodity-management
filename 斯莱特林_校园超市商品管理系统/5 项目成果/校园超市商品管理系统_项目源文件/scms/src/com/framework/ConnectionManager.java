package com.framework;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.aop.DataSourceContextHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author 吴森
 * @Time 2016-11-26 14:49:01
 * @describe dbcp连接池
 */
public final class ConnectionManager {  
    //使用单利模式创建数据库连接池  
    private static ConnectionManager instance;  
    private static ComboPooledDataSource dataSource;  
  
    @Resource
	private SessionFactory sessionFactory;
    
    private ConnectionManager() throws SQLException, PropertyVetoException {  
       
    	String dbInfo=DataSourceContextHolder.getDbInfo();
    	
    	System.out.println("信息"+dbInfo);
		String infos[]=dbInfo.split(",");
		String str="jdbc:mysql://localhost:3306/"+infos[0]+"?useUnicode=true&characterEncoding=UTF-8";
    	
    	dataSource = new ComboPooledDataSource();  
        dataSource.setUser("root");     //用户名  
        dataSource.setPassword("123456"); //密码  
        dataSource.setJdbcUrl(str);//数据库地址  
        dataSource.setDriverClass("com.mysql.jdbc.Driver");  
        dataSource.setInitialPoolSize(5); //初始化连接数  
        dataSource.setMinPoolSize(1);//最小连接数  
        dataSource.setMaxPoolSize(10);//最大连接数  
        dataSource.setMaxStatements(50);//最长等待时间  
        dataSource.setMaxIdleTime(60);//最大空闲时间，单位毫秒  
    }  
  
    public static final ConnectionManager getInstance() {  
        if (instance == null) {  
            try {  
                instance = new ConnectionManager();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return instance;  
    }  
  
    public synchronized final Connection getConnection() {  
        Connection conn = null;  
        try {  
            conn = dataSource.getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }  
}  
