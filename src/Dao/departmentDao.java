package Dao;

import OBJ.department;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class departmentDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<department> getDepartmentList() {
        String sql = "select @rownum:=@rownum+1 as rownum, id, name, address from department, (select @rownum:=0) t where id <> 0;";
        try {
            return qr.query(sql, new BeanListHandler<department>(department.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<department>();
    }

    public List<department> getDepartmentNameList() {
        String sql = "select id, name from department;";
        try {
            return qr.query(sql, new BeanListHandler<department>(department.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<department>();
    }

    public department getDeptInfo(int id) {
        department dept = new department();
        department temp = new department();
        try {
            dept = qr.query("select id, name, address from department where id=?;", new BeanHandler<department>(department.class), id);
            temp = qr.query("select count(1) as totalPeople, sum(sal) as totalSalary, avg(sal) as avgSalary from employee where deptno=?;", new BeanHandler<department>(department.class), id);
            dept.setTotalPeople(temp.getTotalPeople());
            dept.setTotalSalary(temp.getTotalSalary());
            dept.setAvgSalary(temp.getAvgSalary());
            temp = qr.query("select max(sal) as maxWage, min(sal) as minWage from employee where deptno=?;", new BeanHandler<department>(department.class), id);
            dept.setMaxWage(temp.getMaxWage());
            dept.setMinWage(temp.getMinWage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
