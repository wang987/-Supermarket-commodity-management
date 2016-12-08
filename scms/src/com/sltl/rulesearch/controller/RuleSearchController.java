package com.sltl.rulesearch.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ProductImEx;
import com.sltl.rulesearch.service.RuleSearchServiceImpl;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-28 20:30
 * @describe ¹æÂÉËÑË÷ËÑË÷Controller²ã
 */
@Controller
@RequestMapping("rulesearch")
public class RuleSearchController {
	@Resource
	RuleSearchServiceImpl ruleSearchServiceImpl;
	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") String key, HttpSession session) throws SQLException, ClassNotFoundException{
		System.out.println(key);
		List<ProductImEx> list=this.ruleSearchServiceImpl.search(key);
		model.addAttribute("userarr",list);
		session.setAttribute("nowpage",1);
		session.setAttribute("end",1);
		return "shangpin-rule";
	}
	
}
