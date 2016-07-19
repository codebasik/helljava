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
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String loginUserName = (String) session.getAttribute("userName");

        System.out.println("loginUserName = " + loginUserName);

        if (loginUserName == null) {
            RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
            view.forward(request,response);
        }

        RequestDispatcher view = request.getRequestDispatcher("/view/main.jsp");
        view.forward(request,response);
    }
}
