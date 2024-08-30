package eni.tp.app.eni_app.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Movie {

    @Positive (message = "Le champ doit être rempli")
    public Long id;

    @NotBlank (message = "Le champ doit être rempli")
    public String title;
    // Temporaire => Plus tard les notes = associations avis
    @Positive (message = "Le champ doit être rempli")
    public int note;
    @Positive (message = "Le champ doit être rempli")
    public int year;
    @Positive (message = "Le champ doit être rempli")
    public int duration;

    @NotBlank (message = "Le champ doit être rempli")
    public String synopsis;

    public Movie(Long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public Movie(){

    };

    /**
     * Récupère la note sur un format int
     * @return
     */
    public int getNote() {
        // Plus tard quand on va supprimer le int note
        // La note sera la moyenne des avis
        return note;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
