<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>『校园超市商品』后台管理</title>
    
    <link href="${ctx}/css/admin_login.css" rel="stylesheet" type="text/css" />
    <style>  
         body {background-image:url(${ctx}/images/bg.jpg);}
         h2 {font-size:49px; text-align:center;color:white;font-family:'宋体' ;font-weight:400; }
        </style>
</head>
<body>
<div class="admin_login_wrap">
    <h2>用户登录</h2>
   	<h4 align="center" style="color:red;">${errormessage}</h4>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${ctx}/userlogin/login">
                <ul class="admin_items">
                    <li>                       
                        <input type="text" name="username" value="${username}" id="user" size="40" placeholder="请输入用户名" class="admin_input_style" />
                    <li>
                  
                    <li>                        
                        <input type="password" name="pwd" value="${psw}" id="pwd" size="40" placeholder="请输入密码" class="admin_input_style" />
                    </li>
                     <li>
                        <input type="text" name="yzm" size="20" placeholder="请输入验证码" class="admin_input_style" />
                        <img src="${ctx}/CheckCodeServlet" id="Yzm" onclick="this.src=this.src+'?'"/>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="登录" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    
</div>

</body>
</html>