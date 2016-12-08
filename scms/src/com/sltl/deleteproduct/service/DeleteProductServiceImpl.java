package com.sltl.deleteproduct.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sltl.deleteproduct.dao.DeleteProductDaoImpl;
/**
 * 
 * @author утру╣о
 *
 */
@Service
@Transactional(readOnly = false)
public class DeleteProductServiceImpl {

	@Resource
	DeleteProductDaoImpl deleteProductDaoImpl;

    public void dropProduct(int productid)throws SQLException{
    	this.deleteProductDaoImpl.deleteProduct(productid);
    }




}
