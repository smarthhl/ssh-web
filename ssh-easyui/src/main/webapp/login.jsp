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
			//window.open(urline);
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
	<body>
		<table align="center"  cellSpacing=0 cellPadding=0>
			<tr>
				<td colspan="2">
					<IMG src="images/login_1.png">
				</td>
			</tr>
			<tr>
				<td align="left">
					<div class="login" style="">
						<div class="header">
							<div class="switch" id="switch">
								<a class="switch_btn_focus" id="switch_qlogin" style="width:150px;margin-left:20px"
									href="javascript:void(0);" tabindex="7">快速登录</a>
								<a class="switch_btn" id="switch_login"
									href="javascript:void(0);" tabindex="8">快速注册</a>
								<div class="switch_bottom" id="switch_bottom"
									style="position: absolute; width: 100px; left: 0px;"></div>
							</div>
						</div>
						<div class="web_qr_login" id="web_qr_login" style="display: block; height: 150px;" align="center">
							<!--登录-->
							<div class="web_login" id="web_login">
								<div class="login_form">
									<form  name="loginform" action="app!list" 
										accept-charset="utf-8" id="login_form" class="loginForm"
										method="post">
										<div class="uinArea" id="uinArea">
											<label class="input-tips" for="u">
												帐号：
											</label>
											<div class="inputOuter" id="uArea">
												<input type="text" id="u" name="uname" class="inputstyle"  placeholder="邮箱"  style="height:25px;line-height:25px;"/>
											</div>
										</div>
										<div class="pwdArea" id="pwdArea">
											<label class="input-tips" for="p">
												密码：
											</label>
											<div class="inputOuter" id="pArea">
												<input type="password" id="p" name="upass" class="inputstyle" placeholder="密码" style="height:25px;line-height:25px;"/>
											</div>
										</div>

										<div style="padding-left: 50px; margin-top: 30px;width: 350px;">
											<input type="button" value="登 录" style="width: 80px;" id="save" onclick="sub();" class="button_blue" />
											<input type="reset" value="重置" style="width: 80px;" class="button_blue" />
											<div style="padding-top: 10px;padding-right:10px;">
												<a  href="#" onclick="sub1();" style="font-size: 16px;color: blue">查看Demo</a>
											</div>
											
										</div>
									</form>
								</div>
							</div>
							<!--登录end-->
						</div>
						<!--注册-->
						<div class="qlogin" id="qlogin" style="display: none;" align="center">
							<div class="web_login" align="center">
								<form name="form2" id="regUser" accept-charset="utf-8"
									action="app!register" method="post">
									<input type="hidden" name="user_id"  />
									<ul class="reg_form" id="reg-ul">
										<div id="userCue" class="cue">快速注册请注意格式</div>
										<!--<li>
											<label for="user" class="input-tips2">
												用户名：
											</label>
											<div class="inputOuter2">
												<input type="text" id="username" name="user_name" maxlength="16"
													class="inputstyle2" />
											</div>
										</li>-->
										<li>
											<label for="qq" class="input-tips" style="width:25%;">
												邮箱<font color='red'>*</font>
											</label>
											<div class="inputOuter">
												<input type="text" id="email" name="email" maxlength="50"
													class="inputstyle" style="height:25px;line-height:25px;"/>
											</div>
										</li>
										<li>
											<label for="passwd" class="input-tips" style="width:25%;">
												密码<font color='red'>*</font>
											</label>
											<div class="inputOuter">
												<input type="password" id="passwd" name="pswd"
													maxlength="16" class="inputstyle" style="height:25px;line-height:25px;"/>
											</div>

										</li>
										<li>
											<label for="passwd2" class="input-tips" style="width:25%;">
												确认密码<font color='red'>*</font>
											</label>
											<div class="inputOuter">
												<input type="password" id="passwd2" name="pswd2" maxlength="16"
													class="inputstyle" style="height:25px;line-height:25px;"/>
											</div>
										</li>
										<li>
											<label for="qq" class="input-tips" style="width:25%;">
												手机<font color='red'>*</font>
											</label>
											<div class="inputOuter">
												<input type="text" id="mobile" name="mobile" maxlength="11"
													class="inputstyle" style="height:25px;line-height:25px;"/>
											</div>
										</li>
										<li>
											<label for="qq" class="input-tips" style="width:25%;">
												QQ<font color='red'>*</font>
											</label>
											<div class="inputOuter">
												<input type="text" id="qq" name="qq" maxlength="10"
													class="inputstyle" style="height:25px;line-height:25px;"/>
											</div>
										</li>
										<li>
											<label for="qq" class="input-tips" style="width:25%;">
												公司&nbsp;
											</label>
											<div class="inputOuter">
												<input type="text" id="companyname" name="company_name" maxlength="100"
													class="inputstyle" style="height:25px;line-height:25px;ime-mode: auto;"/>
											</div>
										</li>
										<li>
											<div class="inputArea">
												<input type="button" id="reg" style="margin-top: 10px; margin-left: 75px;width: 80px;" class="button_blue" value="注册" />
												<input type="reset" value="重置" style="margin-top: 10px; margin-left: 20px;width: 80px;"  class="button_blue" />
											</div>
										</li>
									</ul>
								</form>
							</div>
						</div>
						<!--注册end-->
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<IMG src="images/login_3.png">
				</td>
			</tr>
		</table>
	</body>
</html>