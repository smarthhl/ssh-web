<%@ include file="logincheack.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
	<body >
    <table id="dg" class="easyui-datagrid" style="height:500px;"
    		url="app!showL"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="user_id" hidden="true" sortable="true" >主键</th>
                <th field="user_name" width="50">用户名</th>
                <th field="email" width="50">邮箱</th>
                <th field="mobile" width="50">联系电话</th>
                <th field="qq" width="50">QQ</th>
                <th field="company_name" width="50">公司</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar" align="right">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<input name="user_id" type="hidden">
            <div class="fitem">
                <label>用户名:</label>
                <input name="user_name" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>密码:</label>
                <input name="pswd" class="easyui-textbox" type="password" required="true">
            </div>
            <div class="fitem">
                <label>邮箱:</label>
                <input name="email" class="easyui-textbox" required="true" validType="email">
            </div>
            <div class="fitem">
                <label>手机:</label>
                <input name="mobile" class="easyui-textbox" >
            </div>
            <div class="fitem">
                <label>QQ:</label>
                <input name="qq" class="easyui-textbox">
            </div>
            <div class="fitem">
                <label>公司:</label>
                <input name="company_name" class="easyui-textbox" >
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增用户');
            $('#fm').form('clear');
            url = 'app!save';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','编辑用户');
                $('#fm').form('load',row);
                url = 'app!save?user_id='+row.user_id;
            }
        }
        function saveUser(){
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
                $.messager.confirm('删除用户','你确定要删除该用户吗?',function(r){
                    if (r){
                        $.post('app!delUser',{userid:row.userid},function(result){
                            //alert(result)
                        	//var result = eval('('+result+')');
                        	//alert(result.msg)
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
