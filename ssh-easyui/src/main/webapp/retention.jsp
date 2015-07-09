<%@ include file="logincheack.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
    	<script src="echars/echarts.js"></script>
    	<script type="text/javascript" src="js/jquery.min.js"></script>
	</head>
	<body>
    <div id="mainMap" style="height:500px;border:0px solid #ccc;padding:10px;"></div>
    <script type="text/javascript">

    $(document).ready(function() {
    	//数据生成路径  
        var url = 'app!retention.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           date_key=response.date_key;
           after_1_list=response.after_1_list;
           after_2_list=response.after_2_list;
           after_3_list=response.after_3_list;
           after_4_list=response.after_4_list;
           after_5_list=response.after_5_list;
           after_6_list=response.after_6_list;
           after_7_list=response.after_7_list;
           after_30_list=response.after_30_list;
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
    		            //'echarts/theme/infographic',
    		            'echarts/chart/line'
    		        ],
    		        function (ec,theme) {
    		        	option = {
    		        			title : {
			        		        text: '用户留存率'
			        		    },
    		        		    tooltip : {
    		        		        trigger: 'axis'
    		        		    },
    		        		    legend: {
    		        		        data:['1天后', '2天后', '3天后', '4天后', '5天后', '6天后', '7天后', '30天后']
    		        		    },
    		        		    toolbox: {
    		        		        show : true,
    		        		        orient : 'vertical',
    	    		                x: 'right',
    	    		                y: 'center',
    		        		        feature : {
    		        		            mark : {show: true},
    		        		            dataView : {show: true, readOnly: false},
    		        		            magicType : {show: true, type: ['line']},
    		        		            restore : {show: true},
    		        		            saveAsImage : {show: true}
    		        		        }
    		        		    },
    		        		    calculable : true,
    		        		    xAxis : [
    		        		        {
    		        		            type : 'category',
    		        		            boundaryGap : false,
    		        		            data : date_key
    		        		        }
    		        		    ],
    		        		    yAxis : [
    		        		        {
    		        		            type : 'value',
    		        		            axisLabel : {
    		        		                formatter: '{value} %'
    		        		            }
    		        		        }
    		        		    ],
    		        		    series : [
    		        		        {
    		        		            name:'1天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_1_list
    		        		        },
    		        		        {
    		        		            name:'2天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_2_list
    		        		        },
    		        		        {
    		        		            name:'3天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_3_list
    		        		        },
    		        		        {
    		        		            name:'4天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_4_list
    		        		        },
    		        		        {
    		        		            name:'5天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_5_list
    		        		        },
    		        		        {
    		        		            name:'6天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_6_list
    		        		        },
    		        		        {
    		        		            name:'7天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_7_list
    		        		        },
    		        		        {
    		        		            name:'30天后',
    		        		            type:'line',
    		        		            //stack: '留存率',
    		        		            data:after_30_list
    		        		        }
    		        		    ]
    		        		};
    		        		                    
    		            // --- 地图 ---
    		            var myChart2 = ec.init(document.getElementById('mainMap'),theme);
    		            myChart2.setOption(option);
    		        }
    		    ); 
    }
    </script>
	</body>
</html>
