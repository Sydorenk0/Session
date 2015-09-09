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
public class servlet extends HttpServlet{

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       HttpSession session =  request.getSession();


        String str = request.getParameter("userName");
        session.setAttribute("userName", str);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showsession.jsp");
        dispatcher.forward(request, response);
    }

}
