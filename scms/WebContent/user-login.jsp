<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>『校园超市商品』后台管理</title>
    <link href="css/admin_login.css" rel="stylesheet" type="text/css" />
        <style>
   
         body {background-image:url(images/1.jpg);}
         h2 {font-size:40px; text-align:center; }
        
        </style>
	<script type="text/javascript">  
      function checkuser() {  
         if($('user') == "admin" && $('pwd') =="123456") {  
            return true; 
         }else { 
            alert("账号或密码有误，请重新登录");
			return false;
         }
      }  
        
      function $(id) {  
        return document.getElementById(id).value;  
      }  
 
     </script>
</head>
<body>
<div class="admin_login_wrap">
    <h2>用户登录</h2>
   
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="index.jsp" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user"></label>
                        <input type="text" name="username" placeholder="请输入您的ID" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd"></label>
                        <input type="password" name="pwd" placeholder="请输入您的密码" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" onclick="return checkuser()"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    
</div>

</body>
</html>