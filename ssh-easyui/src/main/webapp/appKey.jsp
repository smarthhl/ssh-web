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
	<body>
		<table id="dg" class="easyui-datagrid" style="height: 500px;"
			url="app!showAppList" toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true"
			align="center">
			<thead>
				<tr>
					<th field="id" hidden="true" sortable="true" align="center">
						主键
					</th>
					<th field="app_name" width="40">
						应用名称
					</th>
					<th field="app_key" width="90">
						AppKey
					</th>
					<th field="app_pkg_name" width="60">
						应用包
					</th>
					<th field="app_type_id" width="50" formatter='optFormater'>
						应用类型
					</th>
					<th field="create_time" width="50">
						创建时间
					</th>
					<th field="valid_from" width="50">
						生效日期
					</th>
					<th field="app_desc" width="50">
						应用描述
					</th>
				</tr>
			</thead>
		</table>
		<%
			String s = (String) session.getAttribute("username");
			if (!s.equals("demo@creditease.cn")) {
		%>
		<div id="toolbar" align="right">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newUser()">添加应用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser()">编辑应用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="destroyUser()">删除应用</a>
		</div>
		<%
			}
		%>

		<div id="dlg" class="easyui-dialog"
			style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate>
				<input name="id" type="hidden">
				<div class="fitem">
					<label>
						应用名称:
					</label>
					<input name="app_name" class="easyui-textbox" required="true"
						validType="length[0,100]">
				</div>
				<div class="fitem">
					<label>
						应用包:
					</label>
					<input name="app_pkg_name" id="app_pkg_name" class="easyui-textbox"
						required="true" validType="length[0,100]">
				</div>
				<div class="fitem">
					<label>
						应用类型:
					</label>
					<input name="app_type_id" id="app_type_id" class="easyui-combobox"
						editable="false" required="true">
				</div>
				<div class="fitem">
					<label>
						应用描述:
					</label>
					<input name="app_desc" class="easyui-textbox"
						data-options="multiline:true" style="height: 60px"
						validType="length[0,600]">
				</div>
			</form>
			<input id="vdata" type="hidden">
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveUser()" style="width: 90px">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width: 90px">取消</a>
		</div>
		<script type="text/javascript">
    /**$(function(){
    	$.get('app!getApptype',function(result){
    		myobj=eval('('+result+')');
    		//data=result;
    		for(var i=0;i<myobj.length;i++){ 
    			map[myobj[i].id]=myobj[i].text;
    		}
    		$('#vdata').val(map)
        });
       
    	
    });*/
    function optFormater(value,row,index){
		if(value=='2'){
			return 'Android端';
		}
		if(value=='1'){
			return 'iPhone端';
		}
		if(value=='-1'){
			return '其他';
		}
		if(value=='3'){
			return 'Windows Phone';
		}
		if(value=='4'){
			return 'Symbian';
		}
		if(value=='5'){
			return 'BlackBerry OS';
		}
		return value;
	}
    $(function(){

    	$('#app_type_id').combobox({
    		url:'app!getApptype',
    		valueField:'id',
    		textField:'text',
    		value:"请选择"
    	});
    	//$('#rwlb').combobox('select', data[0].id);
    });
        var url;
        var appP_name;
        var appP_type;
        var id_tmp;
        function newUser(){ 
            $('#dlg').dialog('open').dialog('setTitle','添加应用');
            $('#app_type_id').combobox('enable');
            $('#fm').form('clear');
            //验证qn
            url = 'app!saveAppkey';
            appP_name='';
            appP_type='';
            id_tmp='';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
            	appP_name=row.app_pkg_name;
            	appP_type=row.app_type_id;
            	id_tmp=row.id;
                $('#dlg').dialog('open').dialog('setTitle','编辑应用');
                $('#fm').form('load',row);
                $('#app_type_id').combobox('disable');
                url = 'app!saveAppkey?id='+row.id;
            }
        }
        function saveUser(){
        	var app_pkg_name=$('#app_pkg_name').val();
        	var app_type_id=$('#app_type_id').combobox('getValue')
            if(id_tmp==''){
            	check(app_pkg_name,app_type_id);
            }else{
				if (appP_name!=app_pkg_name || appP_type!=app_type_id){
					check(app_pkg_name,app_type_id);
				}else{
					subForm();
				}
            }
        }
        function check(app_pkg_name,app_type_id){
        	$.post('app!checkAppKey',{app_pkg_name:app_pkg_name,app_type_id:app_type_id},function(result){
               	if(result.key_status==3){
               		$.messager.show({
                           title: '操作信息',
                           msg: '该应用包名已经存在！'
                       });
                  }else{
                	  subForm();
                  }
                   
               },'json');
        }

        function subForm(){
        	 $('#fm').form('submit',{
                 url: url,
                 onSubmit: function(){
                     return $(this).form('validate');
                 },
                 success: function(result){
                     var result = eval('('+result+')');
                     $.messager.show({
                         title: '操作信息',
                         msg: result.msg
                     });
                     $('#dlg').dialog('close');        // close the dialog
                     $('#dg').datagrid('reload');    // reload the user data
                 }
             });
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('删除应用','你确定要删除该应用吗?',function(r){
                    if (r){
                        $.post('app!delApp',{id:row.id},function(result){
                        	$('#dg').datagrid('reload');
                            $.messager.show({
                                title: '操作信息',
                                msg: result.msg
                            });
                        },'json');
                    }
                });
            }
        }
    </script>
	</body>
</html>
