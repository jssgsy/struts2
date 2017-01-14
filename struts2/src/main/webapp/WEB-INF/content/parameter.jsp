<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Welcome</title>
   
</head>

<body>

前台传递的简单类型的id值为： ${id} <br>
前台传递的复合类型的student.name值为： ${student.name} <br>
前台传递的List类型的stuList[0].name值为： ${stuList[0].name} <br>
前台传递的数组类型的strArr值为： ${strArr[0]},${strArr[1]} <br>

</body>
</html>
