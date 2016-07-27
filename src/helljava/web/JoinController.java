package helljava.web;

import helljava.repository.JoinRepository;
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
public class JoinController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");

        JoinRepository joinRepository = new JoinRepository();
        String saveUser = joinRepository.addUser(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("sessionUserName", saveUser);
        session.setMaxInactiveInterval(60 * 3);             //로그인시간 60초

        RequestDispatcher view = request.getRequestDispatcher("/view/join.jsp");
        view.forward(request, response);
    }
}
