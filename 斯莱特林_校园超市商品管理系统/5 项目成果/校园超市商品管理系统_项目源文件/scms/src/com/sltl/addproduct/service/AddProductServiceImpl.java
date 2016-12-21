package com.sltl.addproduct.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Product;
import com.sltl.addproduct.dao.AddProductDaoImpl;

/**
 * @author  ���ǳ�
 * @Time 2016-11-27 13:30
 * @describe �����Ʒservice
 */
@Service
@Transactional(readOnly = false)
public class AddProductServiceImpl {
	@Resource
	private AddProductDaoImpl addProductDaoImpl;
	
	public void addProduct(String name,Integer count,Float bid,Float price) throws SQLException{
		this.addProductDaoImpl.savaProduct(name,count,bid,price);
	}
}
