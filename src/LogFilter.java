import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter is execute");
        //HttpSession session =  request.getSession();

        //String string = request.getParameter("userName");
        // String url = request.getParameter("url");
        //if (string != null) {
        //   HttpServletResponse httpResponse = (HttpServletResponse) response;
        //  httpResponse.sendRedirect(url);
        //} else {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("registration.jsp");
    }

    @Override
    public void destroy() {
       this.filterConfig = null;
    }
}
