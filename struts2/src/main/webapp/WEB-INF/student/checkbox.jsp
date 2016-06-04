<%@ page import="static org.junit.experimental.theories.internal.ParameterizedAssertionError.join" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Univ
  Date: 16/6/4
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts2 checkbox</title>

</head>
<body>
1. 复选框checkbox必须放在form表单中;<br>
2. el函数中的checked必须加引号;<br>
3. 注意el函数的嵌套写法:嵌套的el函数不需要$(见页面源码)<br>
<%--下面是错误的写法:${fn:contains(${fn:join(city,",")},"beijing")? 'checked':'' }--%>
页面上选择的复选框为:
<form>
    beijing: <input type="checkbox" name="city" ${fn:contains(fn:join(city,","),"beijing")? 'checked':'' } />
    shanghai:<input type="checkbox" name="city" ${fn:contains(fn:join(city,","),"shanghai")? 'checked':'' } />
    wuhan:<input type="checkbox" name="city" ${fn:contains(fn:join(city,","),"wuhan")? 'checked':'' } />
    zhejiang:<input type="checkbox" name="city" ${fn:contains(fn:join(city,","),"zhejiang")? 'checked':'' } />
</form>


</body>
</html>
