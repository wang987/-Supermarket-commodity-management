package com.sltl.productimex.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.ProductImEx;
import com.framework.BaseDao;
/**
 * @author  吴森
 * @Time 2016-12-3 14:49:01
 * @describe 进出货操作
 */
@Repository
public class ProductImExDaoImpl extends BaseDao {

	public List<ProductImEx> c(int pageSize, int nowPage) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select p.productid productid, name,count,bid,price,profit,sum(salecount) salecount,sum(salecount)*profit profits from product p,sales s,productsales ps where s.salesid=ps.salesid and p.productid=ps.productid  group by name ORDER BY profits DESC limit "+(nowPage-1)*4+",4;";

		return super.getAllImExByKey(sql);
	}

	public int am() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select p.productid productid, name,count,bid,price,profit,sum(salecount) salecount,sum(salecount)*profit profits from product p,sales s,productsales ps where s.salesid=ps.salesid and p.productid=ps.productid  group by name ";
		return super.finEndPage(sql);
	}

}
