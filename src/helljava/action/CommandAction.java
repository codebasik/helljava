package helljava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yongjunjung on 2016. 8. 3..
 */
public interface CommandAction {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
