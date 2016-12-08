package com.sltl.productimex.controller;
/**
 * @author  吴森
 * @Time 2016-12-3 14:49:01
 * @describe 进出货操作
 */
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.entity.ProductImEx;
import com.sltl.productimex.service.ProductImExServiceImpl;
@Controller
@RequestMapping("productimex")
public class ProductImExController {
	private int pageSize=3;
	@Resource
	ProductImExServiceImpl productimexServiceImpl;
	@RequestMapping("product")
	public String quer(Model model,HttpServletRequest request,HttpSession session) throws SQLException{
		
		int end = 0;
		int nowpage=0;
		
		
		if(session.getAttribute("imexend")!=null){
			end=Integer.parseInt((session.getAttribute("imexend")).toString());
		}else{
			end=this.productimexServiceImpl.a();
		}
		if(request.getParameter("nowpage")!=null&&Integer.parseInt(request.getParameter("nowpage"))>0&&Integer.parseInt(request.getParameter("nowpage"))<=end){
			nowpage=Integer.parseInt(request.getParameter("nowpage"));
		}else{
			nowpage=1;
		}
		if(nowpage<1||nowpage>end){
			return"shangpin-imexport";
		}
		
		List<ProductImEx> list=this.productimexServiceImpl.b(pageSize,nowpage);
		
		model.addAttribute("userarr",list);
		
		session.setAttribute("nowpage",nowpage);
		session.setAttribute("imexend",end);
		return"shangpin-imexport";
		
	}
		
}
