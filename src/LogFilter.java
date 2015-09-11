import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LogFilter implements Filter {
    private FilterConfig filterConfig;
    private ArrayList<String> urlList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String urls = filterConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

        System.out.println("URLS:" + urls);

        urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter is execute");

        HttpServletRequest reg = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String urlw = reg.getServletPath();
        boolean allowedRequest = false;
        System.out.println("urlw " + urlw);

        if (urlList.contains(urlw)) {
            allowedRequest = true;
        }
        System.out.println(allowedRequest);

        if (!allowedRequest) {
            HttpSession session = reg.getSession();
            String userName = (String) session.getAttribute("userName");
            session.setAttribute("url", urlw);

            System.out.println("session " + session + " " + "string " + userName);

            if (null == session) {
                System.out.println("null == session");
                res.sendRedirect("/registration.jsp");
            }
            if (null != session & userName == null) {
                System.out.println("null != session");
                res.sendRedirect("/registration.jsp");
            }
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
