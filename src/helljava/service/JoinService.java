package helljava.service;

import helljava.repository.JoinRepository;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yongjunjung on 2016. 7. 27..
 */
public class JoinService {

    public String saveUser(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");

        JoinRepository joinRepository = new JoinRepository();
        String joinUserName = joinRepository.addUser(username, password);

        return joinUserName;
    }

}
