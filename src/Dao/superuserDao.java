package Dao;

import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.md5;

import java.sql.SQLException;

public class superuserDao {
    private QueryRunner qr = new TxQueryRunner();

    private boolean checkName(String name) {
        String sql = "select count(1) from superuser where name=?";
        try {
            return ((Number)qr.query(sql, new ScalarHandler(), name)).intValue() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkLogin(String name, String password) {
        if (checkName(name)) {
            String sql = "select password from superuser where name=?";
            try {
                return qr.query(sql, new ScalarHandler(), name).toString().equals(new md5().createMD5(password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
