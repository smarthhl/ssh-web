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
    <div id="mainMap" style="height:500px;border:0px solid #ccc;padding:10px;"></div>
    <script type="text/javascript">

    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    $(document).ready(function() {
    	//数据生成路径  
        var url = '<%=basePath%>app!usageDur.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           data=  response.duration;
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
    		            'echarts/theme/macarons',
    		            'echarts/chart/scatter'
    		        ],
    		        function (ec,theme) {
    		            // --- 地图 ---
    		            option = {
    title : {
        text: '用户参与度分布图',
        x:'center'
    },
    tooltip : {
        trigger: 'axis'
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataZoom : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'category',
            data:[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23],//小时
            axisLabel : {
                formatter: '{value} h'
            }
            
        }
    ],
    yAxis : [
        {
        	type : 'category',
            data:['1-3秒','4-10秒','11-30秒','31-60秒','1-3分','3-10分','10-30分','30分~','others']//时间区间
            
        }
    ],
    series : [
        {
            type:'scatter',
            tooltip : {
                trigger: 'item',
                formatter : function (params) {
                    return params.value[0] +"点到"+(params.value[0]+1)+"点，登录时长为"+params.value[1]+"的<br>总计用户量 : "+ params.value[2]; 
                },
                axisPointer:{
                    type: 'none',
                    show: false
                }
            },
            symbolSize: function (value){
            	return Math.round(value[2] / 400);
        	},
            data: [[1,'1-3秒',2000],[3,'31-60秒',2300],[5,'11-30秒',800],[11,'4-10秒',400],[7,'3-10分',10000],[7,'30分~',10000],[12,'30分~',2000],
            [4,'1-3秒',2000],[6,'31-60秒',2300],[23,'11-30秒',800],[21,'4-10秒',400],[8,'3-10分',10000],[17,'30分~',10000],[19,'30分~',2000],
            [22,'1-3秒',2000],[14,'31-60秒',2300],[15,'11-30秒',800],[16,'4-10秒',400],[17,'3-10分',10000],[0,'30分~',10000],[20,'30分~',2000],
            [10,'1-3秒',2000],[11,'31-60秒',2300],[12,'11-30秒',800],[12,'4-10秒',400],[16,'3-10分',12000],[15,'30分~',10000],[2,'30分~',2000],
            [10,'1-3秒',1000],[11,'31-60秒',1300],[12,'11-30秒',1800],[12,'4-10秒',1400],[16,'3-10分',2000],[15,'30分~',8000],[2,'30分~',9000]
           ]//数据[小时,区间,值]
        }
    ]
};
   
    		            var myChart2 = ec.init(document.getElementById('mainMap'),theme);
    		            myChart2.setOption(option);
    		        }
    		    ); 
    }
    </script>
	</body>
</html>
