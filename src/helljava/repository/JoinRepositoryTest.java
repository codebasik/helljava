package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yongjunjung on 2016. 7. 26..
 */
public class JoinRepositoryTest {

    JoinRepository joinRepository = new JoinRepository();

//    @Before
//    public void initialize() {
//        User user = new User("222","222");
//        MemoryDB.userList.add(user);
//    }

    @Test
    public void addUser() throws Exception {
        //joinRepository.addUser("111", "111");

    }

    @Test(expected = Exception.class)
    public void 회원아이디중복인경우() throws Exception {
        //joinRepository.addUser("222", "111");

    }


}