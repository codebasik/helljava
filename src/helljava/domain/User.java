package helljava.domain;

import java.util.ArrayList;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class User {

    public static ArrayList<User> userList = new ArrayList<>();

    private String username;
    private String userpassword;

    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}


