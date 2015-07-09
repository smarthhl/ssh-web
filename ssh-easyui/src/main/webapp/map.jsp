<%@ include file="logincheack.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<script type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
	</head>
<body>
	<div style="height: 30px" align="right">
		<label style="font-size: 13px;">应用名称&nbsp;&nbsp;</label><input name="app_key" id="app_key" style="width: 100px;" class="easyui-combobox" required="true">	
	<input  id="beginDate" name="beginDate"  class="Wdate1" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01\'}'})"/>
	-
<input id="endDate" class="Wdate1" type="text" name="endDate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}',maxDate:'2020-10-01'})"/>
	
	<a href="javascript:query();" class="easyui-linkbutton" iconCls="icon-search" plain="false">查 询</a>
	</div>
	<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
	<!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
	<div id="mainMap"
		style="height: 500px; border: 0px solid #ccc; padding: 10px;"></div>
	<script type="text/javascript">
	$(function(){

    	$('#app_key').combobox({
    		url:'app!getAppByUser',
    		valueField:'id',
    		textField:'text',
    		value:"请选择"
    	});
    	//$('#rwlb').combobox('select', data[0].id);
    });
    
    function query(){
    	//数据生成路径 
    	var beginDate=$('#beginDate').val();
    	var endDate=$('#endDate').val();
    	var app_key=$('#app_key').combobox('getValue');
        var url = 'app!redLocation.action?beginDate='+beginDate+'&endDate='+endDate+'&app_key='+app_key;
        url=encodeURI(url);
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url, function(response) {
        	sdata = response.data;
			max=response.max;
			max=parseInt(max);
		}, "json");
		EconfigAPI(url);  
    }

    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    $(document).ready(function() {
    	//数据生成路径  
        var url = 'app!redLocation.action';
			$.ajaxSettings.async = false; //同步才能获取数据  
			$.post(url, function(response) {
				sdata = response.data;
				max=response.max;
				max=parseInt(max);
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
			//'echarts/theme/macarons',
			'echarts/chart/bar', 'echarts/chart/map' ], function(ec, theme) {
				// --- 地图 ---
				var myChart2 = ec.init(document.getElementById('mainMap'),
						theme);
				myChart2.setOption({
					title : {
						text : '启动次数分布图',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					legend : {
						orient : 'vertical',
						x : 'left',
						data : [ '启动情况' ]
					},
					dataRange : {
						min : 0,
						max : max,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : true
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
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : '启动次数',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : sdata
					} ]
				});
			});
		}
	</script>
</body>
</html>
