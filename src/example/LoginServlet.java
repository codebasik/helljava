package example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String sessionUserName = (String) session.getAttribute("userName");

        if (sessionUserName != null) {

        }

        RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
        view.forward(request,response);

    }
}
