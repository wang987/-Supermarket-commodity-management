<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
if(request.getSession().getAttribute("admin")==null)
{
	response.sendRedirect("admin-login.jsp")	;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
    <script type="text/javascript" >
    function exit() {
    	var msg = "您真的确定要退出吗？\n\n请确认！";
    	if (confirm(msg)==true){
    	return true;
    	}else{
    	return false;
    	}
    }                	
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/adminlogin/checkAdmin" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/adminlogin/checkAdmin">首页</a></li>
             
            </ul>
        </div>
        <div class="top-info-wrap">
        	当前用户：${admin.adminName}
            <ul class="top-info-list clearfix">          
                
                 <input type="button" class="btn btn-primary btn2" onclick="exit()" value="退出" />
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
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx }/adminlogin/checkAdmin">首页</a><span class="crumb-step">&gt;</span></span><span>修改用户</span></div>
        </div>
        <h4 align="center" font-color="red">${message}</h4>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${ctx}/adminlogin/save" method="post" id="myform" name="myform">
                	<input type="hidden" name="userinfoid" value="${ui[0].userinfoid}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                                <th><i class="require-red">*</i>真实姓名：</th>
                                <td>
                                    <input class="common-text required" name="realname" size="50" value="${ui[0].realname}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>登录名：</th>
                                <td>
                                    <input class="common-text required"  name="username" size="50" value="${ui[0].username}" type="text">
                                </td>
                            </tr>
                           
                            <tr>
                                <th>密码：</th>
                                <td><input class="common-text" name="userpassword" size="50" value="${ui[0].userpassword}" type="text"></td>
                            </tr>
                           <tr>
                                <th>性别：</th>
                                <td><input class="common-text" name="sex" size="50" value="${ui[0].sex}" type="text"></td>
                            </tr>
							<tr>
                                <th>联系方式：</th>
                                <td><input class="common-text" name="tel" size="50" value="${ui[0].tel}" type="text"></td>
                            </tr>
							<tr>
                                <th>邮箱：</th>
                                <td><input class="common-text" name="email" size="50" value="${ui[0].email}" type="text"></td>
                            </tr>
							<tr>
                                <th>学校：</th>
                                <td><input class="common-text" name="school" size="50" value="${ui[0].school}" type="text"></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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