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
            Number sal_sum = (Number)qr.query("select sum(sal) from employee;", new ScalarHandler());
            EIMS eims = new EIMS(
                    ((Number)qr.query("select count(1) from department;", new ScalarHandler())).intValue(),
                    ((Number)qr.query("select count(1) from manager;", new ScalarHandler())).intValue(),
                    sal_sum == null ? 0 : sal_sum.intValue(),
                    ((Number)qr.query("select count(1) from employee;", new ScalarHandler())).intValue()
            );
            return eims;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new EIMS();
    }
}
