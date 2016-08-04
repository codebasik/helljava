package helljava.repository;

import helljava.DB.DBConnection;
import helljava.DB.MemoryDB;
import helljava.domain.Board;
import org.h2.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class BoardRepository {

    public void write(HttpServletRequest request) {

        String userName = request.getParameter("username");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;

        try {

            String query = "INSERT INTO BOARD (NAME, TITLE, CONTENT) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.execute();

            DBConnection.close(conn, pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("write error!");
        } finally {
            DBConnection.close(conn,pstmt);
        }
    }

    public List<Board> list(HttpServletRequest request) {


        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Board> boardList = new ArrayList<Board>();

        StringBuffer query = new StringBuffer();

        try {

            query.append("SELECT * FROM BOARD WHERE 1=1 ");

            String searchWord = request.getParameter("searchWord");
            String queryInput = request.getParameter("queryInput");

            if (!StringUtils.isNullOrEmpty(searchWord)) {
                if ("ALL".equals(queryInput)) {
                    query.append(("AND NAME LIKE '%"+searchWord+"%' or TITLE LIKE '%"+searchWord+"%' or CONTENT LIKE '%"+searchWord+"%'"));
                } else {
                    query.append("AND " + queryInput + " LIKE '%"+searchWord+"%'");
                }
            }

            System.out.println("query = " + query.toString());

            pstmt = conn.prepareStatement(query.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Board board = new Board();
                board.setSeq(rs.getInt("BOARD_SEQ"));
                board.setUsername(rs.getString("NAME"));
                board.setTitle(rs.getString("TITLE"));
                board.setContent(rs.getString("CONTENT"));

                boardList.add(board);
            }

            return boardList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error!");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
    }

    public Board findbySeq(int seq) {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Board board = new Board();

        try {

            String query = "SELECT * FROM BOARD WHERE BOARD_SEQ=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                board.setSeq(rs.getInt("BOARD_SEQ"));
                board.setUsername(rs.getString("NAME"));
                board.setTitle(rs.getString("TITLE"));
                board.setContent(rs.getString("CONTENT"));
            }

            return board;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("findBySeq Error!");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
    }

    public List<Board> findbyContent(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getContent().contains(searchWord))
                .collect(Collectors.toList());
    }

    public List<Board> findbyName(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getUsername().contains(searchWord))
                .collect(Collectors.toList());
    }

    public List<Board> findbyTitle(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getTitle().contains(searchWord))
                .collect(Collectors.toList());
    }

    public int findByMaxSeq() {

        if (MemoryDB.boardList.size() == 0) {
            return 0;
        }

        return MemoryDB.boardList.stream()
                .max((s1, s2) -> Integer.compare(s1.getSeq(), s2.getSeq()))
                .get()
                .getSeq();
    }

    public void deleteBoard(int seq) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;

        try {

            String query = "DELETE BOARD WHERE BOARD_SEQ=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, seq);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("deleteBoard Error!");
        } finally {
            DBConnection.close(conn, pstmt);
        }
    }

}
