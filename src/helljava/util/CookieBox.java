package helljava.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.Map;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.io.IOException;

/**
 * Created by yongjunjung on 2016. 7. 27..
 */
public class CookieBox {

    private Map cookieMap = new java.util.HashMap();

    public CookieBox(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookieMap.put(cookies[i].getName(), cookies[i]);
            }
        }
    }

    public static Cookie createCookie(String name, String value) throws IOException {
        return new Cookie(name, URLEncoder.encode(value, "euc-kr"));
    }

    public static Cookie createCookie(String name, String value, int maxAge) throws IOException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws IOException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    public Cookie getCookie(String name) {
        return (Cookie) cookieMap.get(name);
    }

    public String getValue(String name) throws IOException {
        Cookie cookie = (Cookie) cookieMap.get(name);
        if (cookie == null) return null;
        return URLDecoder.decode(cookie.getValue(), "euc-kr");
    }

    public boolean exists(String name) {
        return cookieMap.get(name) != null;
    }

}
