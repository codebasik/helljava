package helljava.contollers;

import helljava.domain.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yongjunjung on 2016. 7. 23..
 */
public class BoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Board> boardList = Board.boardList;
        request.setAttribute("boardList", boardList);

        RequestDispatcher view = request.getRequestDispatcher("/view/board/list.jsp");
        view.forward(request,response);

    }
}
