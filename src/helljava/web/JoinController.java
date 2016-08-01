package helljava.web;

import helljava.service.JoinService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class JoinController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        JoinService joinService = new JoinService();
        joinService.saveUser(request);

        RequestDispatcher view = request.getRequestDispatcher("/view/join.jsp");
        view.forward(request, response);
    }
}
