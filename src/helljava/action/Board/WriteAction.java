package helljava.action.Board;

import helljava.action.CommandAction;
import helljava.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yongjunjung on 2016. 8. 3..
 */
public class WriteAction implements CommandAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("UTF-8");
        System.out.println("request = " + request.getParameter("searchWord"));
        String method = request.getMethod();

        if ("GET".equals(method)) {
            RequestDispatcher view = request.getRequestDispatcher("/view/board/write.jsp");
            view.forward(request, response);
        } else {
            BoardService boardService = new BoardService();
            boardService.addBoard(request);
            response.sendRedirect("/board/list");
        }

    }
}
