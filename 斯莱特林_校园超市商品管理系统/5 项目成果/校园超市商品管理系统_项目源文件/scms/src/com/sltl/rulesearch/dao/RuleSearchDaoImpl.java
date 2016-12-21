package com.sltl.rulesearch.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.ProductImEx;
import com.framework.BaseDao;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-28 20:30
 * @describe ¹æÂÉËÑË÷ËÑË÷service²ã
 */
@Repository
public class RuleSearchDaoImpl extends BaseDao{
	public List<ProductImEx> daooperate(String predate, String nowdate,String key) throws SQLException {
		String sql="select  p.productid productid, (concat(name,concat('--->',date)))  as name,count,bid,price,profit, salecount from product p,sales s,productsales ps where date < "+nowdate+" and date > "+predate+"  and s.salesid=ps.salesid and p.productid=ps.productid and p.name like'%"+key+"%' ORDER BY date DESC";
		return super.getAllImExByKey(sql);
	}
}
