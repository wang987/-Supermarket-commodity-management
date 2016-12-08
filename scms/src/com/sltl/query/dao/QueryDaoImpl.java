package com.sltl.query.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Adminlogin;
import com.entity.Product;
import com.framework.BaseDao;
/**
 * 
 * @author 康让
 *@miaoshu 查询所有商品dao
 */

@Repository
public class QueryDaoImpl extends BaseDao {
	public List<Product> daooperate(int pageSize,int nowPage) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		String sql="select * from product limit "+(nowPage-1)*pageSize+","+pageSize;
		return super.findAllProduct(sql);
	}

	public int as() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from product";
		return super.finEndPage(sql);
		
	}
}
