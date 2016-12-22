<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Welcome</title>   
</head>

<body>
<a href="<%=path %>/default/loginAction!logout">退出登录</a>

<h3>通过表单get方式访问action的方法</h3>
<!-- 注意通过get方式请求时，不能将参数附在action后，会丢失，这个时候可利用<input type=hidden/>传参 -->
<form method="get" action="<%=path %>/default/studentAction!test" >
 	name:<input type="text" name="student.name" />
 	age:<input type="text" name="student.age" />
	<input type="submit" value="ok" />
</form>

<h3>struts2接收复选框的值</h3>
<form action="<%=path %>/default/studentAction!checkbox">
    beijing: <input type="checkbox" name="city" value="beijing"/>
    shanghai:<input type="checkbox" name="city" value="shanghai"/>
    wuhan:<input type="checkbox" name="city" value="wuhan"/>
    zhejiang:<input type="checkbox" name="city" value="zhejiang"/>
    <input  type="submit" />
</form>

<h3>通过超链接访问action的默认execute方法(test):student.name=lml&student.age=24</h3>
<a href="<%=path %>/default/studentAction?student.name=lml&student.age=24">通过超链接访问action的默认execute方法</a>

<h3>通过超链接指定访问action的方法(test):student.name=liuminglu&student.age=24</h3>
<a href="<%=path %>/default/studentAction!test?student.name=liuminglu&student.age=24">通过超链接指定访问action的方法(test)</a>

<h3>通过表单post方式访问action的方法(test)</h3>
<form method="post" action="<%=path %>/default/studentAction!test?student.age=24" >
 	name:<input type="text" name="student.name" /> 	
	<input type="submit" value="提交" />
</form>

<!-- 跳转到ztree和ajax综合使用的demo上 -->
<%--<a href="<%=path %>/ztreeAjax.jsp"><h3>跳转到ztree和ajax综合使用的demo上</h3></a><br>--%>

<%-- 跳转到ztree和ajax综合使用的demo上 --%>
<a href="<%=path %>/easyui_tree.jsp"><h3>跳转到easyui_tree和ajax综合使用的demo上</h3></a><br>


下面三种方式都是迫不得已时才采用的方法<br>
<!-- 在action中获取servlet中的request对象 -->
<a href="<%=path %>/default/servletAction!request?name=lml&age=24"><h3>在action中获取servlet中的request对象</h3></a>
<!-- 在action中获取servlet中的session对象 -->
<a href="<%=path %>/default/servletAction!session"><h3>在action中获取servlet中的session对象</h3></a>
<!-- 在action中获取servlet中的servletContext对象 -->
<a href="<%=path %>/default/servletAction!servletContext"><h3>在action中获取servlet中的servletContext对象</h3></a>

下面是正确获取servlet相关对象的方法（以request为例）<br>
<a href="<%=path %>/default/servletAction!request2?name=柳明录&age=24"><h3>在action中获取servlet中的request对象</h3></a><br>

<!-- 访问单个action，触发只为此action设置的拦截器 -->
<a href="<%=path %>/default/interceptorAction">访问单个action，触发只为此action设置的拦截器</a><br>

<!-- 跳转到struts2 文件上传页面 -->
<a href="<%=path %>/fileUpload.jsp"><h3>跳转到struts2 文件上传页面</h3></a>

<!-- 跳转到struts2 文件下载页面 -->
<a href="<%=path %>/filedownload.jsp"><h3>跳转到struts2 文件下载页面</h3></a>

<!-- 跳转到jxl测试页面 -->
<a href="<%=path %>/default/jxlAction!showContents"><h3>跳转到jxl测试页面</h3></a>



</body>
</html>
