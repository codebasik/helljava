package helljava.web;

import helljava.repository.UserRepository;
import helljava.util.CookieBox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.Arrays;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class LoginController extends HttpServlet {

    private static final String SAVE_ID_OK = "on";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        CookieBox cookieBox = new CookieBox(request);
        request.setAttribute("c_user", cookieBox.getValue("c_user"));
        request.setAttribute("isSaveCheck", cookieBox.getValue("isSaveCheck"));

        RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");
        String save_id = request.getParameter("isSaveCheck");

        RequestDispatcher view = null;

        try {

            UserRepository userRepository = new UserRepository();
            userRepository.findByUserAndPassword(username, password);

            //로그인 성공한 사용자는 session 저장
            HttpSession session = request.getSession();
            session.setAttribute("sessionUserName", username);
            session.setMaxInactiveInterval(60 * 3);             //로그인시간 60초

            //아이디저장을 클릭한 사용자는 쿠키에 저장
            if (SAVE_ID_OK.equals(save_id)) {
                response.addCookie(CookieBox.createCookie("isSaveCheck", "Y"));
                response.addCookie(CookieBox.createCookie("c_user", username));
            } else {
                response.addCookie(CookieBox.createCookie("isSaveCheck", "", 0));
                response.addCookie(CookieBox.createCookie("c_user", "", 0));
            }

            view = request.getRequestDispatcher("/view/main.jsp");

        } catch (Exception e) {
            view = request.getRequestDispatcher("/view/login.jsp");
        }

        view.forward(request, response);
    }
}
