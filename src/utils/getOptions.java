package utils;

import Dao.MGRDao;
import Dao.departmentDao;

import javax.servlet.http.HttpServletRequest;

public class getOptions {
    public void getOptionsForform(HttpServletRequest request) {
        request.setAttribute("MgrNameList", new MGRDao().getMGRNameList());
        request.setAttribute("DeptNameList", new departmentDao().getDepartmentNameList());
    }
}
