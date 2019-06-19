package EIMS;

import Dao.MGRDao;
import Dao.departmentDao;
import Dao.employeeDao;
import OBJ.employee;

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
        getOptionsForform(request);
        request.setAttribute("hiddenList", true);
        request.setAttribute("employeeList", new ArrayList<employeeDao>());
        request.setAttribute("curQuery", new employee("", "", "", -1, -1, 0, 0));
        request.getRequestDispatcher("/WEB-INF/components/employeeList.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getOptionsForform(request);
        request.setAttribute("hiddenList", false);
//        request.setAttribute("employeeList", new employeeDao().getEmployeeList());
        request.setAttribute("employeeList", new ArrayList<employeeDao>());
        request.setAttribute("curQuery", new employee(
                request.getParameter("name"),
                request.getParameter("job"),
                request.getParameter("hiredateStr"),
                request.getParameter("sal") == "" ? -1 : Integer.valueOf(request.getParameter("sal")),
                request.getParameter("comm") == "" ? -1 : Double.valueOf(request.getParameter("comm")),
                Integer.valueOf(request.getParameter("mgr")),
                Integer.valueOf(request.getParameter("dept"))));
        request.getRequestDispatcher("/WEB-INF/components/employeeList.jsp").include(request, response);
    }

    private void getOptionsForform(HttpServletRequest request) {
        request.setAttribute("MgrNameList", new MGRDao().getMGRNameList());
        request.setAttribute("DeptNameList", new departmentDao().getDepartmentNameList());
    }
}
