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
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/themes/icon.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="js/tips.js"></script>

<script src="echars/echarts.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</head>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
<body class="easyui-layout">
<div region="center" style="padding:5px;" border="false"> 
	<div>
		<div style="height: 30px" align="right">
			<label style="font-size: 13px;">应用名称&nbsp;&nbsp;</label> <input
				name="app_key" id="app_key" style="width: 100px;"
				class="easyui-combobox" required="true" editable="false"> <label
				style="font-size: 13px;" >客户端&nbsp;&nbsp;</label><input name="os"
				id="os" style="width: 100px;" class="easyui-combobox"
				required="true" editable="false"> <label
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

	<table id="dg" class="easyui-datagrid" style="height:520px"
		url="app!evnEffectPage?rptFlag=dailyRpt" toolbar="#toolbar" pagination="true"
		rownumbers="true" fitColumns="true" singleSelect="true" align="center">
		<thead>
			<tr>
				<th field="date_key" width="40">日期</th>
				<th field="curr_act_cnt" width="40">激活用户数</th>
				<th field="curr_reg_cnt" width="40">注册成功人次</th>
				<th field="curr_log_cnt" width="40">登录成功人次</th>
				<th field="curr_auth_cnt" width="40">认证成功人次</th>
				<th field="curr_bind_cnt" width="40">绑卡成功人次</th>
				<th field="curr_po_cnt" width="40">下单总数</th>
				<th field="curr_trad_cnt" width="40">交易成功数</th>
				<th field="curr_trad_amt" width="40">交易金额</th>
			</tr>
		</thead>
	</table>
</div>
	<script type="text/javascript">
		function query() {
			var queryParams = $('#dg').datagrid('options').queryParams;
			queryParams.beginDate = $('#beginDate').val();
			queryParams.os = $('#os').combobox('getValue');
			queryParams.endDate = $('#endDate').val();
			queryParams.app_chnl_key = $('#app_chnl_key').combobox('getValue');
			queryParams.app_chnl_sub = $('#app_chnl_sub').combobox('getValue');
			queryParams.app_key = $('#app_key').combobox('getValue');
			//alert($('#app_key').combobox('getValue'))
			$('#dg').datagrid('reload');
		}

		function chgChnlVal(){
			$('#app_chnl_sub').combobox({
				url : 'app!getChannelSub?app_chnl_key='+$('#app_chnl_key').combobox('getValue'),
				valueField : 'id',
				textField : 'text'
			});
		}
		$(function() {

			$('#app_key').combobox({
				url : 'app!getAppByUser',
				valueField : 'id',
				textField : 'text'
			});
			$('#os').combobox({
				url : 'js/json/os.json',
				valueField : 'id',
				textField : 'text'
			});
			$('#app_chnl_key').combobox({
				url : 'app!getChannel',
				valueField : 'id',
				textField : 'text',
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
	</script>
</body>
</html>
