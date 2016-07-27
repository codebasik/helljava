package helljava.web;

import helljava.DB.MemoryDB;
import helljava.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ArrayList<User> userList = MemoryDB.userList;

        request.setAttribute("userList", userList);

        RequestDispatcher view = request.getRequestDispatcher("/view/main.jsp");
        view.forward(request,response);
    }
}
