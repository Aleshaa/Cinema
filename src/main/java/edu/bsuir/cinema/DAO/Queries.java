package edu.bsuir.cinema.DAO;

/**
 * Created by Alesha on 01.10.2016.
 */
public interface Queries {

    String GET_ALL_FILMS = "SELECT idFilm, nameFilm, duration, genre, country, year, idPicture " +
            "FROM Film";
    String GET_FILM_BY_ID = "SELECT idFilm, nameFilm, duration, genre, country, year, idPicture " +
            "FROM Film WHERE idFilm = ?";
    String INSERT_INTO_FILMS = "INSERT INTO Film(idFilm, nameFilm, duration, genre, country, year, idPicture) VALUES" +
            "(?,?,?,?,?,?,?)";
    String DELETE_FROM_FILM = "DELETE FROM Film WHERE idFilm = ?";
    String UPDATE_FILM = "UPDATE Film SET nameFilm = ?, duration = ?, genre = ?, country = ?, year = ?, idPicture = ?" +
            " WHERE idFilm = ?";

    String GET_ALL_PICTURES = "SELECT idPicture, fileName, uploadedName, width, height FROM Picture";
    String GET_PICTURE_BY_ID = "SELECT idPicture, fileName, uploadedName, width, height FROM Picture WHERE idPicture " +
            "= ?";
    String INSERT_INTO_PICTURE = "INSERT INTO Picture(idPicture, fileName, uploadedName, width, height) VALUES(?,?,?," +
            "?,?)";
    String DELETE_FROM_PICTURE = "DELETE FROM Picture WHERE idPicture = ?";
    String UPDATE_PICTURE = "UPDATE Picture SET fileName = ?, uploadedName = ?, width = ?, height = ? WHERE idPicture" +
            " = ?";

    String GET_ALL_SESSION = "SELECT idSession, idFilm, startTime FROM Session";
    String GET_SESSION_BY_ID = "SELECT idSession, idFilm, startTime FROM Session WHERE idSession = ?";
    String INSERT_INTO_SESSION = "INSERT INTO Session(idSession, idFilm, startTime) VALUES(?,?,?)";
    String DELETE_FROM_SESSION = "DELETE FROM Session WHERE idSession = ?";
    String UPDATE_SESSION = "UPDATE Session SET idFilm = ?, startTime = ? WHERE idSession = ?";

    String RESULT_QUERY = "SELECT *\n" +
            "FROM Film film\n" +
            "INNER JOIN Session sess ON film.idFilm = sess.idFilm\n" +
            "WHERE (film.duration BETWEEN ? AND ?)\n" +
            "      AND film.genre IN (SPLIT_STRING(?,',',1),\n" +
            "                         SPLIT_STRING(?,',',2),\n" +
            "                         SPLIT_STRING(?,',',3),\n" +
            "                         SPLIT_STRING(?,',',4),\n" +
            "                         SPLIT_STRING(?,',',5)) AND film.country = ? \n" +
            "      AND film.year = ? AND sess.startTime > ? \n" +
            "      AND film.nameFilm LIKE ?";

}
