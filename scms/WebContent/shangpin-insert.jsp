<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>『添加商品页』</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <script type="text/javascript">
    window.onload=function(){
        var title = document.getElementById('title');
        var titleTip = document.getElementById('titleTip');
        var number = document.getElementById('number');
        var numberTip = document.getElementById('numberTip');
        var bid = document.getElementById('bid');
        var bidTip = document.getElementById('bidTip');
        var price = document.getElementById('price');
        var priceTip = document.getElementById('priceTip');
        console.log(titleTip);
        var push = document.getElementById('push');
        title.onblur = function(){
            if(title.value == ''){
                titleTip.style.display="inline";
            }else{
                titleTip.style.display="none";
            }
        }
        number.onblur = function(){
            if(number.value == ''){
                numberTip.style.display="inline";
            }else{
                numberTip.style.display="none";
            }
        }
        bid.onblur = function(){
            if(bid.value == '' || bid.value == 0 || bid.value < 0){
                bidTip.style.display="inline";
            }else{
                bidTip.style.display="none";
            }
        }
        price.onblur = function(){
            if(price.value == '' || price.value == 0 || price.value < 0){
                priceTip.style.display="inline";
            }else{
                priceTip.style.display="none";
            }
        }
        push.onclick = function(){
            alert("您确定要提交吗?");
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
                <li><a class="on" href="index.jsp">首页</a></li>
            </ul>
        </div>
                
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
                        <li><a href="shangpin-insert.jsp"><i class="icon-font">&#xe008;</i>添加商品</a></li>
                        <li><a href="shangpin-design.jsp"><i class="icon-font">&#xe005;</i>查看商品</a></li>
                        <li><a href="shangpin-rule.jsp"><i class="icon-font">&#xe006;</i>商品销售规律</a></li>
                        <li><a href="shangpin-imexport.jsp"><i class="icon-font">&#xe017;</i>商品进出货</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span></span><span>添加商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/jscss/admin/design/add" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>商品名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="title" size="50" value="" type="text">
                                    <span id="titleTip" style="color:red;display:none">商品名不能为空</span>
                                </td>               
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>数量：</th>
                                <td>
                                    <input class="common-text required" id="number" name="number" size="50" value="" type="text">
                                    <span id="numberTip" style="color:red;display:none">数量不能为空</span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>进价（单位：元）：</th>
                                <td>
                                    <input class="common-text required" id="bid" name="bid" size="50" value="" type="text">
                                    <span id="bidTip" style="color:red;display:none">进价不能为空,负数或者0</span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>售价（单位：元）：</th>
                                <td>
                                    <input class="common-text required" id="price" name="price" size="50" value="" type="text">
                                    <span id="priceTip" style="color:red;display:none">售价不能为空,负数或者0</span>
                                </td>
                            </tr>
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit" id="push">
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
Contact GitHub API Training Shop Blog About
© 2016 GitHub, Inc. Terms Privacy Security Status Help