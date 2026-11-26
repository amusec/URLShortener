package tech.vivek.urlshortner.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestResponseFilters implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String request_id = UUID.randomUUID().toString();

        resp.setHeader("X-Request-ID", request_id);

        chain.doFilter(request, response);
    }
}
