package edu.bsuir.cinema.controller;

import edu.bsuir.cinema.DAO.AbstractDAO;
import edu.bsuir.cinema.DAO.FilmDAO;
import edu.bsuir.cinema.DAO.PictureDAO;
import edu.bsuir.cinema.model.Film;
import edu.bsuir.cinema.model.FilmView;
import edu.bsuir.cinema.model.FilterView;
import edu.bsuir.cinema.model.Picture;
import edu.bsuir.cinema.utils.ParseUtil;
import edu.bsuir.cinema.utils.UserFriendlyException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static edu.bsuir.cinema.utils.parametersConstants.*;
import static edu.bsuir.cinema.utils.pageConstants.*;

/**
 * Created by Alesha on 01.10.2016.
 */
public class CinemaController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request,
                            HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        AbstractDAO<Film> filmDAO = new FilmDAO();
        AbstractDAO<Picture> pictureAbstractDAO = new PictureDAO();
        try {
            Time startDuration, endDuration, startTime;
            String[] genre;
            String country, name;
            Year year;
            if (request.getParameter(GENRE) != null && !request.getParameter(GENRE).isEmpty())
                genre = request.getParameterValues(GENRE);
            else
                throw new UserFriendlyException(GENRE);
            if (request.getParameter(START_DURATION) != null && !request.getParameter(START_DURATION).isEmpty())
                startDuration = Time.valueOf(request.getParameter(START_DURATION) + ":00");
            else
                throw new UserFriendlyException(START_DURATION);
            if (request.getParameter(END_DURATION) != null && !request.getParameter(END_DURATION).isEmpty())
                endDuration = Time.valueOf(request.getParameter(END_DURATION) + ":00");
            else
                throw new UserFriendlyException(END_DURATION);
            if (request.getParameter(START_TIME) != null && !request.getParameter(START_TIME).isEmpty())
                startTime = Time.valueOf(request.getParameter(START_TIME) + ":00");
            else
                throw new UserFriendlyException(START_TIME);
            if (request.getParameter(COUNTRY) != null && !request.getParameter(COUNTRY).isEmpty())
                country = request.getParameter(COUNTRY);
            else
                throw new UserFriendlyException(COUNTRY);
            if (request.getParameter(YEAR) != null && !request.getParameter(YEAR).isEmpty())
                year = Year.of(Integer.parseInt(request.getParameter(YEAR)));
            else
                throw new UserFriendlyException(YEAR);
            if (request.getParameter(KEY_WORD) != null && !request.getParameter(KEY_WORD).isEmpty())
                name = request.getParameter(KEY_WORD);
            else
                name = "";
            List<Film> filmList = filmDAO.getResult(new FilterView(name, startDuration, endDuration, genre, country, year, startTime));
            List<FilmView> filmViewList = new ArrayList<FilmView>();
            for(Film film : filmList) {
                filmViewList.add(new FilmView(film, pictureAbstractDAO.get(film.getPictureId())));
            }
            request.setAttribute(FILM_LIST, filmViewList);
            ParseUtil.writeIntoExcel(filmList);
            getServletContext().getRequestDispatcher(RESULT_PAGE).forward(request, response);

        } catch (UserFriendlyException exception) {
            request.setAttribute(ERROR_MESSAGE, exception.getMessage());
            getServletContext().getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }
}
