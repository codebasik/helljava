package helljava.contollers;

import helljava.models.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String sessionUserName = (String) session.getAttribute("sessionUserName");
        System.out.println("[로그인] sessionUserName = " + sessionUserName);

        if (sessionUserName != null) {

        }

        RequestDispatcher view = request.getRequestDispatcher("/view/login.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("로그인 POST");

        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String password = request.getParameter("userpassword");
        System.out.println("password = " + password);

        UserRepository userRepository = new UserRepository();
        RequestDispatcher view = null;
        try {
            String oneUser = userRepository.findOneUser(username, password);
            System.out.println("oneUser = " + oneUser);
            HttpSession session = request.getSession();
            session.setAttribute("sessionUserName", oneUser);
            session.setMaxInactiveInterval(60 * 3);             //로그인시간 60초
            view = request.getRequestDispatcher("/view/main.jsp");
        } catch (Exception e) {
            System.out.println("fail login ");
            view = request.getRequestDispatcher("/view/login.jsp");
        }

        view.forward(request,response);
    }
}
