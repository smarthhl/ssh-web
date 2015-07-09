<%@ include file="logincheack.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head id="Head1">
		<title>投米商务数据平台</title>
		<link rel="shortcut icon" href="images/blocks.png" type="image/x-icon" />
		<link href="css/default.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css"
			href="js/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="js/themes/icon.css" />

		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src='js/outlook.js'></script>
		<script type="text/javascript" src='js/init.js'></script>
		<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
		<script src="echars/echarts.js"></script>
		
		<Style>
#css3menu li {
	float: left;
	list-style-type: none;
}

#css3menu li a {
	color: #fff;
	padding-right: 20px;
}

#css3menu li a.active {
	color: yellow;
}
</style>
<!--  <script type="text/javascript" src="http://www.coding123.net/getip.ashx?js=1"></script>-->
<script type="text/javascript">
	$(function() {
		$('#rwlb').combobox( {
			url : 'app!getApptype',
			valueField : 'id',
			textField : 'text',
			value : "请选择"
		});
		//$('#rwlb').combobox('select', data[0].id);
	});
	//设置登录窗口
	function openPwd() {
		$('#w').window( {
			title : '修改密码',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 160,
			resizable : false
		});
	}
	//关闭登录窗口
	function closePwd() {
		$('#w').window('close');
	}

	//修改密码
	function serverLogin() {
		var $newpass = $('#txtNewPass');
		var $rePass = $('#txtRePass');

		if ($newpass.val() == '') {
			msgShow('系统提示', '请输入密码！', 'warning');
			return false;
		}
		if ($rePass.val() == '') {
			msgShow('系统提示', '请在一次输入密码！', 'warning');
			return false;
		}

		if ($newpass.val() != $rePass.val()) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}

		if ($newpass.val().length > 16) {
			msgShow('系统提示', '密码最多16位！', 'warning');
			return false;
		}
		var user_name="${user_name}";
		//alert(user_name);
		$.post('app!editMM?user_name='+user_name+'&pswd=' + $newpass.val(), function(result) {
			$.messager.show({
                title: '操作信息',
                msg: result.msg
            });
			$newpass.val('');
			$rePass.val('');
			$('#w').window('close');
		},'json')

	}

	$(function() {

		openPwd();

		$('#editpass').click(function() {
			$('#w').window('open');
		});

		$('#demo').click(function() {
			var urline='app!list?uname=demo@creditease.cn&upass=creditease';
			location.href = urline;
			//window.open(urline);
		});
		$('#btnEp').click(function() {
			serverLogin();
		})

		$('#btnCancel').click(function() {
			closePwd();
		})

		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
				if (r) {
					$.post('app!loginout',function(response) {  
				           //sdata=  response;
				           location.href = 'login.jsp';
				    }, "json");  
					
				}
			});
		})
	});
	$(function() {
		//alert();
		var url = 'app!ipCount.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) { 
        	var aaa=document.getElementById("obj"); 
        	//aaa.innerHTML="SDK下载("+response+")";
       	}, "json");
	});
	var url = 'http://chaxun.1616.net/s.php?type=ip&output=json&callback=?&_='+Math.random();  
	var ip;
	var Isp;
	var Browser;
	var OS;
    $.getJSON(url, function(data){
        //alert(data.Ip);  
        ip=data.Ip;
        Isp=data.Isp;
        Browser=data.Browser;
        OS=data.OS;
    });
	function down(){
		$.ajaxSettings.async = false; //同步才能获取数据  
		var url = 'app!downFile.action?ip='+ip+'&os='+OS+'&isp='+Isp+'&browser='+Browser;  
		$.post(url,function(data) { 
			if(data.code==1){
				var aaa=document.getElementById("obj");
				//aaa.innerHTML="SDK下载("+data.msg+")";
			}
       	}, "json"); 
	}
</script>
	</head>
	<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
		<noscript>
			<div
				style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
				<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
			</div>
		</noscript>
		<div region="north" split="true" border="false"
			style="overflow: hidden; height: 50px; background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 40px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
			<span style="float: right; padding-right: 20px;" class="head">欢迎您！
				<!--  <a href="#" id="demo">查看Demo</a> --> <!-- --><a href="download/SDK_V1.1.3.1.rar" id='obj' onclick="down()">SDK下载</a>  <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
			</span>

			<span style="padding-left: 10px; font-size: 16px; float: left;"><img
					src="images/blocks.png" width="32" height="32" align="absmiddle" />
				投米商务数据平台</span>
			<ul id="css3menu"
				style="padding: 0px; margin: 0px; list-type: none; float: left; margin-left: 40px;">
				<li>
					<a class="active" name="basic" href="javascript:;" title="报表统计">报表统计</a>
				</li>
				<!--  
				<li>
					<a name="point" href="javascript:;" title="数据平台">数据平台</a>
				</li>
				<li>
					<a name="platManage" href="javascript:;" title="平台管理">平台管理</a>
				</li>-->
			</ul>
		</div>
	<div data-options="region:'south',border:false,split:false"
			style="height: 20px;overflow: hidden;">
			<div align="center" style="height:20px;line-height:20px;background: #f2f2f2;">
				<p style="margin-top: 0px;">Copyright 2009 by Creditease Corp.All Right Reserved. 京ICP备11022285号-3 版权所有 普信恒业科技发展（北京）有限公司</p> 
			</div>
		</div>
		<div region="west" hide="true" split="true" title="投米商务"
			style="width: 180px;" id="west">
			<div id='wnav' class="easyui-accordion" fit="true" border="false">
				<!--  导航内容 -->
			</div>
		</div>
		<div id="mainPanle" region="center"
			style="background: #eee; overflow-y: hidden">
			<!--  <input type="text" name="sessionName" value="${uname}"/>-->
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
				<!--<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
					<div style="margin: 20px 0;"></div>
					 <input class="easyui-combobox" id="rwlb" name="rwlb" style="width:435px" data-options="valueField:'id', textField:'text', panelHeight:'auto'" >  
					<input class="easyui-datebox"></input>
					<div id="mainMap"
						style="height: 500px; border: 1px solid #ccc; padding: 10px;"></div>
						<style>
						.fangkuai{display:inline-block;height:auto;padding:15px;float:left;width:21%;margin:8px;background:#fff;border:1px solid #ccc;}
						.fangkuai:hover{background:#eee;}
						.fangkuai dt{display:inline-block;width:30%;height:auto;float:left;}
						.fangkuai dd{display:inline-block;width:52%;height:auto;float:right;}
						.fangkuai dd strong{display:block;height:auto;overflow:hidden;color:#000;font-size:14px;}
						</style>
						<dl class="fangkuai">
						   <dt><img src="http://kaoqin.creditease.corp/home/images/icon01.png" title="事前申请"/></dt>
						   <dd>
						      <strong>事前申请</strong>
						      <font>事前申请外出或者休假<br/>填写因公外出事由<br/>或者选择休假类型</font>
						   </dd>
						</dl>
						<dl class="fangkuai">
						   <dt><img src="http://kaoqin.creditease.corp/home/images/icon01.png" title="事前申请"/></dt>
						   <dd>
						      <strong>事前申请</strong>
						      <font>事前申请外出或者休假<br/>填写因公外出事由<br/>或者选择休假类型</font>
						   </dd>
						</dl>
						<dl class="fangkuai">
						   <dt><img src="http://kaoqin.creditease.corp/home/images/icon01.png" title="事前申请"/></dt>
						   <dd>
						      <strong>事前申请</strong>
						      <font>事前申请外出或者休假<br/>填写因公外出事由<br/>或者选择休假类型</font>
						   </dd>
						</dl>
						<dl class="fangkuai">
						   <dt><img src="http://kaoqin.creditease.corp/home/images/icon01.png" title="事前申请"/></dt>
						   <dd>
						      <strong>事前申请</strong>
						      <font>事前申请外出或者休假<br/>填写因公外出事由<br/>或者选择休假类型</font>
						   </dd>
						</dl>
				</div>-->
			</div>
		</div>
		<!--修改密码窗口-->
		<div id="w" class="easyui-window" title="修改密码" collapsible="false"
			minimizable="false" maximizable="false" icon="icon-save"
			style="width: 500px; height: 350px; padding: 5px; background: #fafafa;">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false"
					style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<table cellpadding=3>
						<tr>
							<td>
								新密码：
							</td>
							<td>
								<input id="txtNewPass" type="password" class="txt01" />
							</td>
						</tr>
						<tr>
							<td>
								确认密码：
							</td>
							<td>
								<input id="txtRePass" type="password" class="txt01" />
							</td>
						</tr>
					</table>
				</div>
				<div region="south" border="false"
					style="text-align: right; height: 30px; line-height: 30px;">
					<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
						href="javascript:void(0)"> 确定</a>
					<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel"
						href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>

		<div id="mm" class="easyui-menu" style="width: 150px;">
			<div id="mm-tabupdate">
				刷新
			</div>
			<div class="menu-sep"></div>
			<div id="mm-tabclose">
				关闭
			</div>
			<div id="mm-tabcloseall">
				全部关闭
			</div>
			<div id="mm-tabcloseother">
				除此之外全部关闭
			</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">
				当前页右侧全部关闭
			</div>
			<div id="mm-tabcloseleft">
				当前页左侧全部关闭
			</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">
				退出
			</div>
		</div>
<script type="text/javascript">
    $(document).ready(function() {

    	/***/ var tabTitle = "整体趋势";

		var url = "appStatistics.jsp";
		var menuid = "127";
		var icon = "icon-ztqs";
		var icon1 = getIcon(menuid, icon);
    	addTab(tabTitle, url, icon1);       
    	//数据生成路径  
        var url = 'app!redLocation.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           sdata=  response;
       	}, "json");  
        EconfigAPI(url); 
	}); 

    /**
     * 构建动态图表
     * @param url   获取后台数据地址
     * @param time  图表查询时间
     * @param elem  加载容器
     */
    function EconfigAPI(url){
    	require.config({
            paths: {
                echarts: './echars'
            }
        });
    	 require(
    		        [
    		            'echarts',
    		            'echarts/theme/infographic',
    		            'echarts/chart/bar',
    		            'echarts/chart/map'
    		        ],
    		        function (ec,theme) {
    		            // --- 地图 ---
    		            var myChart2 = ec.init(document.getElementById('mainMap'),theme);
    		            myChart2.setOption({
    		            	title : {
    		                text: '启动次数分布图',
    		                x:'center'
    		            },
    		            tooltip : {
    		                trigger: 'item'
    		            },
    		            legend: {
    		                orient: 'vertical',
    		                x:'left',
    		                data:['启动情况']
    		            },
    		            dataRange: {
    		                min: 0,
    		                max: 500,
    		                x: 'left',
    		                y: 'bottom',
    		                text:['高','低'],           // 文本，默认为数值文本
    		                calculable : true
    		            },
    		            toolbox: {
    		                show: true,
    		                orient : 'vertical',
    		                x: 'right',
    		                y: 'center',
    		                feature : {
    		                    mark : {show: true},
    		                    dataView : {show: true, readOnly: false},
    		                    restore : {show: true},
    		                    saveAsImage : {show: true}
    		                }
    		            },
    		            roamController: {
    		                show: true,
    		                x: 'right',
    		                handleColor : '#FFCC00',
    		                mapTypeControl: {
    		                    'china': true
    		                }
    		            },
    		                series :  [
    		                           {
    		                               name: 'App安装数量',
    		                               type: 'map',
    		                               mapType: 'china',
    		                               roam: false,
    		                               itemStyle:{
    		                                   normal:{label:{show:true}},
    		                                   emphasis:{label:{show:true}}
    		                               },
    		                               data:sdata
    		                           }
    		                       ]
    		            });
    		        }
    		    ); 
    }
</script>
</body>
</html>
