<%--
  Created by IntelliJ IDEA.
  User: PC-COL15
  Date: 25/8/2022
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hola mundo</title>
</head>
<body>
<h2>Hola mundo ejb!</h2>
<h3>${saludo}</h3>
<h3>${saludo2}</h3>
<div style="background-color: coral" >
<ul>
    <c:forEach items="${list}" var="prod">
      <li style="background-color: sandybrown" >
          <p style="background-color: aliceblue"> ${prod.nombre} </p>
      </li>
       

    </c:forEach>
</ul>
</div>
</body>
</html>
