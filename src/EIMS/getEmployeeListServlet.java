package EIMS;

import Dao.MGRDao;
import Dao.departmentDao;
import Dao.employeeDao;
import OBJ.curQuery;
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
        curQuery cq = new curQuery(
                request.getParameter("name"),
                request.getParameter("job"),
                request.getParameter("sal"),
                request.getParameter("comm"),
                request.getParameter("hiredateStr"),
                request.getParameter("mgr"),
                request.getParameter("dept")
        );
        request.setAttribute("employeeList", new employeeDao().queryEmployee(generateConditionalStmt(cq)));
        request.setAttribute("curQuery", new employee(
                cq.name,
                cq.job,
                cq.hiredateStr,
                cq.sal == "" ? -1 : Integer.valueOf(cq.sal),
                cq.comm == "" ? -1 : Double.valueOf(cq.comm),
                Integer.valueOf(cq.mgr),
                Integer.valueOf(cq.dept)
        ));
        request.getRequestDispatcher("/WEB-INF/components/employeeList.jsp").include(request, response);
    }

    private void getOptionsForform(HttpServletRequest request) {
        request.setAttribute("MgrNameList", new MGRDao().getMGRNameList());
        request.setAttribute("DeptNameList", new departmentDao().getDepartmentNameList());
    }

    private String generateConditionalStmt(curQuery cq) {
        StringBuilder gcs = new StringBuilder("where ");
        if (cq.name != "") {
            gcs.append("employee.name='").append(cq.name).append("'");
        }
        if (cq.job != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("job='").append(cq.job).append("'");
        }
        if (cq.hiredateStr != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("date_format(hiredate, '%Y-%m-%d')='").append(cq.hiredateStr).append("'");
        }
        if (cq.sal != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("sal=").append(cq.sal);
        }
        if (cq.comm != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("comm=").append(cq.comm);
        }
        if (cq.mgr != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("mgr=").append(cq.mgr);
        }
        if (cq.dept != "") {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("deptno=").append(cq.dept);
        }
        return gcs.length() > 6 ? gcs.toString() : "";
    }
}
