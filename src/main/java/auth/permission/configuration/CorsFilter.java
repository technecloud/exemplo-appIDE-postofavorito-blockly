package auth.permission.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import auth.permission.configuration.security.TokenUtils;

@Component
public class CorsFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
			  
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "*");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers",
     "origin-path, Origin, X-Requested-With, Content-Type, Accept, " + TokenUtils.AUTH_HEADER_NAME);

    if (!request.getMethod().equalsIgnoreCase("OPTIONS")) {
      chain.doFilter(req, res);
    } else {
      response.setStatus(HttpServletResponse.SC_OK);
    }

	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}
