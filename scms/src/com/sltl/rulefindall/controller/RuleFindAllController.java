package com.sltl.rulefindall.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ProductImEx;
import com.sltl.rulefindall.service.RuleFindAllService;
import com.sltl.rulesearch.service.RuleSearchServiceImpl;

/**
 * @author  ��ɭ
 * @Time 2016-11-28 23:30
 * @describe ���ɲ�ѯ���е���Ϣservice��
 */
@Controller
@RequestMapping("rulefindall")
public class RuleFindAllController {

	
		@Resource
		RuleFindAllService ruleFindAllService;
		@RequestMapping("findall")
		//����Ҫ��ȡ������ť�͵�ǰҳʲô�ģ�
		public String findAll(Model model, HttpServletRequest request,@RequestParam("btn") String btn, HttpSession session) throws SQLException, ClassNotFoundException{
			List<ProductImEx> list;
			
			int end;
			int nowpage=0;
			if(request.getParameter("nowpage")!=null){
				nowpage=Integer.parseInt(request.getParameter("nowpage"));
			}else{
				nowpage=1;
			}
			
			if(session.getAttribute("end")!=null){
				end=Integer.parseInt((session.getAttribute("end")).toString());
			}else{
				end=this.ruleFindAllService.findEndPage();
			}
			if(nowpage<1||nowpage>end){
				return "shangpin-rule";
			}
			//�жϰ�ʲô����
			if(btn.equals("����������")){
				list=this.ruleFindAllService.findAllBySales(nowpage);
				session.setAttribute("first",list.get(0).getSolds());
				session.setAttribute("second",list.get(1).getSolds());
				session.setAttribute("third",list.get(2).getSolds());
				float sum=0;
				for(int i=0;i<list.size();i++){
					sum=sum+list.get(i).getSolds();
				}
				session.setAttribute("sum",sum);
			}else if(btn.equals("����������")){
				list=this.ruleFindAllService.findAllByProfits(nowpage);
				session.setAttribute("first",list.get(0).getProfits());
				session.setAttribute("second",list.get(1).getProfits());
				session.setAttribute("third",list.get(2).getProfits());
				float sum=0;
				for(int i=0;i<list.size();i++){
					sum=sum+list.get(i).getProfits();
				}
				session.setAttribute("sum",sum);
			}else{
				list=this.ruleFindAllService.findAllByProfits(nowpage);
			}
			
			
			model.addAttribute("userarr",list);
			session.setAttribute("nowpage",nowpage);
			session.setAttribute("ruleend",end);
			return "shangpin-rule";
		}
		
	}