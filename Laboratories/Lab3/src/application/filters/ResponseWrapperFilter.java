package application.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ResponseWrapperFilter", urlPatterns = {"*"})
public class ResponseWrapperFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        final PrintWriter[] writer = {null};

        if ("GET".equals(request.getMethod()) && request.getServletPath().contains("input")) {
            ServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) resp){
                @Override
                public PrintWriter getWriter() throws IOException {
                    if (writer[0] == null) {
                        writer[0] = super.getWriter();
                        writer[0].write("Wrapper-start");
                    } else {
                        writer[0].write("Wrapper-end");
                    }

                    return writer[0];
                }
            };
            chain.doFilter(req, wrapper);

        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) {

    }

}
