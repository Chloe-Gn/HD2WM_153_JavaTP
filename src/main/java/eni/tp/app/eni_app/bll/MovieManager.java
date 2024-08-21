package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.dao.DAOMovieMock;
import eni.tp.app.eni_app.dao.IDAOMovie;
import eni.tp.app.eni_app.dao.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieManager {

    @Autowired
    IDAOMovie daoMovie;

    public List<Movie> selectMovies() {

        List<Movie> movies = daoMovie.getMovies();

        return movies;


    }
}
