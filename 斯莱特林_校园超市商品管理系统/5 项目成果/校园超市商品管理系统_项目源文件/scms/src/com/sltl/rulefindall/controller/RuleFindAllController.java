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
			System.out.println("������");
			System.out.println("�������ģ�"+request.getParameter("predate"));
			System.out.println("�������ģ�"+request.getParameter("nowdate"));
			List<ProductImEx> list;
			
			int end;
			int nowpage=0;
			
			Date now =new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
			String nowdate="'"+dateFormat.format( now )+"'"; 
			
			Calendar c = Calendar.getInstance();
		    c.add(Calendar.MONTH, -1);
		    String predate="'"+  new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+"'";
		    
		    System.out.println("pre:"+predate);
		    System.out.println("now:"+nowdate);
			//��ֵ�����ڣ�
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
			//�жϰ�ʲô����
			if(btn.equals("����������")){
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
				
			}else if(btn.equals("����������")){
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