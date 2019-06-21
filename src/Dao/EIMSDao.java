package Dao;

import OBJ.EIMS;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class EIMSDao {
    public EIMS getEIMS() {
        QueryRunner qr = new TxQueryRunner();
        try {
            EIMS eims = new EIMS(
                    ((Number)qr.query("select count(1) from department;", new ScalarHandler())).intValue(),
                    ((Number)qr.query("select count(1) from manager;", new ScalarHandler())).intValue(),
                    ((Number)qr.query("select sum(sal) from employee;", new ScalarHandler())).intValue(),
                    ((Number)qr.query("select count(1) from employee;", new ScalarHandler())).intValue()
            );
            return eims;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new EIMS();
    }
}
