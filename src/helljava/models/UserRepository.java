package helljava.models;

import helljava.domain.User;

import java.util.ArrayList;

/**
 * Created by yongjunjung on 2016. 7. 23..
 */
public class UserRepository {

    public String findOneUser(String username, String password) {

        ArrayList<User> userList = User.userList;

        User user = userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("Not Found User"));

        if (!user.getUsername().equals(username)) {
            throw new IllegalArgumentException("Not Matched Password");
        }

        return user.getUsername();
    }

}
