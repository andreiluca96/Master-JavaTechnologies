package application;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@WebServlet(name = "Lab1Servlet",  urlPatterns = {"/ex1"})
public class Lab1Servlet extends HttpServlet {

    private final Map<String, MappingValue> MAPPING = new TreeMap<>();

    private static final String DEFAULT_HTML_FORM = "<form method=\"post\">\n" +
            "  Key:<br>\n" +
            "  <input type=\"text\" name=\"key\"><br>\n" +
            "  Value:<br>\n" +
            "  <input type=\"text\" name=\"value\">\n <br>" +
            " <input type=\"submit\" value=\"Submit\">" +
            "</form>";

    private static final String DEFAULT_HTML_FORM_SUCCESS = "<form method=\"post\">\n" +
            "  Key:<br>\n" +
            "  <input type=\"text\" name=\"key\"><br>\n" +
            "  Value:<br>\n" +
            "  <input type=\"text\" name=\"value\">\n <br>" +
            " <input type=\"submit\" value=\"Submit\">" +
            "</form> <br> Successfully Added!";

    private static final String DEFAULT_HTML_FORM_FAILURE = "<form method=\"post\">\n" +
            "  Key:<br>\n" +
            "  <input type=\"text\" name=\"key\"><br>\n" +
            "  Value:<br>\n" +
            "  <input type=\"text\" name=\"value\">\n <br>" +
            " <input type=\"submit\" value=\"Submit\">" +
            "</form> <br> Something went wrong.";
    private static final String OUTPUT_FILE_PATH = "F:\\Facultate\\TehnologiiJava\\Labs\\Lab1\\file1.txt";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(String.format("Received a request with method {%s}, IP {%s}, user-agent {%s}, language {%s}, params {%s}.",
                request.getMethod(), request.getRemoteAddr(), request.getHeader("User-Agent"),
                request.getLocale().getLanguage(), request.getParameterMap()));
        try {
            /* Extract the key and the value from the query params. */
            String key = request.getParameter("key");
            String value = request.getParameter("value");

            MappingValue mappingValue = new MappingValue(value);
//            synchronized (this) {
                /* Add the key/values to the map. */
                MAPPING.put(key, mappingValue);
//            }

            /* Add the values to the file. */
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH, false));
            writer.write(String.format("key=%s, value=%s \n", key, mappingValue));

            writer.close();

            if ("text/plain".equals(request.getContentType())) {
                /* Return just the entries if request content type is text/plain. */
                response.setContentType("text/plain");
                PrintWriter out = new PrintWriter(response.getWriter());

                String mappingList;
                synchronized (this) {
                    mappingList = MAPPING.entrySet()
                            .stream()
                            .map(entry -> String.format("key=%s, value=%s",
                                    entry.getKey(),
                                    entry)
                            )
                            .collect(Collectors.joining("\n"));
                }

                out.println(mappingList);
                out.close();
            } else {
                //response
                response.setContentType("text/html");

                /* Write the default response */
                PrintWriter out = new PrintWriter(response.getWriter());
                out.println(DEFAULT_HTML_FORM_SUCCESS);

                /* Append the key-value mapping */
                out.println("<br> Key-Values: <br>");
                String keyValueMappingString;
                synchronized (this) {
                    keyValueMappingString = MAPPING.entrySet()
                            .stream()
                            .map(entry -> String.format("key=%s, value=%s",
                                    entry.getKey(),
                                    entry.getValue())
                            )
                            .collect(Collectors.joining("<br>"));
                }

                out.println(keyValueMappingString);

                out.close();
            }

        } catch (Exception e) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            System.exit(1);

            PrintWriter out = new PrintWriter(response.getWriter());
            out.println(DEFAULT_HTML_FORM_FAILURE);
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = new PrintWriter(response.getWriter());
        if ("text/plain".equals(request.getContentType())) {
            response.setContentType("text/plain");
            synchronized (this) {
                out.println(MAPPING.toString());
            }
        } else {
            out.println(DEFAULT_HTML_FORM);
        }

        out.close();
    }
}
