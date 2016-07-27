package helljava.web;

import helljava.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class WriteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("/view/board/write.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("username");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardRepository boardRepository = new BoardRepository();
        boardRepository.write(userName, title, content);

        response.sendRedirect("/board.do");

    }
}
