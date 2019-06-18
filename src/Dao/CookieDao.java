package Dao;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对于Cookie的操作池
 */
public class CookieDao extends HttpServlet {
    /**
     * 通过key返回cookie的value
     * @param request
     * @param key
     * @return
     */
    public String getValueByKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 通过cookie中保存的邮件地址和加密密码和userId验证用户是否已经登录。
     * @param request
     * @return
     */
    public boolean checkLogined(HttpServletRequest request) {
        String name = getValueByKey(request, "name");
        String password = getValueByKey(request, "password");

        if (name != null && password != null) {
            if (new superuserDao().checkLogin(name, password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在当前request中添加cookie
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxAge
     */
    public void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieMaxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
