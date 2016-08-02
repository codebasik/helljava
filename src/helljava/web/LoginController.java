package helljava.web;

import helljava.service.UserService;
import helljava.util.CookieBox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        CookieBox cookieBox = new CookieBox(request);
        request.setAttribute("c_id", cookieBox.getValue("c_id"));
        request.setAttribute("isSaveCheck", cookieBox.getValue("isSaveCheck"));

        RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher view = null;

        try {
            UserService userService = new UserService();
            userService.login(request, response);
            view = request.getRequestDispatcher("/view/main.jsp");
        } catch (Exception e) {
            view = request.getRequestDispatcher("/view/login.jsp");
        }
        view.forward(request, response);
    }
}
