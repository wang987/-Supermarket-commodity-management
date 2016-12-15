<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
if(request.getSession().getAttribute("admin")==null)
{
	response.sendRedirect("${ctx}/admin-login.jsp")	;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
    <script type="text/javascript">  
   		var flag;//判断是否可以提交  
  		var userFlag=false;  
   		var passwordFlag=false;
   		var nameFlag=false;
   		var sexFlag=false;
   		var telephoneFlag=false;
   		var emailFlag=false;
   		var schoolFlag=false;
   	 //判断用户名输入是否为空，如果为空给出错误提示 
   		function checkUser(){  
      		var userElement=document.getElementById("title"); //获得user输入标签  
      		var userNullTip=document.getElementById("userNullTip");  //获得提示标签  
      		if(userElement.value.length==0){  
        		 userNullTip.innerHTML="<font color='red'>请输入用户名！</font>";//设<label>标签红色提示内容   
        		 userFlag=false;
     		 }  
     		 else{  
         		userFlag=true;  
      		}  
  		 }  
	   function focusUser(){  
	      var userNullTip=document.getElementById("userNullTip");  
	      userNullTip.innerHTML="";   //隐藏红色提示文字  
	      userFlag=false;  
	   }
	 //判断密码输入是否为空，如果为空给出错误提示
	   function checkPassword(){   
	      var passwordElement=document.getElementById("password");  
	      var passwordNullTip=document.getElementById("passwordNullTip");  
	      if(passwordElement.value.length==0){  
	         passwordNullTip.innerHTML="<font color='red'>请输入密码！</font>";//设置红色提示内容   
	         passwordFlag=false;
	      }  
	      else{  
	         passwordFlag=true;  
	      }  
	   }  
	   function focusPassword(){  
	      var passNullTip=document.getElementById("passwordNullTip");  
	      passNullTip.innerHTML="";  
	      passwordFlag=false;  
	   }  
	 //判断姓名输入是否为空，如果为空给出错误提示
	   function checkName(){    
	      var nameElement=document.getElementById("name");  
	      var nameNullTip=document.getElementById("nameNullTip");  
	      if(nameElement.value.length==0){  
	         nameNullTip.innerHTML="<font color='red'>请输入姓名！</font>";//设置红色提示内容   
	         nameFlag=false;
	      }  
	      else{  
	         nameFlag=true;  
	      }  
	   }  
	   function focusName(){  
	      var nameNullTip=document.getElementById("nameNullTip");  
	      nameNullTip.innerHTML="";  
	      nameFlag=false;  
	   }
       //判断性别输入是否为空，如果为空给出错误提示
	   function checkSex(){
	       var sexElement=document.getElementsByTagName("sex");	
	       var sexNullTip=document.getElementById("sexNullTip");
	       if(sexElement.value==""){ 	    	   
	          sexNullTip.innerHTML="<font color='red'>性别不能为空！</font>";//设置红色提示内容   
	          sexFlag=false;
	       }  
	       else{ 
	          sexFlag=true;        
	       }  
	   }  
	   function focusSex(){  
	       var sexNullTip=document.getElementById("sexNullTip");  
	       sexNullTip.innerHTML=""; 	       
	       sexFlag=true;
	   }
	 //判断手机号符不符合要求，如果为空给出错误提示 
	   function checkTelephone(){   
           var telephoneElement=document.getElementById("telephone"); //获得telephone输入标签  
           var telephoneNullTip=document.getElementById("telephoneNullTip");  //获得提示标签  			               
           var pattern=/(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;//验证手机号
		   if (telephoneElement.value.length == 0){
			   telephoneNullTip.innerHTML="<font color='red'>请输入手机号！</font>";
			   telephoneFlag = false;
		   }else if (!pattern.test(telephoneElement.value)){
	       	   telephoneNullTip.innerHTML="<font color='red'>手机号格式不正确！</font>";//设<label>标签红色提示内容
	       	   telephoneFlag = false;
	       }else{
	    	   telephoneFlag = true;
	       }
       }  
       function focusTelephone(){  
          var telephoneNullTip=document.getElementById("telephoneNullTip");  
          telephoneNullTip.innerHTML="";   //隐藏红色提示文字
          telephoneFlag = false;
       }
     //判断邮箱符不符合要求，如果为空给出错误提示
       function checkEmail() {  
		var emailElement = document.getElementById("email"); //获取email输入标签
   	 	var emailNullTip=document.getElementById("emailNullTip");  //获得提示标签
    	var epattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
    	if (emailElement.value.length == 0){
			   emailNullTip.innerHTML="<font color='red'>请输入邮箱！</font>";
			   emailFlag = false;
	    }else if (!epattern.test(emailElement.value)){
          	    emailNullTip.innerHTML="<font color='red'>邮箱格式不正确！</font>";//设<label>标签红色提示内容
          	    emailFlag = false;
           }else{
       	    emailFlag = true;
           }
       }  
       function focusEmail(){  
          var emailNullTip=document.getElementById("emailNullTip");  
          emailNullTip.innerHTML="";   //隐藏红色提示文字  
          emailFlag = false;
       }
     //判断学校输入是否为空，如果为空给出错误提示
       function checkSchool(){   
	       var schoolElement=document.getElementById("school");  
	       var schoolNullTip=document.getElementById("schoolNullTip");  
	       if(schoolElement.value.length==0){  
	          schoolNullTip.innerHTML="<font color='red'>请输入学校！</font>";//设置红色提示内容   
	          schoolFlag=false;
	       }  
	       else{  
	          schoolFlag=true;  
	       }  
	   }  
	   function focusSchool(){  
	       var schoolNullTip=document.getElementById("schoolNullTip");  
	       schoolNullTip.innerHTML="";  
	       schoolFlag=false;  
	   }
	   function submitFlag(){		  		   
	      if(userFlag==true&&passwordFlag==true&&nameFlag==true&&sexFlag==true&&telephoneFlag==true&&emailFlag==true&&schoolFlag==true){ //如果用户名和密码输入都不为空，则允许提交  
	    	  alert("添加成功！");
	    	  return true;  
	      }  
	      else{  
	         alert("输入数据有误，请重新输入！");
	         return false;  
	      }   
	   }
	   function exit() {
	    	var msg = "您真的确定要退出吗？\n\n请确认！";
	    	if (confirm(msg)==true){
	    		window.location.href="${ctx}/admin-login.jsp";
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
            <div class="crumb-list"><i class="icon-font"></i><a href="${ctx}/adminlogin/checkAdmin">首页</a><span class="crumb-step">&gt;</span><span>添加用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${ctx}/adminlogin/save" onsubmit = "return submitFlag()" method="post" id="myform" name="myform">
                    <table class="insert-tab">
                    	<div>
                        <tbody>
                        	<tr>
                           <span>
							<th><i class="require-red">*</i>登录名：</th>
							<td>
							<input id="title"class="common-text required" type="text" name="username" placeholder="请输入登录名" size="50" onBlur="checkUser()" onfocus="focusUser()"/>  
            				<label id="userNullTip"></label>  
            				</td>
            				</tr>
            				
            				<tr>
            				 <th><i class="require-red">*</i>密码：</th>
							<td>
           					<input id="password" class="common-text" type="password" name="userpassword" placeholder="请输入密码" size="50" onBlur="checkPassword()" onfocus="focusPassword()"/>  
            				<label id="passwordNullTip"></label>  
            				</td>
            				
            				</tr>        
				        	<span style="font-size:18px;"></span>
							<tr>
                                <th><i class="require-red">*</i>姓名：</th>
                                <td><input id="name" class="common-text"  name="realname" placeholder="请输入姓名" size="50" value="" type="text" onBlur="checkName()" onfocus="focusName()"/>
                                <label id="nameNullTip"></label>
                                </td>
                            </tr>
						    <tr>
                                <th><i class="require-red">*</i>性别：</th>
                                <td>
                             	    <input id="male" value="男" name="sex" type="radio" value="" onBlur="checkSex()" onfocus="focusSex()"/>男
                                	<input id="famale" value="女" name="sex" type="radio" value="" onBlur="checkSex()" onfocus="focusSex()"/>女
                                	<label id="sexNullTip"></label>
                                </td>
                            </tr>
							<tr>
                                <th><i class="require-red">*</i>联系方式：</th>
                                <td><input id="telephone" placeholder="请输入手机号" class="common-text" name="tel" size="50" value="" type="text"onBlur="checkTelephone()" onfocus="focusTelephone()"/>
                            	<label id="telephoneNullTip"></label>
                            	<span style="font-size:18px;">
                        		</span> 
			            </td>  
			            </tr>
						<tr>						
                                <th><i class="require-red">*</i>邮箱：</th>
                                <td><input type="text" id="email" name="email" size="50" placeholder="请输入邮箱" onblur="checkEmail()" onfocus="focusEmail()"/>
                                <label id="emailNullTip"></label>
                            	<span style="font-size:18px;"> </span>
                                </td>
                            </tr>
                            
							<tr>
                                <th><i class="require-red">*</i>学校：</th>
                                <td><input id="school" class="common-text"  name="school" placeholder="请输入学校" size="50" value="" type="text" onBlur="checkSchool()" onfocus="focusSchool()"/>
                                <label id="schoolNullTip"></label>
                            	<span style="font-size:18px;"> </span>
                                </td>
                            </tr>
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