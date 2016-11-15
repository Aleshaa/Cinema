/**
 * Created by User on 24.10.2015.
 */

package edu.bsuir.cinema.DB;

import java.sql.*;

import static edu.bsuir.cinema.DB.ConnectionConstants.*;
public class DBConnection {

    private Connection con;
    private PreparedStatement stmt;

    public DBConnection () throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // opening database connection to MySQL server
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void connectionClose() throws SQLException {
        con.close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public PreparedStatement getPrpStmt (String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
            if(con!= null)
                try{
                    con.close();
                }
                catch (SQLException ignore){
                    System.out.println("Connection did't close");
                }
            return preparedStatement;
        }
    }

}
