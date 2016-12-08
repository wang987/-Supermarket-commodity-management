package com.sltl.addproduct.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.framework.BaseDao;
/**
 * @author  王亚超
 * @Time 2016-11-27 13:30
 * @describe 添加商品dao
 */
@Repository
public class AddProductDaoImpl extends BaseDao {	
	public String savaProduct(String name,Integer count,Float bid,Float price) throws SQLException{
		String sql="insert into product(name,count,bid,price,profit) values('"+name+"',"+count+","+bid+","+price+","+(price-bid)+")";
		return super.addProduct(sql);
	}
}
