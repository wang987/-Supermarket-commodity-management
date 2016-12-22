<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>修改商品</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
    <script type="text/javascript">
    	window.onload = function(){
    		var sHref = window.location.href//测试数据，实际情况是用window.location.href得到URL
    		var args = sHref.split("?");
    		var retval = ""; 
    		if(args[0] == sHref) /*参数为空*/ 
    		{ 
    		return retval; /*无需做任何处理*/ 
    		} 
    		var str = args[1]; 
    		args = str.split("&"); 
    		for(var i = 0; i < args.length; i++ ) 
    		{ 
    			str = args[i];  
    			var arg = str.split("="); 
    			if(arg.length <= 1) continue; 
    			retval =decodeURIComponent(arg[1]); 
    			document.getElementsByClassName('common-textarea')[i].value=retval;
    		} 
    	}
    </script>
    <style type="text/css">
    	#name{
    		background-color: #E0E0E0;
    	}
    </style>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/index.jsp">首页</a></li>
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
						<li><a href="${ctx}/${ctx}/productimex/product"><i class="icon-font">&#xe017;</i>商品进出货</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx}/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="shangpin-design.html">查看商品</a><span class="crumb-step">&gt;</span><span>修改商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${ctx}/shangpin-insert/add" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                             <tr>
                                <th>名字：</th>
                                <td><input name="name" class="common-textarea" id="name" style="width: 60%;" readonly/><span id="bidTip" style="color:red;display:none">进价不能为空,负数或0</span></td>
                            </tr>
                             <tr>
                                <th>库存：</th>
                                <td><input name="count" class="common-textarea" id="count" style="width: 60%;" /><span id="bidTip" style="color:red;display:none">进价不能为空,负数或0</span></td>
                            </tr>
                            <tr>
                                <th>进价：</th>
                                <td><input name="bid" class="common-textarea" id="bid"  style="width: 60%;" /><span id="bidTip" style="color:red;display:none">进价不能为空,负数或0</span></td>
                            </tr>
                            <tr>
                                <th>售价：</th>
                                <td><input name="price" class="common-textarea" id="price"  style="width:60%;" /><span id="priceTip" style="color:red;display:none">售价不能为空,负数或0</span></td>
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