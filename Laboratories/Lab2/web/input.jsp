
<%@ page import="application.model.Record" %>
<%@ page import="application.cookies.AttributeValues" %>
<%@ page import="application.model.Category" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Input page</title>
</head>
<body>
    <form method="post">
        Category:
        <select name="category">
            <%
                Record record = (Record)request.getAttribute(AttributeValues.RECORD.name());
                for (Category category : Category.values()) {
                    if (Objects.equals(category, record.getCategory())) {
                        out.println("<option  value=\"" + category.name() + "\"  selected>" + category.name() + "</option>");
                    } else {
                        out.println("<option  value=\"" + category.name() + "\">" + category.name() + "</option>");
                    }
                }
            %>
        </select><br>
        Name: <input type="text" name="name" value="<%=
            record.getName() == null? "" : record.getName() %>"><br>
        Key: <input type="text" name="key" value="<%=
            request.getAttribute(AttributeValues.KEY.name()) == null? "" : ((String)request.getAttribute(AttributeValues.KEY.name())) %>"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
