package helljava.action.Board;

import helljava.action.CommandAction;
import helljava.domain.Board;
import helljava.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yongjunjung on 2016. 8. 3..
 */
public class DetailAction implements CommandAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        System.out.println("[DetailAction] execute Call!");

        int seq = Integer.parseInt(request.getParameter("seq"));

        BoardService boardService = new BoardService();
        Board board = boardService.getBoardDetail(seq);

        request.setAttribute("detail", board);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board/detail.jsp");
        dispatcher.forward(request, response);
    }
}
