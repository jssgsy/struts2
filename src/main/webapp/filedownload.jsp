<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
  </head>  
    
  <body>  
    <h2>文件下载内容：</h2><br/>  
   	 上大小伙伴.jpg:<a href="default/FileDownload.action">点击下载</a><br/>  
  </body>  
</html>  