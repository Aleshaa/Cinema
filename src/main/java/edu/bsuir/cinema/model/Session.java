package edu.bsuir.cinema.model;

import java.sql.Time;

/**
 * Created by Alesha on 01.10.2016.
 */
public class Session {

    private int id;
    private int idFilm;
    private Time startTime;

    public Session(){}

    public Session(int id, int idFilm, Time startTime) {
        this.id = id;
        this.idFilm = idFilm;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getFilmId() {
        return idFilm;
    }

    public void setFilmId(int idFilm) {
        this.idFilm = idFilm;
    }
}
