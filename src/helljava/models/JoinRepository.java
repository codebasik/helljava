package helljava.models;

import helljava.domain.User;
import static helljava.domain.User.userList;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class JoinRepository {

    public String saveUser(String username, String password) {

        User user = new User(username, password);
        System.out.println("user = " + user.getUsername());
        System.out.println("password = " + user.getUserpassword());

        userList.add(user);

        return user.getUsername();
    }


}
