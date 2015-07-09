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
	<div id="tip_todayData" class="tips">
      <div class="corner"></div>
      <p><span class="highlight">占比：</span>表示该范围内的启动次数占全天启动次数的比例，如全天应用共启动1000次，在19点到20点的时候，登陆时长在1-3分钟的启动次数为200次，那么该占比为20%</p>
    </div>
	<div>
    	<div style="height: 30px;float:left" >
    	<button  onmouseover="javascript:divDis();" onMouseOut="javascript:divNone();" class="help"></button>
	    </div>
	    
		<div style="height: 30px" align="right">
			<label style="font-size: 13px;">应用名称&nbsp;&nbsp;</label><input name="app_key" id="app_key" style="width: 100px;" class="easyui-combobox" required="true">
		<input  id="beginDate" name="beginDate"  class="Wdate1" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01\'}'})"/>
	-
<input id="endDate" class="Wdate1" type="text" name="endDate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}',maxDate:'2020-10-01'})"/>
		<a href="javascript:query();" class="easyui-linkbutton" iconCls="icon-search" plain="false">查 询</a>
		</div>
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

    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    function query(){
    	//数据生成路径 
    	var beginDate=$('#beginDate').val();
    	var endDate=$('#endDate').val();
    	var app_key=$('#app_key').combobox('getValue');
        var url = 'app!usageDur.action?beginDate='+beginDate+'&endDate='+endDate+'&app_key='+app_key;
        url=encodeURI(url);
        $.ajaxSettings.async = false;  //同步才能获取数据  
        $.post(url,function(response) {  
           data=  response.duration;
       }, "json");  
        EconfigAPI(url); 
    }
    
    $(document).ready(function() {
    	//数据生成路径  
        var url = 'app!usageDur.action';  
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
						        orient : 'vertical',
								x : 'right',
								y : 'center',
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
						            data:['1-3秒','4-10秒','11-30秒','31-60秒','1-3分','3-10分','10-30分','30分~']//时间区间
						        }
						    ],
						    series : [
						        {
						            type:'scatter',
						            tooltip : {
						                trigger: 'item',
						                formatter : function (params) {
						                    return params.value[0] +"点到"+(params.value[0]+1)+"点，登录时长为"+params.value[1]+"的<br>启动次数: "+ (parseInt(params.value[2]).toFixed(0) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,')+"<br/>占比:"+params.value[3]+"%"; 
						                },
						                axisPointer:{
						                    type: 'none',
						                    show: false
						                }
						            },
						            symbolSize: function (value){
						            	if(value[3]<=10){
						                	return Math.round(value[3]*2.5);
						    		    }else if(10<value[3]<=20){
						    		    	return Math.round(10*2.5+(value[3]-10)*1);
						    			}else if(20<value[3]<=30){
						    		    	return Math.round(10*2.5+10*1+(value[3]-20)*0.8);
						    			}else if(30<value[3]<=40){
						    		    	return Math.round(10*2.5+10*1+10*0.8+(value[3]-30)*0.5);
						    			}else if(40<value[3]<=50){
						    		    	return Math.round(10*2.5+10*1+10*0.8+10*0.5+(value[3]-40)*0.2);
						    			}else if(50<value[3]<=100){
						    		    	return Math.round(10*2.5+10*1+10*0.8+10*0.5+10*0.2+(value[3]-50)*0.1);
						    			}
						        	},
						            data: data//数据[小时,区间,值]
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
