package com.sltl.query.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Adminlogin;
import com.entity.Product;
import com.sltl.query.dao.QueryDaoImpl;
import com.sltl.query.service.QueryServiceImpl;
/**
 * 
 * @author 康让
 *@miaoshu 查询所有商品controller
 */


@Controller
@RequestMapping("queryproduct")
public class QueryController {
	private int pageSize=4;//页数
	@Resource
	QueryServiceImpl queryServiceImpl ;
	@RequestMapping("query")
	public String query(Model model,HttpServletRequest request,HttpSession session) throws ClassNotFoundException, SQLException{
		
		int end = 0;
		int nowpage=0;
		
		
		if(session.getAttribute("queryend")!=null){
			end=Integer.parseInt((session.getAttribute("queryend")).toString());
		}else{
			end=this.queryServiceImpl.findAllByProfits();
		}
		
		if(request.getParameter("nowpage")!=null&&Integer.parseInt(request.getParameter("nowpage"))>0&&Integer.parseInt(request.getParameter("nowpage"))<=end){
			nowpage=Integer.parseInt(request.getParameter("nowpage"));
		}else{
			nowpage=1;
		}
		if(nowpage<1||nowpage>end){
			return "shangpin-rule";
		}
		
		List<Product> list=this.queryServiceImpl.findAll(pageSize,nowpage);
		
		model.addAttribute("userarr",list);
		
		session.setAttribute("nowpage",nowpage);
		session.setAttribute("queryend",end);
		return"shangpin-design";
		
	}

	}