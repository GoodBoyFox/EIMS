package Dao;

import OBJ.employee;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class employeeDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<employee> queryEmployee(String gcs) {
        String sql = String.format("select @rownum:=@rownum+1 as rownum, x.* from (select employee.id as id, employee.name as name, " +
                "job, hiredate, sal, comm, mgr, deptno, manager.name as mgrName, department.name as deptName from employee " +
                "join manager on mgr=manager.id join department on deptno=department.id %s order by hiredate desc limit 9999) x, (select @rownum:=0) t;", gcs);
        try {
            return qr.query(sql, new BeanListHandler<employee>(employee.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<employee>();
    }

    public employee getEmployee(int id) {
        String sql = "select id, name, job, hiredate, sal, comm, mgr, deptno from employee where id=?;";
        try {
            return qr.query(sql, new BeanHandler<employee>(employee.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new employee();
    }

    public int addEmployee(employee e) {
        String sql = "insert into employee(name ,job, hiredate, sal, comm, mgr, deptno) values(?, ?, ?, ?, ?, ?, ?);";
        try {
            qr.update(sql, e.getName(), e.getJob(), e.getHiredateStr(), e.getSal(), e.getComm(), e.getMgr(), e.getDeptno());
            return ((Number)qr.query("select max(id) from employee;", new ScalarHandler())).intValue();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return -1;
    }

    public int updateEmployee(employee e) {
        String sql = "update employee set name=?, job=?, hiredate=?, sal=?, comm=?, mgr=?, deptno=? where id=?";
        try {
            qr.update(sql, e.getName(), e.getJob(), e.getHiredateStr(), e.getSal(), e.getComm(), e.getMgr(), e.getDeptno(), e.getId());
            return e.getId();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return -1;
    }

    public void updateAvatar(String avatar, int id) {
        String sql = "update employee set avatar=? where id=?;";
        try {
            qr.update(sql, avatar, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAvatar(int id) {
        String sql = "select avatar from employee where id=?;";
        try {
            return (String)qr.query(sql, new ScalarHandler(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
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
