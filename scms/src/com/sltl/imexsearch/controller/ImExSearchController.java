package com.sltl.imexsearch.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.entity.ProductImEx;
import com.sltl.imexsearch.service.ImExSearchServiceImpl;

/**
 * @author  ÎâÉ­
 * @Time 2016-11-27 13:30
 * @describe ½ø³ö»õËÑË÷ËÑË÷service²ã
 */
@Controller
@RequestMapping("imexsearch")
public class ImExSearchController {
	@Resource
	ImExSearchServiceImpl imExSearchServiceImpl;
	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") String key, HttpSession session) throws SQLException, ClassNotFoundException{
		List<ProductImEx> list=this.imExSearchServiceImpl.search(key);
		model.addAttribute("userarr",list);
		session.setAttribute("nowpage",1);
		session.setAttribute("end",1);
		return "shangpin-imexport";
	}
}
