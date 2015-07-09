<%@ include file="logincheack.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>宜信数据管理平台</title>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link rel="stylesheet" type="text/css"
	href="js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
<!-- 帮助样式 -->
<link rel="stylesheet" type="text/css" href="css/tips.css" />
<script type="text/javascript" src="js/tips.js"></script>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>

<script src="echars/echarts.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="tip_todayData" class="tips">
		<div class="corner"></div>
		<p>
			<span class="highlight">累计用户数：</span>截止到某一天，启动过应用的的独立用户数（按设备去重）
		</p>
		<p>
			<span class="highlight">30天活跃用户数：</span>截止到某一天，过去30天内启动过应用的独立用户数（启动一次就算是活跃，包括第一次启动）
		</p>
		<p>
			<span class="highlight">新增用户数：</span>第一次启动应用的独立用户数
		</p>
		<p>
			<span class="highlight">活跃用户数：</span>启动过应用的独立用户数
		</p>
		<p>
			<span class="highlight">1-7天前新增用户：</span>第一次启动应用在1-7天前的用户，在当天启动的独立用户数
		</p>
		<p>
			<span class="highlight">8-30天前新增用户：</span>第一次启动应用在8-30天前的用户，在当天启动的独立用户数
		</p>
		<p>
			<span class="highlight">30+天前新增用户：</span>第一次启动应用在30天前的用户，在当天启动的独立用户数
		</p>
		<p>
			<span class="highlight">当天新用户占比：</span>当天新增用户数/当天活跃用户数
		</p>
		<p>
			<span class="highlight">启动次数：</span>打开应用的次数
		</p>
		<p>
			<span class="highlight">平均使用时长：</span>平均每次启动应用到退出的时长（退出包括完全退出及退至后台）
		</p>
		<p>
			<span class="highlight">错误数：</span>当日设备报错的次数，不去重，同一用户多次报错视为多次
		</p>
		<p>
			<span class="highlight">错误率：</span>当日错误数/当日启动次数
		</p>
	</div>
	<div>
		<div style="height: 30px; float: left">
			<button onmouseover="javascript:divDis();"
				onMouseOut="javascript:divNone();" class="help"></button>
		</div>

		<div style="height: 30px" align="right">
			<label style="font-size: 13px;">应用名称&nbsp;&nbsp;</label><input
				name="app_key" id="app_key" style="width: 100px;"
				class="easyui-combobox" required="true"> <label
				style="font-size: 13px;">渠道&nbsp;&nbsp;</label><input
				name="app_chnl_key" id="app_chnl_key" style="width: 100px;"
				class="easyui-combobox" required="true" editable="false">
				<label
				style="font-size: 13px;">子渠道&nbsp;&nbsp;</label>
				<input
				name="app_chnl_sub" id="app_chnl_sub" style="width: 100px;"
				class="easyui-combobox" required="true" editable="false">
				<input
				id="beginDate" name="beginDate" class="Wdate1" type="text"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01\'}'})" />
			- <input id="endDate" class="Wdate1" type="text" name="endDate"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}',maxDate:'2020-10-01'})" />
			<a href="javascript:query();" class="easyui-linkbutton"
				iconCls="icon-search" plain="false">查 询</a>
		</div>
	</div>

	<div align="center"
		style="height: 40px; font-size: 16px; font-weight: bold; font-family: 微软雅黑">用户统计分析</div>
	<table id="dg1" class="easyui-datagrid" style="height: 52px;"
		url="app!appStatisticsPage1" fitColumns="true" singleSelect="true">
		<thead>
			<tr>

				<th field="accu_user_cnt" width="50" >累计用户数</th>
				<th field="act_user_cnt_30" width="50" >30天活跃用户数</th>
				<th field="new_user_cnt" width="50" >当天新增用户数</th>
				<th field="act_user_cnt" width="50" >当天活跃用户数</th>
				<!--  
                <th field="date_key" width="50">日期</th>
                <th field="new_user_rate" width="50">新用户占比（%）</th>
                <th field="exception_cnt" width="50">错误数</th>
                -->
				<th field="open_cnt" width="50" >当天启动次数</th>
				<th field="avg_duration" width="50" formatter='optFormater1'>平均使用时长</th>
				<th field="except_rate" width="50" formatter='optFormater'>错误率</th>
			</tr>
		</thead>
	</table>
	<div id="mainMap"
		style="height: 400px; border: 0px solid #ccc; padding: 10px;"></div>
	<!-- -->
	<table id="dg" class="easyui-datagrid" style="height: 308px;"
		url="app!appStatisticsPage" rownumbers="true" fitColumns="true" pagination="true"
		singleSelect="true">
		<thead>
			<tr>
				<!-- <th field="date_key" width="50" align="left" halign="center" >日期</th> -->
				<th field="date_key" width="50">日期</th>
				<th field="accu_user_cnt" width="50" >累计用户数</th>
				<th field="act_user_cnt_30" width="50" >30天活跃用户数</th>
				<th field="new_user_cnt" width="50" >新增用户数</th>
				<th field="act_user_cnt" width="50" >活跃用户数</th>
				<th field="new_user_rate" width="50" formatter='optFormater'>新用户占比</th>
				<th field="open_cnt" width="50" >启动次数</th>
				<th field="avg_duration" width="50" formatter='optFormater1'>平均使用时长</th>
				<th field="exception_cnt" width="50" >错误数</th>
				<th field="except_rate" width="50" formatter='optFormater'>错误率</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		function chgChnlVal(){
			$('#app_chnl_sub').combobox({
				url : 'app!getChannelSub?app_chnl_key='+$('#app_chnl_key').combobox('getValue'),
				valueField : 'id',
				textField : 'text'
			});
		}
		function optFormater(value, row, index) {
			return value + "%";
		}
		function numFormat(value, row, index) {
			var t = (parseInt(value).toFixed(0) + '').replace(
					/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
			return t;
		}
		function optFormater1(value, row, index) {
			return Math.round(value) + "s";
		}
		function query() {
			var url = 'app!appStatistics?beginDate=' + $('#beginDate').val()
					+ '&endDate=' + $('#endDate').val() + '&app_key='
					+ $('#app_key').combobox('getValue')+'&app_chnl_key='+$('#app_chnl_key').combobox('getValue')
					+'&app_chnl_sub='+$('#app_chnl_sub').combobox('getValue');
			url = encodeURI(url);
			$.ajaxSettings.async = false; //同步才能获取数据  
			$.post(url, function(response) {
				date_key = response.date_key;
				user_cnt_30_ = response.user_cnt_30_;
				user_cnt_8_30 = response.user_cnt_8_30;
				user_cnt_1_7 = response.user_cnt_1_7;
				user_cnt_0 = response.user_cnt_0;
				radio = response.radio;
			}, "json");
			EconfigAPI(url);

			var queryParams = $('#dg').datagrid('options').queryParams;
			queryParams.beginDate = $('#beginDate').val();
			queryParams.endDate = $('#endDate').val();
			queryParams.app_key = $('#app_key').combobox('getValue');
			queryParams.app_chnl_key = $('#app_chnl_key').combobox('getValue');
			queryParams.app_chnl_sub = $('#app_chnl_sub').combobox('getValue');
			//alert($('#app_key').combobox('getValue'))
			$('#dg').datagrid('reload');

			var queryParams = $('#dg1').datagrid('options').queryParams;
			queryParams.beginDate = $('#beginDate').val();
			queryParams.endDate = $('#endDate').val();
			queryParams.app_key = $('#app_key').combobox('getValue');
			queryParams.app_chnl_key = $('#app_chnl_key').combobox('getValue');
			queryParams.app_chnl_sub = $('#app_chnl_sub').combobox('getValue');
			//alert($('#app_key').combobox('getValue'))
			$('#dg1').datagrid('reload');
		}

		$(function() {

			$('#app_key').combobox({
				url : 'app!getAppByUser',
				valueField : 'id',
				textField : 'text',
				value : "请选择"
			});
			$('#app_chnl_key').combobox({
				url : 'app!getChannel',
				valueField : 'id',
				textField : 'text',
				value : "请选择",
				onSelect:function(){  
					chgChnlVal();
                }
			});
			$('#app_chnl_sub').combobox({
				url : 'app!getChannelSub?app_chnl_key='+$('#app_chnl_key').combobox('getValue'),
				valueField : 'id',
				textField : 'text',
				value : "请选择"
			});
			//$('#rwlb').combobox('select', data[0].id);
		});
		$(document).ready(function() {

			//数据生成路径  
			//var url = 'app!appStatistics';  
			var url = 'app!appStatistics';
			$.ajaxSettings.async = false; //同步才能获取数据  
			$.post(url, function(response) {
				date_key = response.date_key;
				user_cnt_30_ = response.user_cnt_30_;
				user_cnt_8_30 = response.user_cnt_8_30;
				user_cnt_1_7 = response.user_cnt_1_7;
				user_cnt_0 = response.user_cnt_0;
				radio = response.radio;
			}, "json");
			EconfigAPI(url);
		});

		/**
		 * 构建动态图表
		 * @param url   获取后台数据地址
		 * @param time  图表查询时间
		 * @param elem  加载容器
		 */
		function EconfigAPI(url) {
			require.config({
				paths : {
					echarts : './echars'
				}
			});
			require([ 'echarts', 'echarts/theme/infographic',
					'echarts/chart/line', 'echarts/chart/bar' ], function(ec,
					theme) {
				option = {
					title : {
						text : '活跃用户数',
						//x:'center',
						//y:'center',
						textStyle : {
							fontSize : 16,
							fontWeight : 'bolder',
							color : '#333'
						}
					},
					tooltip : {
						trigger : 'axis'
					},
					toolbox : {
						show : true,
						orient : 'vertical',
						x : 'right',
						y : 'center',
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar', 'stack', 'tiled' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					legend : {
						//padding:35,
						data : [ '当天新增用户', '1-7天前新增用户', '8-30天前新增用户',
								'30+天前新增用户', '当天新用户占比' ]
					},
					xAxis : [ {
						type : 'category',
						data : date_key
					} ],
					yAxis : [ {
						type : 'value',
						name : '活跃用户'
					}, {
						type : 'value',
						name : '新用户占比',
						axisLabel : {
							formatter : '{value} %'
						}
					} ],
					series : [

					 {
						name : '30+天前新增用户',
						type : 'bar',
						stack : '活跃用户',
						data : user_cnt_30_
					},{
						name : '8-30天前新增用户',
						type : 'bar',
						stack : '活跃用户',
						data : user_cnt_8_30
					},{
						name : '1-7天前新增用户',
						type : 'bar',
						stack : '活跃用户',
						data : user_cnt_1_7
					}, {
						name : '当天新增用户',
						type : 'bar',
						stack : '活跃用户',
						data : user_cnt_0
					},{
						name : '当天新用户占比',
						type : 'line',
						yAxisIndex : 1,
						data : radio
					} ]
				};

				var myChart2 = ec.init(document.getElementById('mainMap'),
						theme);
				myChart2.setOption(option);
			});
		}
	</script>
</body>
</html>
