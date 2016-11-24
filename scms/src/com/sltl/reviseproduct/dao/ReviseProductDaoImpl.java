package com.sltl.reviseproduct.dao;

import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public class ReviseProductDaoImpl {
	public void saveProduct(Product p){
		try {
			this.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void save(Product p) {
		// TODO Auto-generated method stub
		
	}
	public void updateProduct(Product p){
		try {
			this.update(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void update(Product p) {
		// TODO Auto-generated method stub
		
	}
	public Product getProduct(Object productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
