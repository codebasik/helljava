package helljava.web;

import helljava.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 28..
 */
public class BoardDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int seq = Integer.parseInt(request.getParameter("seq"));

        BoardService boardService = new BoardService();
        boardService.delete(seq);

        response.sendRedirect("/board.do");


    }
}
