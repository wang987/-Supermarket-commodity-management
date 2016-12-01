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

@Controller
@RequestMapping("shangpin-insert")
public class AddProductController {
	@Resource
	private AddProductServiceImpl addProductServiceImpl;
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(@RequestParam(name = "name")String name,
			@RequestParam(name="count")Integer count,
			@RequestParam(name="bid")Float bid,
			@RequestParam(name="price")Float price) throws SQLException{
		System.out.println("ÉÌÆ·Ãûcontrol£º"+name);
		this.addProductServiceImpl.addProduct(name,count,bid,price);
		return "shangpin-insert";
	}
}