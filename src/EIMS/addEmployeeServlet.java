package EIMS;

import Dao.employeeDao;
import OBJ.employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/admin/index.jsp?aside=employeeInfo&id=" +
                new employeeDao().addEmployee(new employee(
                        request.getParameter("name"),
                        request.getParameter("job"),
                        request.getParameter("hiredateStr"),
                        Integer.valueOf(request.getParameter("sal")),
                        Double.valueOf(request.getParameter("comm")),
                        Integer.valueOf(request.getParameter("mgr")),
                        Integer.valueOf(request.getParameter("dept"))
                ))
        );
    }
}
