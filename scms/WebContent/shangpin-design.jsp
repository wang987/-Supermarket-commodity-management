<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="shangpin-design/html; charset=utf-8" /> 
    <title>查看商品</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
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
    <script type="text/javascript" >
        //写一个表单点击删除了以后，然后跳转，然后传参
    	function a(index)
     	{
        	var i=document.getElementsByClassName('productid')[index].innerText;
       		var a=document.getElementById("submita").href = "${ctx}/delete/delete?productid="+i; 
       		alert(a);
       		document.getElementById("submita").click();
     	}
        function alter(index){
        	//获得值
        	var name=document.getElementsByClassName('name')[index].innerText;
        	var count=document.getElementsByClassName('count')[index].innerText;
        	var a=document.getElementById("submita").href = "${ctx}/shangpin-revise.jsp?name="+encodeURIComponent(name)+"&count="+count; 
       		document.getElementById("submita").click();
        }
        function c(index)
     	{
        	var id=document.getElementsByClassName('productid')[index].innerText;
    		var i=document.getElementsByClassName('changecount')[index].value;
       		if(i.length!=0&&i>=0&&i%1==0){
       			var a=document.getElementById("submita").href = "${ctx}/imexgoods/goods?productid="+id+"&count="+i+"&tag=sell"; 
           		alert(a);
       			document.getElementById("submita").click();
       			
       		}else{
       			alert("参数不正确，不能为空，必须是大于0的整数");
       		}
       	}
        function b(index)
     	{
    		var id=document.getElementsByClassName('productid')[index].innerText;
    		var i=document.getElementsByClassName('changecount')[index].value;
       		if(i.length!=0&&i>=0&&i%1==0){
       			var a=document.getElementById("submita").href = "${ctx}/imexgoods/goods?productid="+id+"&count="+i+"&tag=buy"; 
           		alert(a);
       			document.getElementById("submita").click();
       			
       		}else{
       			alert("参数不正确，不能为空，必须是大于0的整数");
       		}
       	}
    </script>
</head>
<body>
<a id="submita" href="${ctx}/delete/delete?productid=1" style="display:none;"></a>
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
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx }/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品查询</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${ctx}/seesearch/search" method="post">
                    <table class="search-tab">
                        <tr>
                            
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${ctx}/shangpin-insert.jsp"><i class="icon-font"></i>新增商品</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>                          
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>库存</th>
                            <th>进价</th>
                            <th>售价</th> 
                            <th>利润</th>                           
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach varStatus="vi" items="${userarr}" var="user" >
							 <tr>                            
                            <td class="productid">${user.productId}</td>
                            <td class="name">${user.name}</td>
                            <td class="count">${user.count}</td>
                            <td>${user.bid}</td>
                            <td>${user.price}</td>
                            <td>${user.profit}</td>
                            <td>
                                <input type="button" name="${vi.index}" onClick="alter(this.name)" value="修改">
                                <input type="button" name="${vi.index}" onClick="a(this.name)" value="删除" />
                                <input type = "button" name="${vi.index}" onClick="c(this.name)" value = "出货"></input>
								<input type = "text" class="changecount" name = "number" id="count" value = ""></input>
								<input type = "button" name="${vi.index}" onClick="b(this.name)" value ="进货"></input>
                            </td>
                        </tr>
						</c:forEach>
                    </table>
                    <div class="list-page">
                    <ul class="pagination">
					  <li><a href="${ctx}/queryproduct/query?nowpage=${nowpage-1}">«</a></li>					  					  
					  <c:forEach begin="1" end="${queryend}" step="1" var="i">
					  	<li><a href="${ctx}/queryproduct/query?nowpage=${i}">${i}</a></li>
					  </c:forEach>
					  <li ><a href="${ctx}/queryproduct/query?nowpage=${nowpage+1}">»</a></li>
					</ul>

                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>