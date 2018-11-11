<%@ page import="application.cookies.AttributeValues" %>
<%@ page import="application.model.Record" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: andrluc
  Date: 10/14/18
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>

    <table>
        <tr>
            <th>
                Key
            </th>
            <th>
                Category
            </th>
            <th>
                Name
            </th>
        </tr>
        <%
            final Map<String, Record> mapping = (Map<String, Record>) session.getAttribute(AttributeValues.MAPPING.name());
            for (Map.Entry<String, Record> entry : mapping.entrySet()) {
                out.println("<tr>");
                out.println(String.format("<td>%s</td><td>%s</td><td>%s</td><br>",
                        entry.getKey(),
                        entry.getValue().getCategory(),
                        entry.getValue().getName()
                ));
                out.println("</tr>");
            }
        %>
    </table>

</body>
</html>
