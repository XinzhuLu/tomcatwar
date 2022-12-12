<%--
  Created by IntelliJ IDEA.
  User: 馨竹
  Date: 12/12/2022
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--* <%...%>：内容会直接放到_jspService()方法之中--%>
<%--* <%=…%>：内容会放到out.print()中，作为out.print()的参数--%>
<%--* <%!…%>：内容会放到_jspService()方法之外，被类直接包含--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>

<%--* <%...%>：内容会直接放到_jspService()方法之中--%>
<%
    System.out.println("hello,jsp~");
    int i = 3;
%>

<%--* <%=…%>：内容会放到out.print()中，作为out.print()的参数--%>
<%="hello"%>
<%=i%>
<%--相当于--%>
<%--out.print("hello");--%>
<%--out.print("\r\n");--%>
<%--out.print("    ");--%>
<%--out.print("i");--%>

<%--* <%!…%>：内容会放到_jspService()方法之外，被类直接包含--%>
<%--脚本的内容被放在了成员位置--%>
<%!
    void  show(){}
    String name = "zhangsan";
%>


</body>
</html>