package com.sltl.rulefindall.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.ProductImEx;
import com.framework.BaseDao;
/**
 * @author  吴森
 * @Time 2016-11-28 23:30
 * @describe 规律查询全部service层
 */
@Repository
public class RuleFindAllDao extends BaseDao
{
	//按照销量排序
	public List<ProductImEx> daooperate(String predate, String nowdate,int nowPage,String string) throws SQLException {
		String sql="select  p.productid productid, name,count,bid,price,profit,sum(salecount) salecount from product p,sales s,productsales ps where date < "+nowdate+" and date > "+predate+"  and s.salesid=ps.salesid and p.productid=ps.productid  group by name ORDER BY salecount DESC limit "+(nowPage-1)*4+",4;";
		System.out.println(sql);
		return super.getAllImExByKey(sql);
		
	}
	//按照利润排序
	public List<ProductImEx> daooperate(String predate, String nowdate,int nowPage) throws SQLException {
		String sql="select  p.productid productid, name,count,bid,price,profit,sum(salecount) salecount,sum(salecount)*profit profits from product p,sales s,productsales ps where s.date < "+nowdate+" and s.date > "+predate+" and s.salesid=ps.salesid and p.productid=ps.productid  group by name ORDER BY profits DESC limit "+(nowPage-1)*4+",4;";
		System.out.println(sql);
		return super.getAllImExByKey(sql);
	}
	public int daooperate() throws SQLException {
		String sql="select  p.productid productid, name,sum(salecount) salecount from product p,sales s,productsales ps where s.salesid=ps.salesid and p.productid=ps.productid  group by name ";
		return super.finEndPage(sql);
	}

}
