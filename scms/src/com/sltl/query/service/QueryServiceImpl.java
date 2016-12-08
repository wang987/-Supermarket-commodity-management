package com.sltl.query.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.entity.Product;
import com.sltl.query.dao.QueryDaoImpl;
import com.sltl.userlogin.dao.UserLoginDaoImpl;
/**
 * 
 * @author 康让
 *@miaoshu 查询所有商品service
 */


@Service
public class QueryServiceImpl {
	@Resource
	QueryDaoImpl queryDaoImpl;
	
	public List<Product> findAll(int pageSize,int nowPage) throws ClassNotFoundException, SQLException{
		return this.queryDaoImpl.daooperate(pageSize,nowPage);
		}

	public int findAllByProfits() throws SQLException {
		String sql="select * from product";
		return this.queryDaoImpl.as();
		// TODO Auto-generated method stub
	}
		
}
