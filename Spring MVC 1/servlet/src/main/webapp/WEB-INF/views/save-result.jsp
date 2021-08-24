<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: MisternB
  Date: 2021/08/24
  Time: 9:48 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

성공
<ul>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--    <li>username=<%=((Member)request.getAttribute("username")).getUsername()%></li>--%>
<%--    <li>age=<%=((Member)request.getAttribute("age")).getAge()%></li>--%>
<%--    위 코드를 간단하게 표현 가능 ( 프로퍼티 접근법으로 jsp에서 제공하는 표현법)--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>
