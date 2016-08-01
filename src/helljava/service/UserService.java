package helljava.service;

import helljava.repository.UserRepository;
import helljava.util.CookieBox;
import org.h2.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 8. 1..
 */
public class UserService {

    private static final String SAVE_ID_OK = "on";

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("userid");
        String password = request.getParameter("userpassword");
        String isSave = request.getParameter("isSaveCheck");

        UserRepository userRepository = new UserRepository();
        String userID = userRepository.findByIdAndPassword(id, password);

        if (StringUtils.isNullOrEmpty(userID)) {
            throw new IllegalArgumentException("일치하는 회원이 존재하지 않습니다.");
        }

        //로그인 성공한 사용자는 session 저장
        HttpSession session = request.getSession();
        session.setAttribute("s_id", id);
        session.setMaxInactiveInterval(60 * 3);

        //아이디저장을 클릭한 사용자는 쿠키에 저장
        if (SAVE_ID_OK.equals(isSave)) {
            response.addCookie(CookieBox.createCookie("c_id", id));
            response.addCookie(CookieBox.createCookie("isSaveCheck", "Y"));
        } else {
            response.addCookie(CookieBox.createCookie("c_id", "", 0));
            response.addCookie(CookieBox.createCookie("isSaveCheck", "", 0));
        }
    }
}
