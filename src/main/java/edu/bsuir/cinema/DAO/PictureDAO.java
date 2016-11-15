package edu.bsuir.cinema.DAO;

import edu.bsuir.cinema.model.FilterView;
import edu.bsuir.cinema.model.Picture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.bsuir.cinema.DAO.Queries.*;

/**
 * Created by Alesha on 01.10.2016.
 */

public class PictureDAO extends AbstractDAO<Picture> {

    private ResultSet rs;

    @Override
    public List<Picture> getAll(){
        Connection connection = null;
        List<Picture> pictureList = new ArrayList<Picture>();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_ALL_PICTURES);
            rs = stm.executeQuery();
            while (rs.next()) {
                Picture picture = new Picture(rs.getInt("idPicture"), rs.getString("fileName"),
                        rs.getString("uploadedName"), rs.getInt("width"), rs.getInt("height"));
                pictureList.add(picture);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pictureList;
    }

    @Override
    public Picture get(int id) {
        Connection connection = null;
        Picture picture = new Picture();
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(GET_PICTURE_BY_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                picture.setId(rs.getInt("idPicture"));
                picture.setFileName(rs.getString("fileName"));
                picture.setUploadedName(rs.getString("uploadedName"));
                picture.setWidth(rs.getInt("width"));
                picture.setHeight(rs.getInt("height"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return picture;
    }

    @Override
    public void save(Picture picture) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(INSERT_INTO_PICTURE);
            stm.setInt(1, picture.getId());
            stm.setString(2, picture.getFileName());
            stm.setString(3, picture.getUploadedName());
            stm.setInt(4, picture.getWidth());
            stm.setInt(5, picture.getHeight());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Picture picture) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(DELETE_FROM_PICTURE);
            stm.setInt(1, picture.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Picture picture) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(UPDATE_PICTURE);
            stm.setString(1, picture.getFileName());
            stm.setString(2, picture.getUploadedName());
            stm.setInt(3, picture.getWidth());
            stm.setInt(4, picture.getHeight());
            stm.setInt(5, picture.getId());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Picture> getResult(FilterView filterView) {
        return null;
    }
}
