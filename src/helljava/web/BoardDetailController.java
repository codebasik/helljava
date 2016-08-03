package helljava.web;

import helljava.domain.Board;
import helljava.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 28..
 */
public class BoardDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int seq = Integer.parseInt(request.getParameter("seq"));

        BoardService boardService = new BoardService();
        Board board = boardService.getBoardDetail(seq);

        request.setAttribute("detail", board);

        RequestDispatcher view = request.getRequestDispatcher("/view/board/detail.jsp");
        view.forward(request, response);
    }
}
