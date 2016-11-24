package com.sltl.reviseproduct.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.sltl.reviseproduct.service.ReviseProductServiceImpl;


@Controller
@RequestMapping("product")
public class ReviseProductController {
	@Resource
	private ReviseProductServiceImpl reviseproductServiceImpl;
	

	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("productId") int productId,
			HttpServletRequest request){
		Product p=this.reviseproductServiceImpl.getProduct(productId);
		request.setAttribute("pro", p);
		request.setAttribute("action", "edit");
		return "product/form";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Product p,HttpServletRequest request){
		this.reviseproductServiceImpl.editProduct(p);
		return "redirect:list";
	}
}
