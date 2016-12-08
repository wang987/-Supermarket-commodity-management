package com.sltl.rulefindall.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ProductImEx;
import com.sltl.rulefindall.dao.RuleFindAllDao;
/**
 * @author  ��ɭ
 * @Time 2016-11-28 23:30
 * @describe ���ɲ�ѯ���е�service��
 */
@Service
public class RuleFindAllService {
	@Resource
	RuleFindAllDao ruleFindAllDao; 
	public List<ProductImEx> findAllBySales(int nowPage) throws SQLException {
		// TODO Auto-generated method stub
		return this.ruleFindAllDao.daooperate(nowPage,"");
	}

	public List<ProductImEx> findAllByProfits(int nowPage) throws SQLException {
		// TODO Auto-generated method stub
		return this.ruleFindAllDao.daooperate(nowPage);
	}
	
	public int findEndPage() throws SQLException{
		return this.ruleFindAllDao.daooperate();
	}

}
