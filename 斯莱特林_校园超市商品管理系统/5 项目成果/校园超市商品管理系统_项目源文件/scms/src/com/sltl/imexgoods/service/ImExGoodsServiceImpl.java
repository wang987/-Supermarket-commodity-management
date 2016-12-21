package com.sltl.imexgoods.service;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.sltl.imexgoods.dao.ImExGoodsDaoImpl;
/**
 * @author  吴森
 * @Time 2016-12-3 14:49:01
 * @describe 进出货操作
 */
@Service
public class ImExGoodsServiceImpl {

	@Resource
	ImExGoodsDaoImpl imExGoodsDaoImpl;
	
	public Product getProduct(int productid) throws SQLException{
		return this.imExGoodsDaoImpl.daooperate(productid);
	}
	
	public String addCount(int productid,int count) throws SQLException{
		return this.imExGoodsDaoImpl.daooperate(productid,count);
		
	}
	
	public String saleCount(Date data,int productid,int count,int precount) throws SQLException{
		return this.imExGoodsDaoImpl.daooperate(data,productid,count,precount);
		
	}
	
}
