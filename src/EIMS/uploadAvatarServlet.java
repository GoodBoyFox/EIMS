package EIMS;

import Dao.employeeDao;
import utils.getPostJSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class uploadAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("avatar"));
        new employeeDao().updateAvatar(new getPostJSON().getPostJson(request).getString("avatar"));
    }
}
