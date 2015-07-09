<%@ include file="logincheack.jsp" %>
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
		<base href="<%=basePath%>">
		<!--Step:2 Import echarts.js-->
		<!--Step:2 引入echarts.js-->
		<script src="echars/echarts.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
	</head>
	<body>
		<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
		<!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
		<div id="main"
			style="height: 500px; border: 1px solid #ccc; padding: 10px;"></div>
		<script type="text/javascript">
	// Step:3 conifg ECharts's path, link to echarts.js from current page.
	// Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
	require.config( {
		paths : {
			echarts : './echars'
		}
	});

	// Step:4 require echarts and use it in the callback.
	// Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
	require( [ 'echarts', 
	       	'echarts/chart/bar', 
	       	'echarts/chart/line',
			'echarts/chart/pie' 
			], 
	function(ec) {
			var myChart = ec.init(document.getElementById('main'));
			myChart.setOption(
					{
					    tooltip : {
					        trigger: 'axis'
					    },
					    toolbox: {
					        show : true,
					        y: 'bottom',
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    legend: {
					        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎','百度','谷歌','必应','其他']
					    },
					    xAxis : [
					        {
					            type : 'category',
					            splitLine : {show : false},
					            data : ['周一','周三','周二','周四','周五','周六','周日']
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value',
					            position: 'right'
					        }
					    ],
					    series : [
					        {
					            name:'直接访问',
					            type:'bar',
					            data:[320, 332, 301, 334, 390, 330, 320]
					        },
					        {
					            name:'邮件营销',
					            type:'bar',
					            tooltip : {trigger: 'item'},
					            stack: '广告',
					            data:[120, 132, 101, 134, 90, 230, 210]
					        },
					        {
					            name:'联盟广告',
					            type:'bar',
					            tooltip : {trigger: 'item'},
					            stack: '广告',
					            data:[220, 182, 191, 234, 290, 330, 310]
					        },
					        {
					            name:'视频广告',
					            type:'bar',
					            tooltip : {trigger: 'item'},
					            stack: '广告',
					            data:[150, 232, 201, 154, 190, 330, 410]
					        },
					        {
					            name:'搜索引擎',
					            type:'line',
					            data:[862, 1018, 964, 1026, 1679, 1600, 1570]
					        },

					        {
					            name:'搜索引擎细分',
					            type:'pie',
					            tooltip : {
					                trigger: 'item',
					                formatter: '{a} <br/>{b} : {c} ({d}%)'
					            },
					            center: [160,130],
					            radius : [0, 50],
					            itemStyle :　{
					                normal : {
					                    labelLine : {
					                        length : 20
					                    }
					                }
					            },
					            data:[
					                {value:1048, name:'百度'},
					                {value:251, name:'谷歌'},
					                {value:147, name:'必应'},
					                {value:102, name:'其他'}
					            ]
					        }
					    ]
					}
			);

		});
</script>
	</body>
</html>
