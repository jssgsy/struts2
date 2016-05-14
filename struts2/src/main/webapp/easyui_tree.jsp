<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyui tree demo</title>
<%--引入jquery easy ui的核心css和js文件 --%>
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>

<script>
		
		$(document).ready(function(){
			$('#tt').tree({
				lines:true,//是否显示连接线
 				url:"<%=path %>/default/ajaxAction!processAjax",
				method:"get",
				onClick: function(node){//node:被点击的节点
					alert(node.id);  // alert node text property when clicked
				}
			});
		});	
		
	</script>
</head>
<body>	
	
	<ul id="tt"></ul>
	
</body>
</html>