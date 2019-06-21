package EIMS;

import Dao.employeeDao;
import utils.getOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getEmployeeInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("curEmployee", new employeeDao().getEmployee(Integer.valueOf(request.getParameter("id"))));
        new getOptions().getOptionsForform(request);
        request.getRequestDispatcher("/WEB-INF/components/employeeInfo.jsp").include(request, response);
    }
}
