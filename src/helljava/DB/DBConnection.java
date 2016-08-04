package helljava.DB;

import java.sql.*;

/**
 * Created by yongjunjung on 2016. 8. 1..
 */
public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;                                                     // null로 초기화 한다.

        try {
            String url = "jdbc:h2:tcp://localhost/~/helljava;MVCC=TRUE";            // 사용하려는 데이터베이스명을 포함한 URL 기술
            String id = "sa";                                                       // 사용자 계정
            String pw = "";                                                         // 사용자 계정의 패스워드

            Class.forName("org.h2.Driver");                                         // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
            conn = DriverManager.getConnection(url, id, pw);                        // DriverManager 객체로부터 Connection 객체를 얻어온다.

            return conn;

        } catch (Exception e) {                                                     // 예외가 발생하면 예외 상황을 처리한다.
            e.printStackTrace();
            throw new IllegalArgumentException("DataBase Connection Error!");
        }
    }

    public static void close(Connection conn)              // ps,conn 닫기 반복이라 뺌
    {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt)              // ps,conn 닫기 반복이라 뺌
    {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        if(rs != null)
        {
            try{
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        close(conn, pstmt);
    }


}
