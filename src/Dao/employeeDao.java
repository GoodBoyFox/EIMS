package Dao;

import OBJ.employee;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class employeeDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<employee> getEmployeeList() {
        String sql = "select @rownum:=@rownum+1 as rownum, employee.id as id, employee.name as name, " +
                "job, hiredate, sal, comm, mgr, deptno, manager.name as mgrName, department.name as deptName from employee " +
                "join manager on mgr=manager.id join department on deptno=department.id, (select @rownum:=0) t;";
        try {
            return qr.query(sql, new BeanListHandler<employee>(employee.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
