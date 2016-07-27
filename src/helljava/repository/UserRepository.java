package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.User;

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

    public User findOneUser(String username) {

        ArrayList<User> userList = MemoryDB.userList;

        return userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
