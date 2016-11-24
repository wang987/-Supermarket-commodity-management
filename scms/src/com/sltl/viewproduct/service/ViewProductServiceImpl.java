package com.sltl.viewproduct.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Product;
import com.framework.Page;
import com.sltl.viewproduct.dao.ViewProductDaoImpl;

@Service
@Transactional(readOnly=false)
public class  ViewProductServiceImpl {
	
	@Resource
	private ViewProductDaoImpl viewproductDaoImpl;
	@Transactional(readOnly=true)
	public Page<Product> listProduct(int pageNum,int pageSize,Object[] params){
		return this.viewproductDaoImpl.findProduct(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public Product getProduct(int productId){
		return this.viewproductDaoImpl.getProduct(productId);
	}
	

}
