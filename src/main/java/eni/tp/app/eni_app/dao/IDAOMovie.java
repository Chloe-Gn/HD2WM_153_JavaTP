package eni.tp.app.eni_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public interface IDAOMovie {

    public List<Movie> getMovies();

    public Movie getMovieFromDao(long id);
}
