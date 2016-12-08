<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx}/adminlogin/checkAdmin">首页</a><span class="crumb-step">&gt;</span><span>添加用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${ctx}/adminlogin/save" method="post" id="myform" name="myform">
                    <table class="insert-tab">
                    	<div>
                        <tbody>
                        	<tr>
                           <span>
							<th><i class="require-red">*</i>登录名：</th>
							<td>
							<input id="title"class="common-text required" type="text" name="username" size="50" onBlur="checkUser()" onfocus="focusUser()"onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>  

            				</td>
            				</tr>
            				<tr>
            				 <th><i class="require-red">*</i>密码：</th>
							<td>
           					<input id="password"class="common-text" type="password" name="userpassword" size="50" onBlur="checkPassword()" onfocus="focusPassword()" onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>  
            				
            				  </td>
            				 </tr> 
							<tr>
                                <th>姓名：</th>
                                <td><input class="common-text" name="realname" size="50"  type="text"></td>
                            </tr>
						    <tr>
                                <th>性别：</th>
                                <td><input name="sex" type="radio" value="男"/>男
                                	<input name="sex" type="radio" value="女">女</td>
                            </tr>
							<tr>
                                <th>联系方式：</th>
                                <td><input id="telephone" placeholder="请输入11位数字" class="common-text" name="tel" size="50"  type="text"onBlur="checktelephone()" onfocus="focustelephone()">
                            	 <label id="telephoneNullTip"></label>
                            	  <span style="font-size:18px;"></span> 
			            </td>  
			            </tr>
						<tr>
			
                                <th>邮箱：</th>
                                <td><input type="text" id="email" name="email" size="50" onblur="return emailCheck('email', 'email')"/> </td>
                            </tr>
							<tr>
                                <th>学校：</th>
                                <td><input class="common-text" name="school" size="50" value="" type="text"></td>
                            </tr>
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>

         					</span>

                </form>
                </div>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>