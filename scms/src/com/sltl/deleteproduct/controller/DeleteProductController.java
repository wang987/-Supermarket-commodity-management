package com.sltl.deleteproduct.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sltl.deleteproduct.service.DeleteProductServiceImpl;
/**
 * 
 * @author утру╣о
 *
 */
@Controller
@RequestMapping("delete")
public class DeleteProductController {
  @Resource
  private DeleteProductServiceImpl deleteProductServiceImpl;
  @RequestMapping(value="delete")
  public String delete(@RequestParam("productid") int productid,
  HttpServletRequest request) throws SQLException{
	  this.deleteProductServiceImpl.dropProduct(productid);
	  return "shangpin-design";
  }
}
