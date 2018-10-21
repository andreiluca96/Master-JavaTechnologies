package application.filters;

import application.model.LogEvent;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", urlPatterns = {"*"})
public class LoggingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        LogEvent logEvent = new LogEvent();
        logEvent.setRequestSessionId(request.getRequestedSessionId());
        logEvent.setIpAddress(request.getRemoteAddr());
        logEvent.setParameters(request.getParameterNames());
        logEvent.setRequestPath(request.getServletPath());

        System.out.println(logEvent);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) {
    }
}
