package utils;

import OBJ.curQuery;

public class generateConditionalStmt {
    public String getGcs(curQuery cq) {
        StringBuilder gcs = new StringBuilder("where ");
        if (!cq.name.equals("")) {
            gcs.append("employee.name like '%").append(cq.name).append("%'");
        }
        if (!cq.job.equals("")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("job like '%").append(cq.job).append("%'");
        }
        if (!cq.hiredateStr.equals("")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("date_format(hiredate, '%Y-%m-%d')='").append(cq.hiredateStr).append("'");
        }
        if (!cq.sal.equals("")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("sal=").append(cq.sal);
        }
        if (!cq.comm.equals("")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("comm=").append(cq.comm);
        }
        if (!cq.mgr.equals("-1")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("mgr=").append(cq.mgr);
        }
        if (!cq.dept.equals("-1")) {
            if (gcs.length() > 6) {
                gcs.append(" and ");
            }
            gcs.append("deptno=").append(cq.dept);
        }
        return gcs.length() > 6 ? gcs.toString() : "";
    }
}
