package com.sltl.reviseproduct.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sltl.reviseproduct.dao.ReviseProductDaoImpl;
import com.sltl.reviseproduct.service.ReviseProductServiceImpl;
import com.entity.Product;


@Service
@Transactional(readOnly=false)
public class ReviseProductServiceImpl {
	@Resource
	private ReviseProductDaoImpl reviseproductDaoImpl;
	
	public void editProduct(Product p){
		Product pdb=this.reviseproductDaoImpl.getProduct(p.getProductId());
		pdb.setName(p.getName());
		pdb.setPrice(p.getPrice());
		this.reviseproductDaoImpl.updateProduct(pdb);
	}
	
	
	
	
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
	

}
