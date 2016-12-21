package com.sltl.rulesearch.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ProductImEx;
import com.sltl.rulesearch.service.RuleSearchServiceImpl;

/**
 * @author  吴森
 * @Time 2016-11-28 20:30
 * @describe 规律搜索搜索Controller层
 */
@Controller
@RequestMapping("rulesearch")
public class RuleSearchController {
	@Resource
	RuleSearchServiceImpl ruleSearchServiceImpl;
	@RequestMapping("search")
	public String search(HttpServletRequest request,Model model,@RequestParam("keywords") String key, HttpSession session) throws SQLException, ClassNotFoundException{
		Date now =new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String nowdate="'"+dateFormat.format( now )+"'"; 
		
		Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -1);
	    String predate="'"+  new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+"'";
	    
		//赋值给日期；
		if(request.getParameter("predate")!=null){
			predate="'"+request.getParameter("predate")+"'";
		}
		if(request.getParameter("nowdate")!=null){
			predate="'"+request.getParameter("nowdate")+"'";
		}
		
		
		List<ProductImEx> list=this.ruleSearchServiceImpl.search(predate,nowdate,key);
		model.addAttribute("userarr",list);
		session.setAttribute("nowpage",1);
		session.setAttribute("end",1);
		return "shangpin-rule";
	}
	
}
