<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84096
  Date: 2022/11/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
</head>
<body>
<c:forEach items="${arr}" var="item">
    科目：${item.getA()}&nbsp;&nbsp;&nbsp;成绩：${item.getB()}<br>

</c:forEach>
</body>
</html>
