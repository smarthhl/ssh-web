<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <div id="main" class="main" style='height:500px;width:40%;float:left;margin-right:0;padding-right:0;border-right-width:0'></div>
    <div id="main2" class="main" style='height:500px;width:55%;margin-left:0;padding-left:0;border-left-width:0'></div>
    <script type="text/javascript">

    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    $(document).ready(function() {
    	//数据生成路径  
        var url = '<%=basePath%>app!redLocation.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           data=  response;
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
    		            'echarts/chart/bar',
    		            'echarts/chart/line',
    		            'echarts/chart/pie'
    		        ],
    		        function (ec,theme) {

    		           	option = {
    		                    title : {
    		                        text: '某站点用户访问来源',
    		                        subtext: '纯属虚构',
    		                        x:'center'
    		                    },
    		                    tooltip : {
    		                        trigger: 'item',
    		                        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		                    },
    		                    legend: {
    		                        orient : 'vertical',
    		                        x : 'left',
    		                        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    		                    },
    		                    calculable : true,
    		                    series : [
    		                        {
    		                            name:'访问来源',
    		                            type:'pie',
    		                            radius : '55%',
    		                            center: ['50%', 225],
    		                            data:[
    		                                {value:335, name:'直接访问'},
    		                                {value:310, name:'邮件营销'},
    		                                {value:234, name:'联盟广告'},
    		                                {value:135, name:'视频广告'},
    		                                {value:1548, name:'搜索引擎'}
    		                            ]
    		                        }
    		                    ]
    		                };
    		            	option2 = {
    		            	    tooltip : {
    		            	        trigger: 'axis'
    		            	    },
    		            	    toolbox: {
    		            	        show : true,
    		            	        orient : 'vertical',
    		            	        y : 'center',
    		            	        feature : {
    		            	            mark : {show: true},
    		            	            dataView : {show: true, readOnly: false},
    		            	            magicType : {show: true, type: ['line', 'bar']},
    		            	            restore : {show: true},
    		            	            saveAsImage : {show: true}
    		            	        }
    		            	    },
    		            	    calculable : true,
    		            	    xAxis : [
    		            	        {
    		            	            type : 'category',
    		            	            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    		            	        }
    		            	    ],
    		            	    yAxis : [
    		            	        {
    		            	            type : 'value'
    		            	        }
    		            	    ],
    		            	    series : [
    		            	        {
    		            	            name:'用户数',
    		            	            type:'bar',
    		            	            data:[2.0, 4.9, 7.0, 23.2, 25.6],
    		            	            markPoint : {
    		            	                data : [
    		            	                    {type : 'max', name: '最大值'},
    		            	                    {type : 'min', name: '最小值'}
    		            	                ]
    		            	            },
    		            	            markLine : {
    		            	                data : [
    		            	                    {type : 'average', name: '平均值'}
    		            	                ]
    		            	            }
    		            	        }
    		            	    ]
    		            	}

    		                var myChart = ec.init(document.getElementById('main'),theme);
        		            var myChart2 = ec.init(document.getElementById('main2'),theme);
        		            myChart.setOption(option);
        		            myChart2.setOption(option2);
        		            myChart.connect(myChart2);
        		            myChart2.connect(myChart);
    		            	
    		        }
    		    ); 
    }

    </script>
	</body>
</html>
