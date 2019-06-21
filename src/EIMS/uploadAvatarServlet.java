package EIMS;

import Dao.employeeDao;
import org.json.JSONObject;
import utils.getPostJSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class uploadAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject json = new getPostJSON().getPostJson(request);
        new employeeDao().updateAvatar(json.getString("avatar"), json.getInt("id"));
    }
}
