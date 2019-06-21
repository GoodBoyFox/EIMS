package OBJ;

import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class EIMS {
    private int departments;
    private int leaders;
    private int wages;
    private int employees;

    public int getDepartments() {
        return departments;
    }

    public void setDepartments(int departments) {
        this.departments = departments;
    }

    public int getLeaders() {
        return leaders;
    }

    public void setLeaders(int leaders) {
        this.leaders = leaders;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EIMS{" +
                "departments=" + departments +
                ", leaders=" + leaders +
                ", wages=" + wages +
                ", employees=" + employees +
                '}';
    }

    public EIMS() {}
    public EIMS(int departments, int leaders, int wages, int employees) {
        this.departments = departments;
        this.leaders = leaders;
        this.wages = wages;
        this.employees = employees;
    }
}
