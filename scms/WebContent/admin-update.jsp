<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="admin-update/html; charset=utf-8" /> 
    <title>『用户』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
<script type="text/javascript">
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
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="user-design.html">首页</a></li>
             
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
            <div class="crumb-list"><i class="icon-font"></i><a href="user-design.jsp">首页</a><span class="crumb-step">&gt;</span></span><span>修改管理员密码</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/jscss/admin/design/add" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                                
                            <tr>
                                <th><i class="require-red">*</i>原密码：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>修改密码为：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
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