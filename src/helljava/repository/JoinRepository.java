package helljava.repository;

import helljava.domain.User;
import static helljava.DB.MemoryDB.userList;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class JoinRepository {

    public String addUser(String username, String password) {

        UserRepository userRepository = new UserRepository();
        long count = userRepository.countUser(username);

        if (count > 0) {
            throw new IllegalArgumentException("duplication username");
        }

        User user = new User(username, password);
        userList.add(user);

        return user.getUsername();
    }


}
