package eni.tp.app.eni_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DAOMovieMock implements IDAOMovie {

    List<Movie> movies = Arrays.asList(
            new Movie(1L, "Forrest Gump", 1992, 124, "Sur un banc, à Savannah, en Géorgie, Forrest Gump attend le bus. Comme celui-ci tarde à venir, le jeune homme raconte sa vie à ses compagnons d'ennui. A priori, ses capacités intellectuelles plutôt limitées ne le destinaient pas à de grandes choses. Qu'importe. Forrest Gump, sans jamais rien y comprendre, s'associa à tous les grands événements de l'Histoire de son pays.","forrest-gump.jpg"),
            new Movie(2L, "Into the Wild", 2016, 137, "Tout juste diplômé, Christopher McCandless, 22 ans, est promis à un brillant avenir. Pourtant, tournant le dos à l'existence confortable et sans surprise qui l'attend, le jeune homme décide de prendre la route en laissant tout derrière lui. Des champs de blé du Dakota aux flots tumultueux du Colorado, en passant par les communautés hippies de Californie, Christopher va rencontrer des personnages hauts en couleur. Chacun, à sa manière, va façonner sa vision de la vie et des autres.","into-the-wild.webp"),
            new Movie(3L, "The Big Short", 2011, 137, "Wall Street. 2005. Profitant de l'aveuglement généralisé des grosses banques, des médias et du gouvernement, quatre outsiders anticipent l'explosion de la bulle financière et mettent au point le casse du siècle ! Michael Burry, Mark Baum, Jared Vennett et Ben Rickert : des personnages visionnaires et hors du commun qui vont parier contre les banques et tenter de rafler la mise.","the-big-short")

    );


    @Override
    public List<Movie> getMovies() {



        return movies;
    }

    @Override
    public Movie getMovieFromDao(long id) {

        Movie movieToFind = movies.stream().filter(x -> x.id == id).findFirst().orElse(null);

        return movieToFind;
    }
}
