package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by yongjunjung on 2016. 7. 26..
 */
public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    @Before
    public void initialize() {
        User user = new User("111", "111");
        User user1 = new User("222", "222");

        MemoryDB.userList.add(user);
        MemoryDB.userList.add(user1);
    }

    @Test
    public void findByUserAndPassword() throws Exception {
        String user = userRepository.findByUserAndPassword("111", "111");
        assertEquals("111", user);

        String user1 = userRepository.findByUserAndPassword("222", "222");
        assertEquals("222", user1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 패스워드불일치_Exception() throws Exception {
        userRepository.findByUserAndPassword("111", "222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 존재하지않는회원원_Exeption() throws Exception {
        userRepository.findByUserAndPassword("333", "333");
    }

    @Test
    public void findByUser() throws Exception {
        userRepository.findOneUser("111");
    }

    @Test
    public void 회원이있을떄() throws Exception {
        userRepository.findOneUser("333");
    }



}