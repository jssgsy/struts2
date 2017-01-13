<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--引入strust2标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!--
摘自官网：
By default, the ExceptionMappingInterceptor adds the following values to the Value Stack:
exception ： The exception object itself；
exceptionStack ： The value from the stack trace；

即，在页面中显示这些异常就是通过这两个对象。
当然，在实际使用中应该根据具体的异常类型给出更人性化的提示。
-->


<hr/>
<h3>Error Message</h3>
<s:actionerror/>
<p>
    <s:property value="%{exception.message}"/>
</p>
<hr/>

<h3>Technical Details</h3>
<p>
    <s:property value="%{exceptionStack}"/>
</p>


</body>
</html>