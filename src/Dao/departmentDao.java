package Dao;

import OBJ.department;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class departmentDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<department> getDepartmentList() {
        String sql = "select @rownum:=@rownum+1 as rownum, id, name, address from department, (select @rownum:=0) t;";
        try {
            return qr.query(sql, new BeanListHandler<department>(department.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
