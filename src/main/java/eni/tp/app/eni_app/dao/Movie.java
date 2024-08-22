package eni.tp.app.eni_app.dao;

public class Movie {
    public long id;
    public String title;
    public int year;
    public int duration;
    public String synopsis;
    public String uri;
    // Temporaire => plus tard les notes = associations d'avis
    public int starReviews;
    public String slug;

    public Movie(long id, String title, int year, int duration, String synopsis, String uri, int starReviews) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.uri = uri;
        this.starReviews = starReviews;
        this.slug = title.toLowerCase().replaceAll("\\s+", "-");
    }


    public int getStarReviews() {
      // plus tard, quand on va supprimer le int note, la note sera la moyenne des avis
        return this.starReviews;
    }
}
