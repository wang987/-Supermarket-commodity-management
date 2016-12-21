package com.sltl.seesearch.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.sltl.seesearch.service.SeeSearchServiceImpl;

/**
 * @author  吴森
 * @Time 2016-11-27 10:49:01
 * @describe 查看商品 搜索框
 */
@Controller
@RequestMapping("seesearch")
public class SeeSearchController {
	@Resource
	SeeSearchServiceImpl seeSearchServiceImpl;
	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") String key, HttpSession session) throws SQLException, ClassNotFoundException{
		
		List<Product> list=this.seeSearchServiceImpl.search(key);
		model.addAttribute("userarr",list);
		session.setAttribute("nowpage",1);
		session.setAttribute("end",1);
		return "shangpin-design";
	}
}
