package com.sltl.seesearch.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Adminlogin;
import com.entity.Product;
import com.sltl.seesearch.dao.SeeSearchDaoImpl;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-27 13:30
 * @describe ËÑË÷service²ã
 */
@Service
public class SeeSearchServiceImpl {
	@Resource
	SeeSearchDaoImpl seeSearchDaoImpl;
	public List<Product> search(String key) throws SQLException{
		return this.seeSearchDaoImpl.daooperate(key);
	}
}
