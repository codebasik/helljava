package helljava.web;

import helljava.repository.BoardRepository;
import helljava.repository.JoinRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

//        JoinRepository joinRepository = new JoinRepository();
//        joinRepository.addUser("정용준", "111");
//
//        BoardRepository boardRepository = new BoardRepository();
//        boardRepository.write("정용준", "첫번째", "첫번째 글이에요");
//        boardRepository.write("정용준", "두번째", "두번째 글이에요");

        RequestDispatcher view = request.getRequestDispatcher("/view/main.jsp");
        view.forward(request,response);
    }
}
