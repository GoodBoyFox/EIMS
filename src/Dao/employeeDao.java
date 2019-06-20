package Dao;

import OBJ.employee;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
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
        return new ArrayList<employee>();
    }

    public List<employee> queryEmployee(String gcs) {
        String sql = String.format("select @rownum:=@rownum+1 as rownum, employee.id as id, employee.name as name, " +
                "job, hiredate, sal, comm, mgr, deptno, manager.name as mgrName, department.name as deptName from employee " +
                "join manager on mgr=manager.id join department on deptno=department.id, (select @rownum:=0) t %s;", gcs);
        try {
            return qr.query(sql, new BeanListHandler<employee>(employee.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<employee>();
    }

    public void deleteEmployee(int id) {
        String sql = "delete from employee where id=?;";
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllQuery(String gcs) {
        String sql = String.format("delete from employee %s;", gcs);
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
