package edu.bsuir.cinema.DAO;

import edu.bsuir.cinema.model.Film;
import edu.bsuir.cinema.model.FilterView;

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
public class FilmDAO extends AbstractDAO<Film> {

    private ResultSet rs;

    @Override
    public List<Film> getAll(){
        Connection connection = null;
        List<Film> filmList = new ArrayList<Film>();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_ALL_FILMS);
            rs = stm.executeQuery();
            while (rs.next()) {
                Film film = new Film(rs.getInt("idFilm"), rs.getString("nameFilm"), rs.getTime("duration"),
                        rs.getString("genre"), rs.getString("country"), Year.of(rs.getInt("year")), rs.getInt("idPicture"));
                filmList.add(film);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if(connection!= null)
                try{
                    connection.close();
                }catch (SQLException ignore){
                    return filmList;
                }
        }
        return filmList;
    }

    @Override
    public Film get(int id) {
        Connection connection = null;
        Film film = new Film();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_FILM_BY_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                film.setId(rs.getInt("idFilm"));
                film.setName(rs.getString("nameFilm"));
                film.setDuration(rs.getTime("duration"));
                film.setGenre(rs.getString("genre"));
                film.setCountry(rs.getString("country"));
                film.setYear(Year.of(rs.getInt("year")));
                film.setPictureId(rs.getInt("idPicture"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if(connection!= null)
                try{
                    connection.close();
                }catch (SQLException ignore){
                    return film;
                }
        }
        return film;
    }

    @Override
    public void save(Film film) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(INSERT_INTO_FILMS);
            stm.setInt(1, film.getId());
            stm.setString(2, film.getName());
            stm.setTime(3, film.getDuration());
            stm.setString(4, film.getGenre());
            stm.setString(5, film.getCountry());
            stm.setInt(6, film.getYear().getValue());
            stm.setInt(7, film.getPictureId());
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
    public void delete(Film film) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(DELETE_FROM_FILM);
            stm.setInt(1, film.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
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
    public void update(Film film) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(UPDATE_FILM);
            stm.setString(1, film.getName());
            stm.setTime(2, film.getDuration());
            stm.setString(3, film.getGenre());
            stm.setString(4, film.getCountry());
            stm.setInt(5, film.getYear().getValue());
            stm.setInt(6, film.getPictureId());
            stm.setInt(7, film.getId());
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
    public List<Film> getResult(FilterView filterView) {
        Connection connection = null;
        List<Film> filmList = new ArrayList<Film>();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(RESULT_QUERY);
            stm.setTime(1, filterView.getStartDuration());
            stm.setTime(2, filterView.getEndDuration());
            stm.setString(3, String.join(",",filterView.getGenre()));
            stm.setString(4, String.join(",",filterView.getGenre()));
            stm.setString(5, String.join(",",filterView.getGenre()));
            stm.setString(6, String.join(",",filterView.getGenre()));
            stm.setString(7, String.join(",",filterView.getGenre()));
            stm.setString(8, filterView.getCountry());
            stm.setInt(9, filterView.getYear().getValue());
            stm.setTime(10, filterView.getStartTime());
            stm.setString(11, "%" + filterView.getName() + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setId(rs.getInt("idFilm"));
                film.setName(rs.getString("nameFilm"));
                film.setDuration(rs.getTime("duration"));
                film.setGenre(rs.getString("genre"));
                film.setCountry(rs.getString("country"));
                film.setYear(Year.of(rs.getInt("year")));
                film.setPictureId(rs.getInt("idPicture"));
                filmList.add(film);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if(connection!= null)
                try{
                    connection.close();
                }catch (SQLException ignore){
                    return filmList;
                }
        }
        return filmList;
    }
}
