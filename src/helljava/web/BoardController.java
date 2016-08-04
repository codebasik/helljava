package helljava.web;

import helljava.action.Board.*;
import helljava.action.CommandAction;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongjunjung on 2016. 7. 23..
 */
public class BoardController extends HttpServlet {

    private Map boardCommand = new HashMap();

    public void init(ServletConfig config) {
        boardCommand.put("/board/list", new ListAction());
        boardCommand.put("/board/detail", new DetailAction());
        boardCommand.put("/board/delete", new DeleteAction());
        boardCommand.put("/board/write", new WriteAction());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        proRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("request = " + URLDecoder.decode(request.getParameter("searchWord")));
        proRequest(request, response);
    }

    protected void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String cmd = request.getRequestURI();
        CommandAction com = null;

        try {
            com = (CommandAction) boardCommand.get(cmd);
            com.execute(request, response);
        } catch(Throwable e) {
            e.printStackTrace();
        }
    }
}

