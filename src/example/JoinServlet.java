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
public class JoinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String userPassword = request.getParameter("userpassword");

        if (userName == null) {
            response.sendRedirect("/login.do");
        }

        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
//        session.setMaxInactiveInterval(5);             //로그인시간 60초

        request.setAttribute("userName", userName);

        RequestDispatcher view = request.getRequestDispatcher("/view/join.jsp");
        view.forward(request,response);
    }
}
