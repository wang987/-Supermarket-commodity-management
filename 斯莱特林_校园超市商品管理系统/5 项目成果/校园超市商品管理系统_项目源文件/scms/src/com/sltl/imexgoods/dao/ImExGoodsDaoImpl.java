package com.sltl.imexgoods.dao;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.framework.BaseDao;
/**
 * @author  ��ɭ
 * @Time 2016-12-3 14:49:01
 * @describe ����������
 */
@Repository
public class ImExGoodsDaoImpl extends BaseDao{

	public Product daooperate(int productid) throws SQLException{
		String sql="select * from product where productid="+productid+"";
		return super.getOneProduct(sql);
		
	}

	public String daooperate(int productid, int count) throws SQLException {
		// ����
		String sql="UPDATE product SET count = '"+count+"' WHERE productid = '"+productid+"'"; 
		return super.alter(sql);
	}

	public String daooperate(Date date, int productid, int count,int precount) throws SQLException {
		//�ȸ���
		String sql="UPDATE product SET count = '"+(precount-count)+"' WHERE productid = '"+productid+"'"; 
		super.alter(sql);
		//���ҵ�ǰid
		sql="select * from sales";
		int saleid=super.getNextId(sql);
		//�ٲ������ı�
		sql="insert into sales(salesid,date,salecount) values("+saleid+",'"+date+"',"+count+")";
		super.alter(sql);
		//�ٲ������ӱ�
		
		sql="insert into productsales(productid,salesid) values("+productid+","+saleid+")";
		super.alter(sql);
		return null;
	}
}
