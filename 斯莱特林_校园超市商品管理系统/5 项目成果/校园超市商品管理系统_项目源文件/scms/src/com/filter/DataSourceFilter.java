package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aop.DataSourceContextHolder;
/**
 * @author ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe ����һ���������������Ǹ��̸߳�ֵ
 */
public class DataSourceFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @decribe ִ�й���������������һ����Դ
	 */	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {  
		
		
		HttpServletRequest request=(HttpServletRequest)arg0; 
        HttpServletResponse response  =(HttpServletResponse) arg1;      
        HttpSession session = request.getSession(true);       
       
        HttpServletRequest httpRequest = (HttpServletRequest) request;
		Object dataSourceType=httpRequest.getSession().getAttribute("dbInfo");//���Attribute
		if(dataSourceType!=null){
			DataSourceContextHolder.setDbInfo(dataSourceType.toString());
		}else{
			DataSourceContextHolder.setDbInfo("");
		}
        
        String user_role = DataSourceContextHolder.getDbInfo();
        String url=request.getRequestURI();     
        if(user_role == null || "".equals(user_role)) {        
             //�жϻ�ȡ��·����Ϊ���Ҳ��Ƿ��ʵ�¼ҳ���ִ�е�¼����ʱ��ת     
             if(url!=null && !url.equals("") && ( url.indexOf("user-login")<0 && url.indexOf("userlogin")<0&&url.indexOf("CheckCodeServlet")<0&&url.indexOf("css")<0&&url.indexOf("lib")<0&&url.indexOf("admin")<0&&url.indexOf("user")<0 )) {     
                 response.sendRedirect(request.getContextPath() + "/user-login.jsp");     
                 return ;     
             }                
         }     
         arg2.doFilter(arg0, arg1);     
         return;     
 }  
	 public void init(FilterConfig arg0) throws ServletException {  
	 }  

}