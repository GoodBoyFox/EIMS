package utils;

import OBJ.curQuery;

public class generateConditionalStmt {
    public String getGcs(curQuery cq) {
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
