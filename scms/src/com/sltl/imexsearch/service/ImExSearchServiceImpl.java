package com.sltl.imexsearch.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.ProductImEx;
import com.sltl.imexsearch.dao.ImExSearchDaoImpl;

/**
 * @author  ��ɭ
 * @Time 2016-11-27 13:30
 * @describe ��������������service��
 */
@Service
public class ImExSearchServiceImpl {
	@Resource
	ImExSearchDaoImpl imExSearchDaoImpl;
	public List<ProductImEx> search(String key) throws SQLException{
		return this.imExSearchDaoImpl.daooperate(key);
	}
}
