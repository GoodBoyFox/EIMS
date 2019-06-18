package EIMS;

import Dao.CookieDao;
import Dao.superuserDao;
import org.json.JSONObject;
import utils.getPostJSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class checkLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        JSONObject loginInfo = new getPostJSON().getPostJson(request);
        if (loginInfo.has("name") && loginInfo.has("password") && loginInfo.has("vcode")) {
            if (loginInfo.getString("vcode").equals(request.getSession().getAttribute("vcode"))) {
                if (new superuserDao().checkLogin(loginInfo.getString("name"), loginInfo.getString("password"))) {
                    CookieDao cookieDao = new CookieDao();
                    cookieDao.addCookie(response, "name", loginInfo.getString("name"), -1);
                    cookieDao.addCookie(response, "password", loginInfo.getString("password"), -1);
                    writer.print("yes");
                } else {
                    writer.print("用户名或密码错误!");
                }
            } else {
                writer.print("验证码错误!");
            }
        } else {
            writer.print("请将信息填写完整!");
        }
    }
}
