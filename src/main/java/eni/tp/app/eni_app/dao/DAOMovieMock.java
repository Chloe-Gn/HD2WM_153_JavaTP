package eni.tp.app.eni_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DAOMovieMock implements IDAOMovie {

    @Override
    public List<Movie> getMovies() {

        List movies = new ArrayList<Movie>();

        movies.add(new Movie(1L, "Forrest Gump", 1992, 124, "todo"));
        movies.add(new Movie(2L, "Into the Wild", 2016, 137, "todo"));
        movies.add(new Movie(3L, "Into the Wound", 2016, 137, "todo"));

        return movies;
    }
}
