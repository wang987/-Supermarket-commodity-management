package com.sltl.productimex.controller;
/**
 * @author  ��ɭ
 * @Time 2016-12-3 14:49:01
 * @describe ����������
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
		if(request.getParameter("nowpage")!=null){
			nowpage=Integer.parseInt(request.getParameter("nowpage"));
		}else{
			nowpage=1;
		}
		
		if(session.getAttribute("end")!=null){
			end=Integer.parseInt((session.getAttribute("end")).toString());
		}else{
			end=this.productimexServiceImpl.a();
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
