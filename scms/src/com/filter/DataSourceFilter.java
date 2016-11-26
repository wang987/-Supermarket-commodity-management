package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Object dataSourceType=httpRequest.getSession().getAttribute("dbInfo");//���Attribute
		if(dataSourceType!=null){
			DataSourceContextHolder.setDbInfo(dataSourceType.toString());
		}else{
			DataSourceContextHolder.setDbInfo("");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}