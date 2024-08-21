package eni.tp.app.eni_app.dao;

public class Movie {
    public long id;
    public String title;
    private int year;
    private int duration;
    public String synopsis;

    public Movie(long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }
}
