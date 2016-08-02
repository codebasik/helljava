package helljava.web;

import helljava.DB.MemoryDB;
import helljava.domain.Board;
import helljava.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongjunjung on 2016. 7. 23..
 */
public class BoardController extends HttpServlet {

    BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<Board> boardList = boardService.boardList(request);
        request.setAttribute("boardList", boardList);

        request.setAttribute("boardSearch", getBoardSearch(request));

        RequestDispatcher view = request.getRequestDispatcher("/view/board/list.jsp");
        view.forward(request,response);
    }

    private Map<String, String> getBoardSearch(HttpServletRequest request) {

        String searchWord = request.getParameter("searchWord");
        String queryInput = request.getParameter("queryInput");

        Map<String, String> boardSearch = new HashMap<>();
        boardSearch.put("searchWord", searchWord);
        boardSearch.put("queryInput", queryInput);

        return boardSearch;
    }
}
