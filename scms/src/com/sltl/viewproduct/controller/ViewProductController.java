package com.sltl.viewproduct.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.framework.Page;
import com.entity.Product;
import com.sltl.viewproduct.service.ViewProductServiceImpl;

@Controller
@RequestMapping("product")
public class ViewProductController {

	@Resource
	private ViewProductServiceImpl viewproductServiceImpl;
	

	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Product> page;
		if(searchParam==null || "".equals(searchParam)){
			page=this.viewproductServiceImpl.listProduct(pageNum, 5, null);	
		}else{
			page=this.viewproductServiceImpl.listProduct(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "product/list";
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
        }
}