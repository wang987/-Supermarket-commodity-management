package com.sltl.rulefindall.controller;

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
import com.sltl.rulefindall.service.RuleFindAllService;
import com.sltl.rulesearch.service.RuleSearchServiceImpl;

/**
 * @author  吴森
 * @Time 2016-11-28 23:30
 * @describe 规律查询所有的信息service层
 */
@Controller
@RequestMapping("rulefindall")
public class RuleFindAllController {

	
		@Resource
		RuleFindAllService ruleFindAllService;
		@RequestMapping("findall")
		//我需要获取参数按钮和当前页什么的；
		public String findAll(Model model, HttpServletRequest request,@RequestParam("btn") String btn, HttpSession session) throws SQLException, ClassNotFoundException{
			System.out.println("进来了");
			System.out.println("传进来的："+request.getParameter("predate"));
			System.out.println("传进来的："+request.getParameter("nowdate"));
			List<ProductImEx> list;
			
			int end;
			int nowpage=0;
			
			Date now =new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
			String nowdate="'"+dateFormat.format( now )+"'"; 
			
			Calendar c = Calendar.getInstance();
		    c.add(Calendar.MONTH, -1);
		    String predate="'"+  new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+"'";
		    
		    System.out.println("pre:"+predate);
		    System.out.println("now:"+nowdate);
			//赋值给日期；
			if(request.getParameter("predate")!=null){
				predate="'"+request.getParameter("predate")+"'";
			}
			if(request.getParameter("nowdate")!=null){
				nowdate="'"+request.getParameter("nowdate")+"'";
			}
			System.out.println("pre:"+predate);
			System.out.println("now:"+nowdate);
			
			if(session.getAttribute("ruleend")!=null){
				end=Integer.parseInt((session.getAttribute("ruleend")).toString());
			}else{
				end=this.ruleFindAllService.findEndPage();
			}
			if(request.getParameter("nowpage")!=null&&Integer.parseInt(request.getParameter("nowpage"))>0&&Integer.parseInt(request.getParameter("nowpage"))<=end){
				nowpage=Integer.parseInt(request.getParameter("nowpage"));
			}else{
				nowpage=1;
			}
			if(nowpage<1||nowpage>end){
				return "shangpin-rule";
			}
			//判断按什么排序
			if(btn.equals("按销量排序")){
				list=this.ruleFindAllService.findAllBySales(predate,nowdate,nowpage);
				if(list.size()>=3){
					session.setAttribute("first",list.get(0).getSolds());
					session.setAttribute("second",list.get(1).getSolds());
					session.setAttribute("third",list.get(2).getSolds());
					float sum=0;
					for(int i=0;i<list.size();i++){
						sum=sum+list.get(i).getSolds();
					}
					session.setAttribute("sum",sum);
				}
				
			}else if(btn.equals("按利润排序")){
				list=this.ruleFindAllService.findAllByProfits(predate,nowdate,nowpage);
				
				if(list.size()>=3){
					session.setAttribute("first",list.get(0).getProfits());
					session.setAttribute("second",list.get(1).getProfits());
					session.setAttribute("third",list.get(2).getProfits());
					float sum=0;
					for(int i=0;i<list.size();i++){
						sum=sum+list.get(i).getProfits();
					}
					session.setAttribute("sum",sum);
				}
					
			}else{
				list=this.ruleFindAllService.findAllByProfits(predate,nowdate,nowpage);
			}
			
			
			model.addAttribute("userarr",list);
			session.setAttribute("nowpage",nowpage);
			session.setAttribute("ruleend",end);
			return "shangpin-rule";
		}
		
	}