package com.sltl.rulesearch.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ProductImEx;
import com.sltl.rulesearch.dao.RuleSearchDaoImpl;

/**
 * @author  ��ɭ
 * @Time 2016-11-28 20:30
 * @describe ������������service��
 */
@Service
public class RuleSearchServiceImpl {
	@Resource
	RuleSearchDaoImpl ruleSearchDaoImpl;
	public List<ProductImEx> search(String key) throws SQLException{
		return this.ruleSearchDaoImpl.daooperate(key);
	}
}
