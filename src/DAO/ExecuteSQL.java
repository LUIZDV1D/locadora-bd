package DAO;

import java.sql.Connection;

/**
 *
 * @author David O
 */
public class ExecuteSQL {
    private Connection con;
    
    public ExecuteSQL(Connection con) {
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
}
