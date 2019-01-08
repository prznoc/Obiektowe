package kolokwium;

import java.sql.*;
import java.util.LinkedList;

class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private void connect()throws NotConnected {
        try {
            for (int i=0; i<3; ++i) {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/pnocon", "pnocon", "tCpuCWH4wsvL4d5T");
                if (conn != null) break;
            }
        }
        catch (SQLException ex) {
            throw new NotConnected();
        }
        catch (Exception e){ e.printStackTrace(); }
    }


    void addResult(Result book)throws Exception {
        try {
            connect();
            stmt = conn.createStatement();
            String added = ("'"+book.player1+"'"+",'"+book.player2+"','"+book.result);
            stmt.executeUpdate("INSERT INTO books VALUES ("+ added +");");
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException ex) {
                }
                stmt = null;
            }
        }
    }

    void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "RESULTS"
                + "  (player1           VARCHAR(64),"
                + "   player2           VARCHAR(64),"
                + "   result VARCHAR(4))";

        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
}
