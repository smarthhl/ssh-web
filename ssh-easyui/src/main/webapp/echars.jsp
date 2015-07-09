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
	<body>
	<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
    <div id="mainMap" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
    <script type="text/javascript">
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths: {
            echarts: './echars'
        }
    });
    
    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/radar',
            'echarts/chart/map'
        ],
        function (ec) {
            //--- 折柱 ---
            var myChart = ec.init(document.getElementById('main'));
            myChart.setOption({
                title : {
                text: '预算 vs 开销（Budget vs spending）',
                subtext: '纯属虚构'
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient : 'vertical',
                x : 'right',
                y : 'bottom',
                data:['预算分配（Allocated Budget）','实际开销（Actual Spending）']
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
                       { text: '销售（sales）', max: 6000},
                       { text: '管理（Administration）', max: 16000},
                       { text: '信息技术（Information Techology）', max: 30000},
                       { text: '客服（Customer Support）', max: 38000},
                       { text: '研发（Development）', max: 52000},
                       { text: '市场（Marketing）', max: 25000}
                    ]
                }
            ],
            calculable : true,
            series : [
                {
                    name: '预算 vs 开销（Budget vs spending）',
                    type: 'radar',
                    data : [
                        {
                            value : [4300, 10000, 28000, 35000, 50000, 19000],
                            name : '预算分配（Allocated Budget）'
                        },
                         {
                            value : [5000, 14000, 28000, 31000, 42000, 21000],
                            name : '实际开销（Actual Spending）'
                        }
                    ]
                }
            ]
        });
            
            // --- 地图 ---
            var myChart2 = ec.init(document.getElementById('mainMap'));
            myChart2.setOption({
            	title : {
                text: 'iphone销量',
                subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                x:'left',
                data:['iphone3','iphone4','iphone5']
            },
            dataRange: {
                min: 0,
                max: 2500,
                x: 'left',
                y: 'bottom',
                text:['高','低'],           // 文本，默认为数值文本
                calculable : true
            },
            toolbox: {
                show: true,
                orient : 'vertical',
                x: 'right',
                y: 'center',
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            roamController: {
                show: true,
                x: 'right',
                mapTypeControl: {
                    'china': true
                }
            },
                series :  [
                           {
                               name: 'iphone3',
                               type: 'map',
                               mapType: 'china',
                               roam: false,
                               itemStyle:{
                                   normal:{label:{show:true}},
                                   emphasis:{label:{show:true}}
                               },
                               data:[
                                   {name: '北京',value: Math.round(Math.random()*1000)},
                                   {name: '天津',value: Math.round(Math.random()*1000)},
                                   {name: '上海',value: Math.round(Math.random()*1000)},
                                   {name: '重庆',value: Math.round(Math.random()*1000)},
                                   {name: '河北',value: Math.round(Math.random()*1000)},
                                   {name: '河南',value: Math.round(Math.random()*1000)},
                                   {name: '云南',value: Math.round(Math.random()*1000)},
                                   {name: '辽宁',value: Math.round(Math.random()*1000)},
                                   {name: '黑龙江',value: Math.round(Math.random()*1000)},
                                   {name: '湖南',value: Math.round(Math.random()*1000)},
                                   {name: '安徽',value: Math.round(Math.random()*1000)},
                                   {name: '山东',value: Math.round(Math.random()*1000)},
                                   {name: '新疆',value: Math.round(Math.random()*1000)},
                                   {name: '江苏',value: Math.round(Math.random()*1000)},
                                   {name: '浙江',value: Math.round(Math.random()*1000)},
                                   {name: '江西',value: Math.round(Math.random()*1000)},
                                   {name: '湖北',value: Math.round(Math.random()*1000)},
                                   {name: '广西',value: Math.round(Math.random()*1000)},
                                   {name: '甘肃',value: Math.round(Math.random()*1000)},
                                   {name: '山西',value: Math.round(Math.random()*1000)},
                                   {name: '内蒙古',value: Math.round(Math.random()*1000)},
                                   {name: '陕西',value: Math.round(Math.random()*1000)},
                                   {name: '吉林',value: Math.round(Math.random()*1000)},
                                   {name: '福建',value: Math.round(Math.random()*1000)},
                                   {name: '贵州',value: Math.round(Math.random()*1000)},
                                   {name: '广东',value: Math.round(Math.random()*1000)},
                                   {name: '青海',value: Math.round(Math.random()*1000)},
                                   {name: '西藏',value: Math.round(Math.random()*1000)},
                                   {name: '四川',value: Math.round(Math.random()*1000)},
                                   {name: '宁夏',value: Math.round(Math.random()*1000)},
                                   {name: '海南',value: Math.round(Math.random()*1000)},
                                   {name: '台湾',value: Math.round(Math.random()*1000)},
                                   {name: '香港',value: Math.round(Math.random()*1000)},
                                   {name: '澳门',value: Math.round(Math.random()*1000)}
                               ]
                           },
                           {
                               name: 'iphone4',
                               type: 'map',
                               mapType: 'china',
                               itemStyle:{
                                   normal:{label:{show:true}},
                                   emphasis:{label:{show:true}}
                               },
                               data:[
                                   {name: '北京',value: Math.round(Math.random()*1000)},
                                   {name: '天津',value: Math.round(Math.random()*1000)},
                                   {name: '上海',value: Math.round(Math.random()*1000)},
                                   {name: '重庆',value: Math.round(Math.random()*1000)},
                                   {name: '河北',value: Math.round(Math.random()*1000)},
                                   {name: '安徽',value: Math.round(Math.random()*1000)},
                                   {name: '新疆',value: Math.round(Math.random()*1000)},
                                   {name: '浙江',value: Math.round(Math.random()*1000)},
                                   {name: '江西',value: Math.round(Math.random()*1000)},
                                   {name: '山西',value: Math.round(Math.random()*1000)},
                                   {name: '内蒙古',value: Math.round(Math.random()*1000)},
                                   {name: '吉林',value: Math.round(Math.random()*1000)},
                                   {name: '福建',value: Math.round(Math.random()*1000)},
                                   {name: '广东',value: Math.round(Math.random()*1000)},
                                   {name: '西藏',value: Math.round(Math.random()*1000)},
                                   {name: '四川',value: Math.round(Math.random()*1000)},
                                   {name: '宁夏',value: Math.round(Math.random()*1000)},
                                   {name: '香港',value: Math.round(Math.random()*1000)},
                                   {name: '澳门',value: Math.round(Math.random()*1000)}
                               ]
                           },
                           {
                               name: 'iphone5',
                               type: 'map',
                               mapType: 'china',
                               itemStyle:{
                                   normal:{label:{show:true}},
                                   emphasis:{label:{show:true}}
                               },
                               data:[
                                   {name: '北京',value: Math.round(Math.random()*1000)},
                                   {name: '天津',value: Math.round(Math.random()*1000)},
                                   {name: '上海',value: Math.round(Math.random()*1000)},
                                   {name: '广东',value: Math.round(Math.random()*1000)},
                                   {name: '台湾',value: Math.round(Math.random()*1000)},
                                   {name: '香港',value: Math.round(Math.random()*1000)},
                                   {name: '澳门',value: Math.round(Math.random()*1000)}
                               ]
                           }
                       ]
            });
        }
    );
    </script>
	</body>
</html>
