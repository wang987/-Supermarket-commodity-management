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
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 这是一个过滤器，看的是给线程赋值
 */
public class DataSourceFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @decribe 执行过滤器，并传给下一个资源
	 */	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Object dataSourceType=httpRequest.getSession().getAttribute("dbInfo");//获得Attribute
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