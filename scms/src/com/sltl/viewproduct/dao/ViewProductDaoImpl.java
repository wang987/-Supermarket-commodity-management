package com.sltl.viewproduct.dao;

import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.framework.BaseDao;
import com.framework.Page;
@Repository
public class ViewProductDaoImpl {

	public class ProductDaoImpl extends BaseDao<Product, Integer> {

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


		public Page<Product> findProduct(int pageNum, int pageSize,Object[] params){
			String hql;
			if(params!=null && params.length>0){
				hql="from Product p where p.name like ?";
				params[0]="%"+params[0]+"%";		
			}
			else{
				hql="from Product";
			}
			try {
				Page<Product> page=new Page<Product>();
				page.setCurrentPageNum(pageNum);
				page.setPageSize(pageSize);
				page=this.findByPage(pageNum, pageSize, hql, params);
				return page;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		private Page<Product> findByPage(int pageNum, int pageSize, String hql, Object[] params) {
			// TODO Auto-generated method stub
			return null;
		}
		public Product getProduct(int productId){
			try {
				Product p=this.get(productId);
				return p;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		private Product get(int productId) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public Page<Product> findProduct(int pageNum, int pageSize, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}		
}
