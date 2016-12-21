package com.sltl.addproduct.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.sltl.addproduct.service.AddProductServiceImpl;
/**
 * @author  王亚超
 * @Time 2016-11-27 13:30
 * @describe 添加商品controller
 */
@Controller
@RequestMapping("shangpin-insert")
public class AddProductController {
	@Resource
	private AddProductServiceImpl addProductServiceImpl;
	@RequestMapping("add")//,method = RequestMethod.POST
	public String add(@RequestParam(name = "name")String name,
			@RequestParam(name="count")Integer count,
			@RequestParam(name="bid")Float bid,
			@RequestParam(name="price")Float price) throws SQLException{
		this.addProductServiceImpl.addProduct(name,count,bid,price);
		return "shangpin-insert";
	}
}