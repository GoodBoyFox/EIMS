package Dao;

import OBJ.MGR;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MGRDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<MGR> getMGRNameList() {
        String sql = "select id, name from manager;";
        try {
            return qr.query(sql, new BeanListHandler<MGR>(MGR.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<MGR>();
    }
}
