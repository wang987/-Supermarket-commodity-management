package com.sltl.seesearch.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.framework.BaseDao;
/**
 * @author  ��ɭ
 * @Time 2016-11-27 13:30
 * @describe ����Dao��
 */
@Repository
public class SeeSearchDaoImpl extends BaseDao{

	public List<Product> daooperate(String key) throws SQLException {
		String sql="select * from product where name like'%"+key+"%'";
		
		return super.getAllSeeByKey(sql);
	}

}
