package helljava.repository;

import helljava.DB.DBConnection;
import helljava.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class JoinRepository {

    public void addUser(String username, String password) {

        UserRepository userRepository = new UserRepository();
        User findUser = userRepository.findOneUser(username);

        if (findUser != null) {
            throw new IllegalArgumentException("duplication username");
        }

        Connection conn = DBConnection.getConnection();

        try {

            String query = "INSERT INTO USER (NAME, PASSWORD) VALUES (?,?)";

            PreparedStatement preparedStmt = null;

            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);
            preparedStmt.execute();

            DBConnection.close(conn, preparedStmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
