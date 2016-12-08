package com.sltl.rulesearch.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ProductImEx;
import com.sltl.rulesearch.dao.RuleSearchDaoImpl;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-28 20:30
 * @describe ¹æÂÉËÑË÷ËÑË÷service²ã
 */
@Service
public class RuleSearchServiceImpl {
	@Resource
	RuleSearchDaoImpl ruleSearchDaoImpl;
	public List<ProductImEx> search(String key) throws SQLException{
		return this.ruleSearchDaoImpl.daooperate(key);
	}
}
