package application.servlets;

import application.cookies.AttributeValues;
import application.cookies.CookieNames;
import application.model.Category;
import application.model.Record;

import javax.management.InvalidAttributeValueException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "InputServlet", urlPatterns = {"/input"})
public class InputServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String key = request.getParameter("key");

        HttpSession session = request.getSession();
        Map<String, Record> mapping = (Map<String, Record>)session.getAttribute(AttributeValues.MAPPING.name());
        if (mapping == null) {
            mapping = new TreeMap<>();
        }

        if (mapping.containsKey(key)) {
            throw new RuntimeException("The key already exists in the map.");
        }

        mapping.put(key, new Record(name, Category.valueOf(category)));
        session.setAttribute(AttributeValues.MAPPING.name(), mapping);

        Cookie categoryCookie = new Cookie(CookieNames.RECORD_CATEGORY.name(), category);
        Cookie nameCookie = new Cookie(CookieNames.RECORD_NAME.name(), name);
        Cookie keyCookie = new Cookie(CookieNames.RECORD_KEY.name(), key);

        response.addCookie(categoryCookie);
        response.addCookie(nameCookie);
        response.addCookie(keyCookie);

        response.sendRedirect("result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        Category category = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CookieNames.RECORD_NAME.name())) {
                    name = cookie.getValue();
                }
                if (cookie.getName().equals(CookieNames.RECORD_CATEGORY.name())) {
                    category = Category.valueOf(cookie.getValue());
                }
                if (cookie.getName().equals(CookieNames.RECORD_KEY.name())) {
                    request.setAttribute(AttributeValues.KEY.name(), cookie.getValue());
                }
            }
        }

        request.setAttribute(AttributeValues.RECORD.name(), new Record(name, category));
        request.getRequestDispatcher("input.jsp").forward(request, response);
    }
}
