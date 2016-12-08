package com.sltl.addproduct.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
<<<<<<< HEAD

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
=======

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.sltl.addproduct.service.AddProductServiceImpl;

>>>>>>> 249f3f2ee49b6599771e812720337603489c2d72
@Controller
@RequestMapping("shangpin-insert")
public class AddProductController {
	@Resource
	private AddProductServiceImpl addProductServiceImpl;
<<<<<<< HEAD
	@RequestMapping("add")//,method = RequestMethod.POST
=======
	@RequestMapping(value = "add",method = RequestMethod.POST)
>>>>>>> 249f3f2ee49b6599771e812720337603489c2d72
	public String add(@RequestParam(name = "name")String name,
			@RequestParam(name="count")Integer count,
			@RequestParam(name="bid")Float bid,
			@RequestParam(name="price")Float price) throws SQLException{
<<<<<<< HEAD
=======
		System.out.println("商品名control："+name);
>>>>>>> 249f3f2ee49b6599771e812720337603489c2d72
		this.addProductServiceImpl.addProduct(name,count,bid,price);
		return "shangpin-insert";
	}
}