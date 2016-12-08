<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台登录</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/login.css"/>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script src="${ctx}/js/libs/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/libs/verificationNumbers.js" type="text/javascript"></script>
    <script src="${ctx}/js/libs/Particleground.js" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#509ee1',
                lineColor: '#509ee1'
            });
            createCode();
        });
        function CheckForm() {
            if ($("#username").val() == "") {
                alert("请输入用户名！");
                $("#username").focus();
                return false;
            }
            if ($("#password").val() == "") {
                alert("请输入密码！");
                $("#password").focus();
                return false;
            }
            if ($("#question").val() != 0 && $("#answer").val() == "") {
                alert("请输入问题回答！");
                $("#answer").focus();
                return false;
            }
        }

        $(function () {
            $(".loginForm input").keydown(function () {
                $(this).prev().hide();
            }).blur(function () {
                if ($(this).val() == "") {
                    $(this).prev().show();
                }
            });

            $("#username").focus(function () {
                $("#username").attr("class", "uname inputOn");
            }).blur(function () {
                $("#username").attr("class", "uname input");
            });

            $("#password").focus(function () {
                $("#password").attr("class", "pwd inputOn");
            }).blur(function () {
                $("#password").attr("class", "pwd input");
            });

            $("#question").focus(function () {
                $(".quesArea").attr("class", "quesAreaOn");
            }).blur(function () {
                $(".quesAreaOn").attr("class", "quesArea");
            });

            $("#answer").focus(function () {
                $(".quesArea").attr("class", "quesAreaOn");
            }).blur(function () {
                $(".quesAreaOn").attr("class", "quesArea");
            });

            $("#username").focus();
        });
    </script>
</head>
<body>
<dl class="admin_login">
    <dt>
        <strong>SLTL后台管理系统</strong>
        <em>SLTL Management System</em>
    </dt>
       <form action="${ctx}/adminlogin/checkAdmin" method="post" onSubmit="return CheckForm()">
        <dd class="user_icon">
            <input type="text" placeholder="管理员账号" id="username" name="adminName" class="login_txtbx"/>
        </dd>
        <dd class="pwd_icon">
            <input type="password" id="password" name="adminpassword" placeholder="密码" class="login_txtbx"/>
        </dd>
        <dd>
            <input type="submit" value="立即登陆" class="submit_btn"/>
            <input type="hidden" name="dopost" value="login"/>
        </dd>
    </form>
    <dd>
        <p>© 2015-2016 AMJ 版权所有</p>
        <p>沪xx-xxxxx-x</p>
    </dd>
</dl>
</body>
</html>
