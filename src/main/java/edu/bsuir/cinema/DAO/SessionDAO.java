package edu.bsuir.cinema.DAO;

import edu.bsuir.cinema.model.FilterView;
import edu.bsuir.cinema.model.Session;
import edu.bsuir.cinema.model.Picture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static edu.bsuir.cinema.DAO.Queries.*;

/**
 * Created by Alesha on 01.10.2016.
 */
public class SessionDAO extends AbstractDAO<Session> {

    private ResultSet rs;

    @Override
    public List<Session> getAll(){
        Connection connection = null;
        List<Session> sessionList = new ArrayList<Session>();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_ALL_SESSION);
            rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session(rs.getInt("idSession"), rs.getInt("idFilm"), rs.getTime("startTime"));
                sessionList.add(session);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sessionList;
    }

    @Override
    public Session get(int id) {
        Connection connection = null;
        Session session = new Session();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_SESSION_BY_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                session.setId(rs.getInt("idSession"));
                session.setFilmId(rs.getInt("idFile"));
                session.setStartTime(rs.getTime("startTime"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return session;
    }

    @Override
    public void save(Session session) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(INSERT_INTO_SESSION);
            stm.setInt(1, session.getId());
            stm.setInt(2, session.getFilmId());
            stm.setTime(3, session.getStartTime());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Session session) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(DELETE_FROM_SESSION);
            stm.setInt(1, session.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Session session) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(UPDATE_SESSION);
            stm.setInt(1, session.getFilmId());
            stm.setTime(2, session.getStartTime());
            stm.setInt(3, session.getId());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!= null)
                try{
                    connection.close();
                }catch (SQLException ignore){
                    System.out.println(ignore.getMessage());
                }
        }
    }

    @Override
    public List<Session> getResult(FilterView filterView) {
        return null;
    }
}
