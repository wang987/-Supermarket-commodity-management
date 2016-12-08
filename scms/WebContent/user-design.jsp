<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if(request.getSession().getAttribute("admin")==null)
{
	response.sendRedirect("admin-login.jsp")	;
}
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"/>

    <script type="text/javascript" >
         function b()
{
var r=confirm("您确定要退出吗");
if (r==true)
  {
    window.location.href='${ctx}/admin-login.jsp';
  }
else
  {
  return false;
  }
}
function a()
{
var r=confirm("您确定要删除吗");
if (r==true)
  {
  alert("已删除");
  }
else
  {
  return false;
  }
}
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/adminlogin/checkAdmin">首页</a></li>
               
            </ul>
        </div>
        <div class="top-info-wrap">
        	当前用户：${admin.adminName}
            <ul class="top-info-list clearfix">
               
                 <input type="button" class="btn btn-primary btn2" onclick="b()" value="退出" />
            </ul>
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
                        <li><a href="${ctx}/adminlogin/addAdmin"><i class="icon-font">&#xe017;</i>添加用户</a></li>
                        <li><a href="${ctx}/adminlogin/checkAdmin"><i class="icon-font">&#xe037;</i>查看用户</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx}/adminlogin/checkAdmin">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">查看用户</span></div>
        </div>
        <div class="search-wrap">
           
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${ctx}/adminlogin/addAdmin"><i class="icon-font"></i>添加用户</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <thread>
                            <th>ID</th>
                            <th>登录名</th>
							<th>姓名</th>
							<th>性别</th>
                            <th>联系方式</th>
							<th>邮箱</th>
							<th>学校</th>
                            <th>操作</th>
                        </thread>
                        <tbody>
                       
                        <c:forEach var="item" items="${list}" varStatus="status">
	                       <tr>
	                     
	                            <td>${item.userinfoid}</td>
	                            <td>${item.username}</td>
								<td>${item.realname}</td>
								<td>${item.sex}</td>
	                            <td>${item.tel}</td>
								<td>${item.email}</td>
								<td>${item.school}</td>
	                            <td>
	                               <a  href="${ctx}/adminlogin/modifyAdmin?userinfoid=${item.userinfoid}" >修改</a>
	                               <a href="${ctx}/adminlogin/del?userinfoid=${item.userinfoid}&username=${item.username}" >删除</a>
	                            </td>
	                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="list-page"> 2 条 1/1 页</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>