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
		<!--Step:2 Import echarts.js-->
    	<!--Step:2 引入echarts.js-->
    	<script src="echars/echarts.js"></script>
    	<script type="text/javascript" src="js/jquery.min.js"></script>
	</head>
	<body class="easyui-layout">
	<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
    
    <div id="mainMap" style="height:500px;border:0px solid #ccc;padding:10px;"></div>
    <script type="text/javascript">

    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    $(document).ready(function() {
    	//数据生成路径  
        var url = '<%=basePath%>app!appStatistics.action';  
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           date_key=  response.date_key;
           new_user_cnt=response.new_user_cnt;
           accu_user_cnt=response.accu_user_cnt;
           act_user_cnt=response.act_user_cnt;
           silent_user_cnt=response.silent_user_cnt;
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
    		            'echarts/chart/bar',
    		            'echarts/chart/line'
    		        ],
    		        function (ec,theme) {
    		            var myChart2 = ec.init(document.getElementById('mainMap'),theme);
    		            myChart2.setOption({
    		                title : {
    		            },
    		            tooltip : {
    		                trigger: 'axis'
    		            },
    		            legend: {
    		                data:["累计用户数","新增用户数","活跃用户数","沉默用户数"]
    		            },
    		            toolbox: {
    		                show : true,
    		                feature : {
    		                    mark : {show: true},
    		                    dataView : {show: true, readOnly: false},
    		                    magicType : {show: true, type: ['bar','line']},
    		                    restore : {show: true},
    		                    saveAsImage : {show: true}
    		                }
    		            },
    		            calculable : true,
    		            xAxis : [
    		                {
    		                    type : 'category',
    		                    data : date_key
    		                }
    		            ],
    		            yAxis : [
    		                {
    		                    type : 'value'
    		                }
    		            ],
    		            series : [
    		                
    		                {
    		                    name:'累计用户数',
    		                    type:'bar',
    		                    data:accu_user_cnt,
    		                    markPoint : {
    		                        data : [
    		                            {type : 'max', name: '最大值'},
    		                            {type : 'min', name: '最小值'}
    		                        ]
    		                    },
    		                    markLine : {
    		                        data : [
    		                            
    		                        ]
    		                    }
    		                },{
    		                    name:'新增用户数',
    		                    type:'bar',
    		                    data:new_user_cnt,
    		                    markPoint : {
    		                        data : [
    		                            {type : 'max', name: '最大值'},
    		                            {type : 'min', name: '最小值'}
    		                        ]
    		                    },
    		                    markLine : {
    		                        data : [
    		                           
    		                        ]
    		                    }
    		                },
    		                {
    		                    name:'活跃用户数',
    		                    type:'bar',
    		                    data:act_user_cnt,
    		                    markPoint : {
    		                        data : [
    		                            {type : 'max', name: '最大值'},
    		                            {type : 'min', name: '最小值'}
    		                        ]
    		                    },
    		                    markLine : {
    		                        data : [
    		                            
    		                        ]
    		                    }
    		                },
    		                {
    		                    name:'沉默用户数',
    		                    type:'bar',
    		                    data:silent_user_cnt,
    		                    markPoint : {
    		                        data : [
    		                            {type : 'max', name: '最大值'},
    		                            {type : 'min', name: '最小值'}
    		                        ]
    		                    },
    		                    markLine : {
    		                        data : [
    		                            
    		                        ]
    		                    }
    		                }
    		            ]
    		        });
    		        }
    		    ); 
    }
    </script>
	</body>
</html>
