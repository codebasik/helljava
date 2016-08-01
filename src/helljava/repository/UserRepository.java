package helljava.repository;

import helljava.DB.DBConnection;
import helljava.DB.MemoryDB;
import helljava.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yongjunjung on 2016. 7. 23..
 */
public class UserRepository {

    public String findByUserAndPassword(String username, String password) {

        ArrayList<User> userList = MemoryDB.userList;

        User user = userList.stream()
                .filter(u -> u.getUsername().equals(username) && u.getUserpassword().equals(password))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Fail to find User!!"));

        return user.getUsername();
    }

    public String findOneUser(String username) {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM USER WHERE NAME=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            String name = "";
            while (rs.next()) {
                name = rs.getString("name");
            }

            return name;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error!");
        }
    }

    public String findByIdAndPassword(String userId, String userPassword) {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM USER WHERE ID=? AND PASSWORD=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);
            rs = pstmt.executeQuery();

            String id = "";
            while (rs.next()) {
                id = rs.getString("ID");
            }

            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error!");
        }
    }

    public String findById(String userId) {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM USER WHERE ID=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            String id = "";
            while (rs.next()) {
                id = rs.getString("ID");
            }

            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error!");
        }
    }
}
