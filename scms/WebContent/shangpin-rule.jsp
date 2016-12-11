<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>商品销售规律</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
   	<script type="text/javascript" src="${ctx }/WdatePicker.js"></script>
   	
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
    <script type="text/javascript">  
      
    function time(d){
    	
    		var pre=document.getElementById("predate").value;
        	var now=document.getElementById("nowdate").value;
        	if(d.tagName=='A'){
        		if(d.href.indexOf("?")){
        			d.href=d.href+"&predate="+pre+"&nowdate="+now;
            		d.click();
        		}else{
        			d.href=d.href+"?predate="+pre+"&nowdate="+now;
            		d.click();
        		}
        		
        	}
    		if(d.tagName=='INPUT'){
    			for(var i=0;i<document.getElementsByTagName("form").length;i++){
    				alert(document.getElementsByTagName("form")[i].action);
    				var str=document.getElementsByTagName("form")[i].action;
    				document.getElementsByTagName("form")[i].action=str+"?predate="+pre+"&nowdate="+now; 
    				alert(document.getElementsByTagName("form")[i].action);
    			}
    			
    			//d.click();
    		}
    }
    
    
    
	    	
    
    
    </script>
    <style type="text/css">
   		ul.pagination {
	    display: inline-block;
	    padding: 0;
	    margin: 0;
		}
	
		ul.pagination li {display: inline;}
	
		ul.pagination li a {
		    color: black;
		    float: left;
		    padding: 8px 16px;
		    text-decoration: none;
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
                
        </div>
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
        <div><input id="predate" value="1996-06-01" type="text" onClick="WdatePicker()"/></div>
			
		<div><input id="nowdate" value="2016-12-10" type="text" onClick="WdatePicker()"/></div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx }/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品销售规律</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${ctx}/rulesearch/search" method="post" class="sub">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input  onclick="time(this)" class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
                <form action="${ctx}/rulefindall/findall" method="post" class="sort" >
                	<input onclick="time(this)" class="btn btn-warning btn2" type="submit" name="btn" value="按销量排序"/>
                	<input onclick="time(this)" class="btn btn-warning btn2" type="submit" name="btn" value="按利润排序"/>
                	
                </form>
            </div>
        </div>
        
		<div class="select-btn clearfloat">
			<div class="radius">
				<img id="sectorimg"  src="${ctx }/Sector" onclick="this.src=this.src+'?'" />
			</div>
			<div class="radius">
				<img src="${ctx }/Pillar" onclick="this.src=this.src+'?'"/>
			</div>
			
			
		</div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>                           
                         	<th>ID</th>
                            <th>商品名称</th>
                            <th>进价</th>
                            <th>售价</th>
							<th>销量</th>
							<th>利润</th>

                        </tr>
                         <c:forEach items="${userarr}" var="user" >
                            <tr>
	                            <td>${user.id}</td>
	                            <td>${user.name}</td>
	                            <td>${user.bid}</td>
	                            <td>${user.price}</td>
								<td>${user.solds}</td>
	                            <td>${user.profits}</td>
                       		 </tr>
                         </c:forEach>
                     
                       
                    </table>
                    <div class="list-page">
                    	<ul class="pagination">
							  <li><a onclick="time(this)" href="${ctx}/rulefindall/findall?btn=0&nowpage=${nowpage-1}">«</a></li>
							  <c:forEach begin="1" end="${ruleend}" step="1" var="i">
							  	<li><a onclick="time(this)" href="${ctx}/rulefindall/findall?btn=0&nowpage=${i}">${i}</a></li>
							  </c:forEach>
							  <li ><a onclick="time(this)" href="${ctx}/rulefindall/findall?btn=0&nowpage=${nowpage+1}">»</a></li>
						</ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
</div>
</body>
</html>