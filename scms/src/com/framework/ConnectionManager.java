package com.framework;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.aop.DataSourceContextHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author ��ɭ
 * @Time 2016-11-26 14:49:01
 * @describe dbcp���ӳ�
 */
public final class ConnectionManager {  
    //ʹ�õ���ģʽ�������ݿ����ӳ�  
    private static ConnectionManager instance;  
    private static ComboPooledDataSource dataSource;  
  
    @Resource
	private SessionFactory sessionFactory;
    
    private ConnectionManager() throws SQLException, PropertyVetoException {  
       
    	String dbInfo=DataSourceContextHolder.getDbInfo();
    	
    	System.out.println("��Ϣ"+dbInfo);
		String infos[]=dbInfo.split(",");
		String str="jdbc:mysql://localhost:3306/"+infos[0]+"?useUnicode=true&characterEncoding=UTF-8";
    	
    	dataSource = new ComboPooledDataSource();  
        dataSource.setUser("root");     //�û���  
        dataSource.setPassword("123456"); //����  
        dataSource.setJdbcUrl(str);//���ݿ��ַ  
        dataSource.setDriverClass("com.mysql.jdbc.Driver");  
        dataSource.setInitialPoolSize(5); //��ʼ��������  
        dataSource.setMinPoolSize(1);//��С������  
        dataSource.setMaxPoolSize(10);//���������  
        dataSource.setMaxStatements(50);//��ȴ�ʱ��  
        dataSource.setMaxIdleTime(60);//������ʱ�䣬��λ����  
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
