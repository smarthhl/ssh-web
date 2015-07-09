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
	       	'echarts/chart/pie',
			'echarts/chart/radar' 
			], 
		function(ec) {
			var myChart = ec.init(document.getElementById('main'));
			myChart.setOption( 
					{
					    title : {
					        text: '动态数据',
					        subtext: '纯属虚构'
					    },
					    tooltip : {
					        trigger: 'item'
					    },
					    legend: {
					        data:['随机数据1','随机数据2','随机数据3','随机数据4','随机数据5']
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    polar : [
					        {
					            indicator : [
					                { text : '指标一' },
					                { text : '指标二' },
					                { text : '指标三' },
					                { text : '指标四' },
					                { text : '指标五' }
					            ],
					            center : [document.getElementById('main').offsetWidth - 250, 225],
					            radius : 100
					        }
					    ],
					    calculable : false,
					    series : [
					        {
					            name:'pie',
					            type:'pie',
					            radius : [0, 110],
					            center: [250, 225],
					            data: (function (){
					                var res = [];
					                var len = 0;
					                while (len++ < 5) {
					                    res.push({
					                        name: '随机数据' + len,
					                        value: Math.round(Math.random()*10)
					                    });
					                }
					                return res;
					            })()
					        },
					        {
					            name: 'radar',
					            type: 'radar',
					            itemStyle: {normal: {areaStyle: {type: 'default'}}},
					            data: (function (){
					                var res = [];
					                var len = 0;
					                while (len++ < 3) {
					                    res.push({
					                        name: 'data' + len,
					                        value: [
					                            Math.round(Math.random()*100),
					                            Math.round(Math.random()*100),
					                            Math.round(Math.random()*100),
					                            Math.round(Math.random()*100),
					                            Math.round(Math.random()*100)
					                        ]
					                    });
					                }
					                return res;
					            })()
					        }
					    ]
					}
			);

		});
	var lastIndex = 5;
	var axisData;
	var timeTicket = self.setInterval("clock()", 2000);
	
	function clock(ec){
		var myChart = ec.init(document.getElementById('main'));
	    lastIndex += 1;
	    // 动态数据接口 addData
	    myChart.addData([
	        [
	            0,        // 系列索引
	            {         // 新增数据
	                name: '随机数据' + lastIndex,
	                value: Math.round(Math.random()*10)
	            }, 
	            false,     // 新增数据是否从队列头部插入
	            false,     // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
	            '随机数据' + lastIndex
	        ],
	        [
	            1,        // 系列索引
	            {         // 新增数据
	                name: 'data' + lastIndex,
	                value: [
	                    Math.round(Math.random()*100),
	                    Math.round(Math.random()*100),
	                    Math.round(Math.random()*100),
	                    Math.round(Math.random()*100),
	                    Math.round(Math.random()*100)
	                ]
	            }, 
	            false,     // 新增数据是否从队列头部插入
	            false      // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
	        ]
	    ]);
	}
</script>
	</body>
</html>
