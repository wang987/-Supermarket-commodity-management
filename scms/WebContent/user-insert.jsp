<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="user-design.jsp">首页</a><span class="crumb-step">&gt;</span><span>添加用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/jscss/admin/design/add" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab">
                    	<div>
                        <tbody>
                        	<tr>
                           <span>
                           <form onsubmit="returnsubmitFlag();" action="onlineRepairSystem/OnlineRepairServlet?action=judgeStudent"method="post">  
							<th><i class="require-red">*</i>登录名：</th>
							<td>
							<input id="title"class="common-text required" type="text" name="user" size="50" onBlur="checkUser()" onfocus="focusUser()"onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>  
            				<label id="userNullTip"></label>  
            				</td>
            				</tr>
            				<tr>
            				 <th><i class="require-red">*</i>密码：</th>
							<td>
           					<input id="password"class="common-text" type="password" name="password" size="50" onBlur="checkPassword()" onfocus="focusPassword()" onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>  
            				<label id="passwordNullTip"></label>  
            				  </td>
            				 </tr> 
         					</form>
         					</span>
				        <span style="font-size:18px;"><script type="text/javascript">  
				   		var flag;//判断是否可以提交  
				  		var userFlag=false;  
				   		var passFlag=false;  
				   		function checkUser(){  //判断用户名输入是否为空，如果为空给出错误提示  
				      		var userElement=document.getElementById("title"); //获得user输入标签  
				      		var userNullTip=document.getElementById("userNullTip");  //获得提示标签  
				      		if(userElement.value.length==0){  
				        		 userNullTip.innerHTML="<font color='red'>用户名不能为空！</font>";//设<label>标签红色提示内容            
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
					   function checkPassword(){   
					      var passElement=document.getElementById("password");  
					      var passNullTip=document.getElementById("passwordNullTip");  
					      if(passElement.value.length==0){  
					         passNullTip.innerHTML="<font color='red'>密码不能为空！</font>";//设置红色提示内容           
					      }  
					      else{  
					         passFlag=true;  
					      }  
					   }  
					   function focusPassword(){  
					      var passNullTip=document.getElementById("passwordNullTip");  
					      passNullTip.innerHTML="";  
					      passFlag=false;  
					   }  
					   function submitFlag(){  
					      if(userFlag==true&&passFlag==true){ //如果用户名和密码输入都不为空，则允许提交  
					         flag=true;  
					      }  
					      else{  
					         if(userFlag==false){  
					            var userNullTip=document.getElementById("userNullTip");  
					            userNullTip.innerHTML="<font color='red'>用户名不能为空！</font>";//设置红色提示内容  
					         }  
					         if(passFlag==false){  
					            var passNullTip=document.getElementById("passwordNullTip");  
					            passNullTip.innerHTML="<font color='red'>密码不能为空！</font>";//设置红色提示内容  
					         }  
					         flag=false;  
					      }  
					      return flag;  
					   }  
					   
					</script>
					</span>
							<tr>
                                <th>姓名：</th>
                                <td><input class="common-text" name="name" size="50" value="" type="text"></td>
                            </tr>
						    <tr>
                                <th>性别：</th>
                                <td><input name="sex" type="radio" value=""/>男
                                	<input name="sex" type="radio" value="">女</td>
                            </tr>
							<tr>
                                <th>联系方式：</th>
                                <td><input id="telephone" placeholder="请输入11位数字" class="common-text" name="telephone" size="50" value="" type="text"onBlur="checktelephone()" onfocus="focustelephone()"onkeyup="this.value=this.value.replace(/[, ]/g,'')">
                            	 <label id="telephoneNullTip"></label>
                            	  <span style="font-size:18px;"><script type="text/javascript">  
			            var flag;
			              
			            function checktelephone(){  //判断手机号不符合要求，如果为空给出错误提示  
			               var telephoneElement=document.getElementById("telephone"); //获得telephone输入标签  
			               var telephoneNullTip=document.getElementById("telephoneNullTip");  //获得提示标签  
			               if(telephoneElement.value.length!=11){  
			                  telephoneNullTip.innerHTML="<font color='red'>手机号必须为11位</font>";//设<label>标签红色提示内容      
			                   
			               }else{
			
			            		 for(var i=0;i<telephoneElement.value.length;i++){
			          	  			 oneNum=telephoneElement.value.substring(i,i+1);
			          	  			
			          	   		 	if (oneNum<"0" || oneNum>"9")
			          	   			{
			          	   				window.alert("必须填写数字");
			          	   			}
			          	   
			          	     	 }
			               }
			               
			               
			            }  
			            function focustelephone(){  
			               var telephoneNullTip=document.getElementById("telephoneNullTip");  
			               telephoneNullTip.innerHTML="";   //隐藏红色提示文字  
			                 
			            } 
			            </script></span> 
			            </td>  
			            </tr>
						<tr>
						<script language="javascript" type="text/javascript" >  
					/** 
					 * Check email format 
					 */  
						function emailCheck(obj, labelName) {  
				   	 var objName = eval("document.all."+obj);  
				    var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
				    	if (!pattern.test(objName.value)) {  
				        alert("请输入正确的邮箱地址。");  
				        objName.focus();  
				        return false;   
				    	}  
				   	 return true;  
					}  
				</script> 
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
                </form>
                </div>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>