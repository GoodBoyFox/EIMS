package Filter;

import Dao.CookieDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class checkLoginedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        if (new CookieDao().checkLogined((HttpServletRequest)req)) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("/");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
