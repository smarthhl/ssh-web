<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href="images/blocks.png" type="image/x-icon" />
		<title>投米商务数据平台</title>
		<link href='css/admin.css' rel="stylesheet" type="text/css" />
		<link href='css/login2.css' rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<!--  <script type="text/javascript" src="js/login.js"></script>-->
<script type="text/javascript">
$(function() {
	/**var msg="${tipMessage}";
	if(msg!=""){
		alert(msg);
	}*/
	var msg1="${registerMessage}";
	if(msg1!=""){
		alert(msg1);
		$.post('app!loginout',function(response) {  
	           //sdata=  response;
	           location.href = 'login.jsp';
	    }, "json");  
		//location.href = 'login.jsp';
	}
});
$(function(){
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'100px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'240px',width:'100px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
	if(getParam("a")=='0')
	{
		$('#switch_login').trigger('click');
	}

});
function sub(){
	var url="app!login?uname="+$('#u').val()+"&upass="+$('#p').val();
	
	$.post(url, function(result) {
		if (result.code ==1) {
			$("#login_form").submit();
		} else {
			alert(result.msg);
		}
	},'json');
}
function sub1(){
	//var url="app!login?uname=demo@creditease.cn&upass=creditease";
	
	//$.post(url, function(result) {
		//if (result.code ==1) {
			var urline='app!list?uname=demo@creditease.cn&upass=creditease';
			location.href = urline;
		//} else {
		//	alert(result.msg);
		//}
	//},'json');
}
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  

var reMethod = "GET",
	pwdmin = 6;

$(document).ready(function() {

	$('#reg').click(function() {

		var ema=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		//alert($('#email').val())
		if (!ema.test($('#email').val()) || $('#email').val().length < 5 || $('#email').val().length >50) {
			$('#email').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>Email格式不正确</b></font>");return false;
		} else {
			$('#email').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		
		/**if ($('#username').val() == "") {
			$('#username').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>用户名不能为空</b></font>");
			return false;
		}

		if ($('#username').val().length < 4 || $('#username').val().length > 16) {

			$('#username').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>用户名位4-16字符</b></font>");
			return false;

		}*/
		
		if ($('#passwd').val().length < pwdmin) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>两次密码不一致！</b></font>");
			return false;
		}
		
		
		var pho=/^1[3|4|5|8][0-9]\d{4,8}$/;
		if (!pho.test($('#mobile').val()) || $('#mobile').val().length < 5 || $('#mobile').val().length >12) {
			$('#mobile').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>手机号码格式不正确</b></font>");return false;
		} else {
			$('#mobile').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		var sqq = /^[1-9]{1}[0-9]{4,9}$/;
		if (!sqq.test($('#qq').val()) || $('#qq').val().length < 5 || $('#qq').val().length > 12) {
			$('#qq').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>QQ号码格式不正确</b></font>");return false;
		} else {
			$('#qq').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		var url ='app!checkUser?email='+$('#email').val();
		$.post(url, function(result) {
			if (result.code ==1) {
				$('#email').focus().css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$("#userCue").html(result.msg);
				return false;
			} else {
				
				$('#email').css({
					border: "1px solid #D7D7D7",
					boxShadow: "none"
				});
				$("#regUser").submit();
			}
		},'json');
		
	});
	

});
</script>
	</head>
	<body >
		<div align="center" style="font-size: 40px"> 
		
		后台升级中......
		
		</div>
		<p></p>
	</body>
</html>

