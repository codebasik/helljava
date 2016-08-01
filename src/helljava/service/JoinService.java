package helljava.service;

import helljava.repository.JoinRepository;
import helljava.repository.UserRepository;
import org.h2.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yongjunjung on 2016. 7. 27..
 */
public class JoinService {

    public String saveUser(HttpServletRequest request) {

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserRepository userRepository = new UserRepository();
        String user = userRepository.findById(id);

        if (!StringUtils.isNullOrEmpty(null)) {
            throw new IllegalArgumentException("중복된 ID가 존재합니다.");
        }

        JoinRepository joinRepository = new JoinRepository();
        joinRepository.addUser(id, username, password, email);

        HttpSession session = request.getSession();
        session.setAttribute("s_id", id);
        session.setMaxInactiveInterval(60 * 3);                         //로그인시간 3*60초

        return username;
    }

}
