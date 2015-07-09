<%@ include file="logincheack.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>宜信数据管理平台</title>
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
		<!--  
      <p><span class="highlight">1天留存率：</span>第一次启动后的第1天，再次启动应用的独立用户数占比</p>
      <p><span class="highlight">7天留存率：</span>第一次启动后的第7天，再次启动应用的独立用户数占比</p>
      <p><span class="highlight">30天留存率：</span>第一次启动后的第30天，再次启动应用的独立用户数占比</p>-->
		<p>
			<span class="highlight">N天留存率：</span>第一次启动后的第N天，再次启动应用的独立用户数占比
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
				class="easyui-combobox" required="true" /> <label
				style="font-size: 13px;">渠道&nbsp;&nbsp;</label><input
				name="app_chnl_key" id="app_chnl_key" style="width: 100px;"
				class="easyui-combobox" required="true" editable="false">
				<label
				style="font-size: 13px;">子渠道&nbsp;&nbsp;</label>
				<input
				name="app_chnl_sub" id="app_chnl_sub" style="width: 100px;"
				class="easyui-combobox" required="true" editable="false">
				<input id="beginDate"
				name="beginDate" class="Wdate1" type="text"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01\'}'})" />
			- <input id="endDate" class="Wdate1" type="text" name="endDate"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}',maxDate:'2020-10-01'})" />
			<a href="javascript:query();" class="easyui-linkbutton"
				iconCls="icon-search" plain="false">查 询</a>
		</div>
	</div>

	<div id="mainMap"
		style="height: 400px; border: 0px solid #ccc; padding: 10px;"></div>
	<table id="dg" class="easyui-datagrid" style="height: 308px;"
		url="app!retentionPage" rownumbers="true" fitColumns="true" pagination="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="user_id" hidden="true" sortable="true">主键</th>
				<th field="date_key" width="50">日期</th>
				<th field="new_user_cnt" width="50">新增用户数</th>
				<th field="day1" width="50" formatter='optFormater'>1天留存率</th>
				<th field="day2" width="50" formatter='optFormater'>2天留存率</th>
				<th field="day3" width="50" formatter='optFormater'>3天留存率</th>
				<th field="day4" width="50" formatter='optFormater'>4天留存率</th>
				<th field="day5" width="50" formatter='optFormater'>5天留存率</th>
				<th field="day6" width="50" formatter='optFormater'>6天留存率</th>
				<th field="day7" width="50" formatter='optFormater'>7天留存率</th>
				<th field="day30" width="50" formatter='optFormater'>30天留存率</th>
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
		function query() {
			var url = 'app!retention.action?beginDate=' 
					+ $('#beginDate').val()
					+ '&endDate=' + $('#endDate').val() 
					+ '&app_key='+ $('#app_key').combobox('getValue')
					+ '&app_chnl_key='+$('#app_chnl_key').combobox('getValue')
					+ '&app_chnl_sub='+$('#app_chnl_sub').combobox('getValue');
			url = encodeURI(url);
			$.ajaxSettings.async = false; //同步才能获取数据  
			$.post(url, function(response) {
				date_key = response.date_key;
				after_1_list = response.after_1_list;
				after_2_list = response.after_2_list;
				after_3_list = response.after_3_list;
				after_4_list = response.after_4_list;
				after_5_list = response.after_5_list;
				after_6_list = response.after_6_list;
				after_7_list = response.after_7_list;
				after_30_list = response.after_30_list;
			}, "json");
			EconfigAPI(url);

			var queryParams = $('#dg').datagrid('options').queryParams;
			queryParams.beginDate = $('#beginDate').val();
			queryParams.endDate = $('#endDate').val();
			queryParams.app_key = $('#app_key').combobox('getValue');
			queryParams.app_chnl_key = $('#app_chnl_key').combobox('getValue');
			queryParams.app_chnl_sub = $('#app_chnl_sub').combobox('getValue');
			$('#dg').datagrid('reload');
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
			var url = 'app!retention.action';
			$.ajaxSettings.async = false; //同步才能获取数据  
			$.post(url, function(response) {
				date_key = response.date_key;
				after_1_list = response.after_1_list;
				after_2_list = response.after_2_list;
				after_3_list = response.after_3_list;
				after_4_list = response.after_4_list;
				after_5_list = response.after_5_list;
				after_6_list = response.after_6_list;
				after_7_list = response.after_7_list;
				after_30_list = response.after_30_list;
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
			require([ 'echarts',
			//'echarts/theme/infographic',
			'echarts/chart/line' ], function(ec, theme) {
				option = {
					title : {
						text : '用户留存率'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '1天', '2天', '3天', '4天', '5天', '6天', '7天',
								'30天' ]
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
								type : [ 'line' ]
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
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : date_key
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} %'
						}
					} ],
					series : [ {
						name : '1天',
						type : 'line',
						//stack: '留存率',
						data : after_1_list
					}, {
						name : '2天',
						type : 'line',
						//stack: '留存率',
						data : after_2_list
					}, {
						name : '3天',
						type : 'line',
						//stack: '留存率',
						data : after_3_list
					}, {
						name : '4天',
						type : 'line',
						//stack: '留存率',
						data : after_4_list
					}, {
						name : '5天',
						type : 'line',
						//stack: '留存率',
						data : after_5_list
					}, {
						name : '6天',
						type : 'line',
						//stack: '留存率',
						data : after_6_list
					}, {
						name : '7天',
						type : 'line',
						//stack: '留存率',
						data : after_7_list
					}, {
						name : '30天',
						type : 'line',
						//stack: '留存率',
						data : after_30_list
					} ]
				};

				// --- 地图 ---
				var myChart2 = ec.init(document.getElementById('mainMap'),
						theme);
				myChart2.setOption(option);
			});
		}
	</script>
</body>
</html>
