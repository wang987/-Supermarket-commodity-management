package com.sltl.deleteproduct.dao;

import org.springframework.stereotype.Repository;

import com.framework.BaseDao;
/**
 * 
 * @author утру╣о
 *
 */
@Repository
public class DeleteProductDaoImpl extends BaseDao{
	public void deleteProduct(int productid){
		try {
			String sql="delete from product where productid='"+productid+"'";
			super.delete(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
