package EIMS;

import Dao.employeeDao;
import OBJ.curQuery;
import org.json.JSONObject;
import utils.generateConditionalStmt;
import utils.getPostJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doDeleteServlet")
public class doDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject json = new getPostJSON().getPostJson(request);
        curQuery cq = new curQuery(
                json.getString("name"),
                json.getString("job"),
                json.getString("sal"),
                json.getString("comm"),
                json.getString("hiredate"),
                json.getString("mgr"),
                json.getString("dept")
        );
        new employeeDao().deleteAllQuery(new generateConditionalStmt().getGcs(cq));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new employeeDao().deleteEmployee(Integer.valueOf(request.getParameter("id")));
    }
}
