package eni.tp.app.eni_app.dao;

public class Movie {
    public long id;
    public String title;
    private int year;
    private int duration;
    public String synopsis;
    public String uri;
    // Temporaire => plus tard les notes = associations d'avis
    public int starReviews = 3;
    public String slug;

    public Movie(long id, String title, int year, int duration, String synopsis, String uri) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.uri = uri;
        this.slug = title.toLowerCase().replaceAll("\\s+", "-");
    }


    public int getStarReviews() {
      // plus tard, quand on va supprimer le int note, la note sera la moyenne des avis
        return this.starReviews;
    }
}
