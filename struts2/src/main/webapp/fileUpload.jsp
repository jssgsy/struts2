<%@ page contentType="text/html; charset=UTF-8" %>
<!-- 导入struts2标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Welcome</title>   
</head>

<body>
	<form action="<%=path %>/default/fileUpload" enctype="multipart/form-data" method="post">
		选择文件：<input type="file" name="upload"><br>
		<!-- 上传类型不支持时利用系统默认错误提示 -->
		<s:fielderror name="upload"></s:fielderror>  
		<input type="submit" value="上传"/><br>
	</form>

</body>
</html>
