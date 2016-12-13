<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『添加商品页』</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
    <script type="text/javascript">
    	var titleFlag = false;
    	var numberFlag = false;
    	var BidFlag = false;
    	var PriceFlag = false;
    	//判断商品名是否为空，如果为空则提示；
    	function checkTitle(){
    		var titleElement = document.getElementById("title");
    		var titleNullTip = document.getElementById("titleNullTip");
    		if(titleElement.value.length == 0){
    			titleNullTip.innerHTML = "<font color = 'red'>请输入商品名！</font>";
    			titleFlag = false;
    		}else{
    			titleFlag = true;
    		}    		
    	}
    	function focusTitle(){
    		var titleNullTip = document.getElementById("titleNullTip");
    		titleNullTip.innerHTML = "";
    		titleFlag = false;
    	}
    	//判断商品数量是否为空或是否符合规范，如果为空或不符合规范则提示；
    	function checkNumber(){
    		var numberElement = document.getElementById("number");
    		var numberNullTip = document.getElementById("numberNullTip");
    		var numberPattern=/(^[1-9]\d*$)/;
    		if(numberElement.value.length == 0){
    			numberNullTip.innerHTML = "<font color = 'red'>请输入数量！</font>";
    			numberFlag = false;
    		}else if(!numberPattern.test(numberElement.value)){
    			numberNullTip.innerHTML = "<font color = 'red'>请输入正整数！</font>";
    			numberFlag = false;
    		}else{
    			numberFlag = true;
    		}
    	}
    	function focusNumber(){
    		var numberNullTip = document.getElementById("numberNullTip");
    		numberNullTip.innerHTML = "";
    		numberFlag = false;
    	}
    	
    	//判断商品进价是否为空或是否符合规范，如果为空或不符合规范则提示；
    	function checkBid(){
    		var bidElement = document.getElementById("bid");
    		var bidNullTip = document.getElementById("bidNullTip");
    		var bidPattern=/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
    		if(bidElement.value.length == 0){
    			bidNullTip.innerHTML = "<font color = 'red'>请输入进价！</font>";
    			bidFlag = false;
    		}else if(!bidPattern.test(bidElement.value)){
    			bidNullTip.innerHTML = "<font color = 'red'>请输入正数！</font>";
    			bidFlag = false;
    		}else{
    			bidFlag = true;
    		}
    	}
    	function focusBid(){
    		var bidNullTip = document.getElementById("bidNullTip");
    		bidNullTip.innerHTML = "";
    		bidFlag = false;
    	}
        
    	//判断商品售价是否为空或是否符合规范，如果为空或不符合规范则提示；
    	function checkPrice(){
    		var priceElement = document.getElementById("price");
    		var priceNullTip = document.getElementById("priceNullTip");
    		var pricePattern=/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
    		if(priceElement.value.length == 0){
    			priceNullTip.innerHTML = "<font color = 'red'>请输入售价！</font>";
    			priceFlag = false;
    		}else if(!pricePattern.test(priceElement.value)){
    			priceNullTip.innerHTML = "<font color = 'red'>请输入正数！</font>";
    			priceFlag = false;
    		}else{
    			priceFlag = true;
    		}
    	}
    	function focusPrice(){
    		var priceNullTip = document.getElementById("priceNullTip");
    		priceNullTip.innerHTML = "";
    		priceFlag = false;
    	}
    	//判断所有输入框的数据是否符合规范，如果符合则允许提交，不符合则不允许提交
    	function submitFlag(){
    		if(titleFlag == true && numberFlag == true && bidFlag == true && priceFlag == true){
        		alert("添加成功！");
        		return true;
        	}else{
        		alert("输入数据有误，请重新输入！");
        		return false;
        	}
    	}   	
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
            </ul>
        </div>
          <p>你好：${user}</p>       
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
            
                <li>
                    
                    <ul class="sub-menu">
                        <li><a href="${ctx}/shangpin-insert.jsp"><i class="icon-font">&#xe008;</i>添加商品</a></li>
                        <li><a href="${ctx}/queryproduct/query"><i class="icon-font">&#xe005;</i>查看商品</a></li>
						<li><a href="${ctx}/rulefindall/findall?btn=0"><i class="icon-font">&#xe006;</i>商品销售规律</a></li>
						<li><a href="${ctx}/productimex/product"><i class="icon-font">&#xe017;</i>商品进出货</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span></span><span>添加商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${ctx}/shangpin-insert/add" onsubmit = "return submitFlag()" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>商品名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text" onBlur="checkTitle()" onfocus="focusTitle()"/>
                                    <label id="titleNullTip"></label>
                                </td>               
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>数量：</th>
                                <td>
                                    <input class="common-text required" id="number" name="count" size="50" value="" type="text" onBlur="checkNumber()" onfocus="focusNumber()"/>
                                    <label id="numberNullTip"></label>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>进价（单位：元）：</th>
                                <td>
                                    <input class="common-text required" id="bid" name="bid" size="50" value="" type="text" onBlur="checkBid()" onfocus="focusBid()"/>
                                    <label id="bidNullTip"></label>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>售价（单位：元）：</th>
                                <td>
                                    <input class="common-text required" id="price" name="price" size="50" value="" type="text" onBlur="checkPrice()" onfocus="focusPrice()"/>
                                    <label id="priceNullTip"></label>
                                </td>
                            </tr>
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit" id="push">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
