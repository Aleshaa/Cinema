package edu.bsuir.cinema.model;

import java.sql.Time;
import java.time.Year;

/**
 * Created by Alesha on 01.10.2016.
 */
public class FilterView {

    private String name;
    private Time startDuration;
    private Time endDuration;
    private String[] genre;
    private String country;
    private Year year;
    private Time startTime;
    private String picture;

    public FilterView(String name, Time startDuration, Time endDuration, String[] genre, String country, Year year, Time startTime, String
            picture) {
        this.name = name;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.startTime = startTime;
        this.picture = picture;
    }

    public FilterView(String name, Time startDuration, Time endDuration, String[] genre, String country, Year year,
                      Time startTime) {
        this.name = name;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Time getStartDuration() {
        return startDuration;
    }

    public void setStartDuration(Time startDuration) {
        this.startDuration = startDuration;
    }

    public Time getEndDuration() {
        return endDuration;
    }

    public void setEndDuration(Time endDuration) {
        this.endDuration = endDuration;
    }
}
