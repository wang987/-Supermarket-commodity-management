<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>

    <script type="text/javascript" >
         function b()
{
var r=confirm("您确定要退出吗");
if (r==true)
  {
    window.location.href='admin-login.jsp';
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
                <li><a class="on" href="user-design.jsp">首页</a></li>
               
            </ul>
        </div>
        <div class="top-info-wrap">
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
                        <li><a href="user-insert.jsp"><i class="icon-font">&#xe017;</i>添加用户</a></li>
                        <li><a href="user-design.jsp"><i class="icon-font">&#xe037;</i>查看用户</a></li>
                        <li><a href="admin-update.jsp"><i class="icon-font">&#xe047;</i>修改管理员密码</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="user-design.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">查看用户</span></div>
        </div>
        <div class="search-wrap">
           
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="user-insert.jsp"><i class="icon-font"></i>添加用户</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>登录名</th>
							<th>姓名</th>
							<th>性别</th>
                            <th>联系方式</th>
							<th>邮箱</th>
							<th>学校</th>
                            <th>操作</th>
                        </tr>
                            <td>59</td>
                            <td>artichoke</td>
							<td>张三</td>
							<td>男</td>
                            <td>15232587456</td>
							<td>15954656@qq.com</td>
							<td>河北师范大学</td>
                            <td>
                               <input type="button" onClick=window.location.href='user-update.jsp' value="修改">
                               <input type="button" onclick="a()" value="删除" />
                            </td>
                        </tr>
                        <tr>
                            <td>58</td>
                            <td>hyacinth</td>
							<td>李四</td>
							<td>男</td>
                            <td>18832587456</td>
							<td>159244656@qq.com</td>
							<td>河北科技大学</td>
                            <td>
                                <input type="button" onClick=window.location.href='user-update.jsp' value="修改">
                                <input type="button" onclick="a()" value="删除" />
                            </td>
                        </tr>
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