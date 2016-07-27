package helljava.web;

import helljava.DB.MemoryDB;
import helljava.domain.User;
import helljava.repository.JoinRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class JoinController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");

        JoinRepository joinRepository = new JoinRepository();
        String saveUser = joinRepository.addUser(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("sessionUserName", saveUser);
        session.setMaxInactiveInterval(60 * 3);             //로그인시간 60초

        ArrayList<User> userList = MemoryDB.userList;
        for (User user : userList) {
            System.out.print("user = " + user.getUsername());
            System.out.println("  password = " + user.getUserpassword());
        }

        request.setAttribute("userList", userList);

        List<User> users = userList.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());

        System.out.println("ddddddddddddddddddddd");
        for (User user2 : users) {
            System.out.print("user1 = " + user2.getUsername());
            System.out.println("  password = " + user2.getUserpassword());
        }

        RequestDispatcher view = request.getRequestDispatcher("/view/join.jsp");
        view.forward(request, response);
    }
}
