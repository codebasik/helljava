package helljava.web;

import helljava.repository.BoardRepository;
import helljava.repository.JoinRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Created by yongjunjung on 2016. 7. 18..
 */
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Connection conn = null;                                        // null로 초기화 한다.

        try {
            String url = "jdbc:h2:tcp://localhost/~/helljava;MVCC=TRUE";        // 사용하려는 데이터베이스명을 포함한 URL 기술
            String id = "sa";                                                    // 사용자 계정
            String pw = "";                                                // 사용자 계정의 패스워드

            Class.forName("org.h2.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
            conn = DriverManager.getConnection(url, id, pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
            out.println("success connection!");                            // 커넥션이 제대로 연결되면 수행된다.


            String query = "INSERT INTO USER (NAME, PASSWORD) VALUES (?,?)";
            PreparedStatement dbStatement = null;

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "1111");
            preparedStmt.setString(2, "1111");

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();


        } catch (Exception e) {                                                    // 예외가 발생하면 예외 상황을 처리한다.
            e.printStackTrace();
            out.print("fail connection");
        }

        RequestDispatcher view = request.getRequestDispatcher("/view/main.jsp");
        view.forward(request, response);
    }
}
