import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alex on 09.09.2015.
 */
public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute("userName");
        String url = (String) session.getAttribute("url");
        System.out.println(value + " " +url);

        if (value == null) {
            String str = request.getParameter("userName");
            if (str != null) {
                System.out.println("str = " + str);
                session.setAttribute("userName", str);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }
    }
}
