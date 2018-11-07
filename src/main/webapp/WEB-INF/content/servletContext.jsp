<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Welcome</title>   
</head>

<body>
在后台往application中存放的name属性的值为：${name} <br>
注意：如果已经访问过后台，则这里的输出是actionContext.getSession().put，因为session中已经有值。
</body>
</html>
