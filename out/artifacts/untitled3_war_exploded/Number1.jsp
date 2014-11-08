<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 08.11.14
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
   <table border="2" >
        <%for (int i = 1; i < 10 ; i++){
        %><tr><%
            for(int j = 0; j < 10; j++){
                %>
                <td>
                    <%=(int)(Math.random()*10)+1%>
                    </td>
                <%
            }
            %></tr><%
        }
    %>
</body>
</html>
