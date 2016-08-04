package helljava.action.Board;

import helljava.action.CommandAction;
import helljava.domain.Board;
import helljava.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongjunjung on 2016. 8. 3..
 */
public class ListAction implements CommandAction {

    BoardService boardService = new BoardService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("UTF-8");
        System.out.println("request.getParameter(\"searchWord\") = " + request.getParameter("searchWord"));

        System.out.println("[ListAction] proRequest Call!");

        List<Board> boardList = boardService.boardList(request);
        request.setAttribute("boardList", boardList);
        request.setAttribute("boardSearch", getBoardSearch(request));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board/list.jsp");
        dispatcher.forward(request, response);
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
