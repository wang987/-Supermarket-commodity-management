package com.sltl.imexsearch.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.ProductImEx;
import com.framework.BaseDao;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-27 13:30
 * @describe ½ø³ö»õËÑË÷Dao²ã
 */
@Repository
public class ImExSearchDaoImpl  extends BaseDao{
	public List<ProductImEx> daooperate(String key) throws SQLException {
		String sql="select p.productid productid, name,count,bid,price,profit,sum(salecount) salecount from product p,sales s,productsales ps where s.salesid=ps.salesid and p.productid=ps.productid and p.name like'%"+key+"%' group by name";
		return super.getAllImExByKey(sql);
	}
}
