package com.sltl.productimex.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.ProductImEx;
import com.sltl.productimex.dao.ProductImExDaoImpl;
/**
 * @author  吴森
 * @Time 2016-12-3 14:49:01
 * @describe 进出货操作
 */
@Service
public class ProductImExServiceImpl {
	@Resource
	ProductImExDaoImpl productimexDaoImpl;

	public List<ProductImEx> b(int pageSize, int nowPage) throws SQLException {
		// TODO Auto-generated method stub
		return this.productimexDaoImpl.c(pageSize,nowPage);
	}



	public int a() throws SQLException {
		// TODO Auto-generated method stub
		return this.productimexDaoImpl.am();
	}

}
