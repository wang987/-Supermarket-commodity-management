package com.sltl.imexgoods.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sltl.imexgoods.service.ImExGoodsServiceImpl;

/**
 * @author  吴森
 * @Time 2016-12-3 14:49:01
 * @describe 进出货操作
 */
@Controller
@RequestMapping("imexgoods")
public class ImExGoodsController {

	@Resource
	ImExGoodsServiceImpl imExGoodsServiceImpl;
	
	@RequestMapping("goods")
	public String Revision(@RequestParam("tag") String tag,@RequestParam("productid") int productid,@RequestParam("count") int count, HttpSession session) throws SQLException, ClassNotFoundException{
		//先查，再改；
		
		if(tag.equals("buy")){
			int precount=this.imExGoodsServiceImpl.getProduct(productid).getCount();
			this.imExGoodsServiceImpl.addCount(productid, count+precount);
		}else if(tag.equals("sell")){
			Date now =new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
			String hehe = dateFormat.format( now ); 
			int precount=this.imExGoodsServiceImpl.getProduct(productid).getCount();
			this.imExGoodsServiceImpl.saleCount(Timestamp.valueOf(hehe+" 00:00:00"), productid,count, precount);
		}else{
			return "cuowu";
		}
		return "forward:/productimex/product";
		
	}
}
