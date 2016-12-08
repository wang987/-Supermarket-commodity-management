package com.entity;
<<<<<<< HEAD
/**
 * @author 吴森
 * @Time 2016-11-27 14:49:01
 * @describe 这是商品信息的类
 */
=======

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
>>>>>>> 249f3f2ee49b6599771e812720337603489c2d72
public class Product {
	private Integer productId;
	private String name;
	private Integer count;
	private Float bid;
	private Float price;
	private Float profit;
	
	@Id
	@Column(name = "productid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(name = "bid")
	public Float getBid() {
		return bid;
	}
	public void setBid(Float bid) {
		this.bid = bid;
	}
	@Column(name = "price")
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Column(name = "profit")
	public Float getProfit() {
		return profit;
	}
	public void setProfit(Float profit) {
		this.profit = profit;
	}
	

}
