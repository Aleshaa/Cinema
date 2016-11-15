package edu.bsuir.cinema.model;

/**
 * Created by Alesha on 02.10.2016.
 */
public class FilmView {

    private Film film;
    private Picture picture;


    public FilmView(Film film, Picture picture) {
        this.film = film;
        this.picture = picture;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
