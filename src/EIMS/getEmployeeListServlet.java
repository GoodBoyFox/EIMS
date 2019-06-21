package EIMS;

import Dao.MGRDao;
import Dao.departmentDao;
import Dao.employeeDao;
import OBJ.curQuery;
import OBJ.employee;
import utils.generateConditionalStmt;
import utils.getOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class getEmployeeListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new getOptions().getOptionsForform(request);
        request.setAttribute("hiddenList", true);
        request.setAttribute("employeeList", new ArrayList<employeeDao>());
        request.setAttribute("curQuery", new employee("", "", "", -1, -1, -1, -1));
        request.getRequestDispatcher("/WEB-INF/components/employeeList.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new getOptions().getOptionsForform(request);
        request.setAttribute("hiddenList", false);
        curQuery cq = new curQuery(
                request.getParameter("name"),
                request.getParameter("job"),
                request.getParameter("sal"),
                request.getParameter("comm"),
                request.getParameter("hiredateStr"),
                request.getParameter("mgr"),
                request.getParameter("dept")
        );
        request.setAttribute("employeeList", new employeeDao().queryEmployee(new generateConditionalStmt().getGcs(cq)));
        request.setAttribute("curQuery", new employee(
                cq.name,
                cq.job,
                cq.hiredateStr,
                cq.sal.equals("") ? -1 : Integer.valueOf(cq.sal),
                cq.comm.equals("") ? -1 : Double.valueOf(cq.comm),
                Integer.valueOf(cq.mgr),
                Integer.valueOf(cq.dept)
        ));
        request.getRequestDispatcher("/WEB-INF/components/employeeList.jsp").include(request, response);
    }
}
