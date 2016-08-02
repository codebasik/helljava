package helljava.repository;

import helljava.DB.DBConnection;
import helljava.DB.MemoryDB;
import helljava.domain.Board;

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

        try {

            String query = "INSERT INTO BOARD (NAME, TITLE, CONTENT) VALUES (?,?,?)";

            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.execute();

            DBConnection.close(conn, pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("write error!");
        }
    }

    public List<Board> findAll(String searchWord) {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Board> boardList = new ArrayList<Board>();

        StringBuffer query = new StringBuffer();

        try {

            query.append("SELECT * FROM BOARD");

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

    public Board findbySeq(int seq) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getSeq() == seq)
                .findFirst()
                .orElse(null);
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
        MemoryDB.boardList.removeIf(b -> b.getSeq() == seq);
    }

}
