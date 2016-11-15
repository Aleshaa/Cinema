package edu.bsuir.cinema.DAO;

import edu.bsuir.cinema.DB.DBConnection;
import edu.bsuir.cinema.model.FilterView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Alesha on 01.10.2016.
 */
public abstract class AbstractDAO<T> {

    private DBConnection dbConnection;

    protected Connection getConnection() {
        dbConnection = null;
        try {
            dbConnection = new DBConnection();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dbConnection.getCon();
    }

    public abstract List<T> getAll();
    public abstract T get(int id);
    public abstract void save(T t);
    public abstract void delete(T t);
    public abstract void update(T t);
    public abstract List<T> getResult(FilterView filterView);
}
