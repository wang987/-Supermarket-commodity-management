package com.entity;

import java.util.Date;

/**
 * @author 吴森
 * @Time 2016-11-27 14:49:01
 * @describe 这是进出货的商品类
 * 
 */
public class ProductImEx {
	Integer id;//id
	String name;//名字
	int count;//库存
	float bid;//进价
	float price;//售价
	int solds;//已售
	float profit;//利润
	Date date;//日期
	float profits;//总利润
	
	
	public float getProfits() {
		return profits;
	}
	public void setProfits(float profits) {
		this.profits = profits;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSolds() {
		return solds;
	}
	public void setSolds(int solds) {
		this.solds = solds;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	
}
