package edu.bsuir.cinema.model;

import java.sql.Date;
import java.sql.Time;
import java.time.Year;

/**
 * Created by Alesha on 01.10.2016.
 */
public class Film {

    private int id;
    private String name;
    private Time duration;
    private String genre;
    private String country;
    private Year year;
    private int idPicture;

    public Film(){}
    public Film(int id, String name, Time duration, String genre, String country, Year year, int idPicture) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.idPicture = idPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getPictureId() {
        return idPicture;
    }

    public void setPictureId(int idPicture) {
        this.idPicture = idPicture;
    }
}
