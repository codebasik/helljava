package helljava.action.Board;

import helljava.action.CommandAction;
import helljava.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yongjunjung on 2016. 8. 3..
 */
public class DeleteAction implements CommandAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        int seq = Integer.parseInt(request.getParameter("seq"));

        BoardService boardService = new BoardService();
        boardService.delete(seq);

        response.sendRedirect("/board/list");

    }
}
