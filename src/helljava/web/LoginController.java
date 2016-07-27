package helljava.web;

import helljava.repository.UserRepository;

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

        HttpSession session = request.getSession();
        String sessionUserName = (String) session.getAttribute("sessionUserName");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = Arrays.stream(cookies).filter(c -> c.getName().equals("save_id")).findFirst().orElse(null);
        String cookieValue = "";

        if (cookie != null) {
            cookieValue = cookie.getValue();
        }

        request.setAttribute("save_id", cookieValue);

        RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");
        String save_id = request.getParameter("save_id");

        UserRepository userRepository = new UserRepository();
        RequestDispatcher view = null;

        try {
            String oneUser = userRepository.findByUserAndPassword(username, password);

            //로그인 성공한 사용자는 session 저장
            HttpSession session = request.getSession();
            session.setAttribute("sessionUserName", oneUser);
            session.setMaxInactiveInterval(60 * 3);             //로그인시간 60초
            view = request.getRequestDispatcher("/view/main.jsp");

            //아이디저장을 클릭한 사용자는 쿠키에 저장
            if (SAVE_ID_OK.equals(save_id)) {
                Cookie cookie = new Cookie("save_id", "Y");
                response.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("save_id", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

        } catch (Exception e) {
            System.out.println("fail login ");
            view = request.getRequestDispatcher("/view/login.jsp");
        }

        view.forward(request, response);
    }
}
