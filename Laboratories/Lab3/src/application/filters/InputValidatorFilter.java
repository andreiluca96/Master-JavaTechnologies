package application.filters;

import application.model.Category;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "InputValidatorFilter", urlPatterns = {"/input"})
public class InputValidatorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        if (Objects.equals(request.getMethod(), "POST")) {
            String key = request.getParameter("key");
            String name = request.getParameter("name");
            String category = request.getParameter("category");

            System.out.println(String.format("key=%s,name=%s,category=%s\n", key, name, category));

            if (name == null || name.isEmpty() || key == null || key.isEmpty()) {
                ServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {
                    @Override
                    public String getMethod() {
                        return "GET";
                    }
                };

                request.getRequestDispatcher("/input").forward(wrapper, resp);
            } else {
                if (category == null || category.isEmpty()) {
                    ServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {
                        @Override
                        public String getParameter(final String name) {
                            if ("category".equals(name)) {
                                return Category.DEFAULT.name();
                            }
                            return super.getParameter(name);
                        }
                    };
                    chain.doFilter(wrapper, resp);
                }
            }

        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) {

    }

}
