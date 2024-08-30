package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile("mysql")
public class DAOMovieMySql implements IDAOMovie {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();

            movie.setId(rs.getLong("id"));
            movie.setTitle(rs.getString("title"));
            movie.setNote(rs.getInt("note"));
            movie.setYear(rs.getInt("year"));
            movie.setDuration(rs.getInt("duration"));
            movie.setSynopsis(rs.getString("synopsis"));


            return movie;
        }
    };


    @Override
    public List<Movie> selectMovies() {
        return jdbcTemplate.query("SELECT * FROM movie", MOVIE_ROW_MAPPER);
    }

    //A note
    @Override
    public Movie selectMovieById(Long id) {
        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movie WHERE id = ?", MOVIE_ROW_MAPPER, id);

        // Si on trouve aucun element on retourne null
        if (movies.size() == 0) {
            return null;
        }

        //Retourner le premier element
        return movies.get(0);
    }

    @Override
    public void saveMovie(Movie movie) {
        // Si le film existe déjà, alors c'est un update
        if (selectMovieById(movie.getId()) != null) {

            jdbcTemplate.update("UPDATE movie SET title = ?, note =?, year = ?, duration = ?, synopsis = ? WHERE id = ?", movie.title, movie.note, movie.year, movie.duration, movie.synopsis, movie.id);

            //Return dans un void ne retourne pas une valeur mais stopppe le code.
            return;
        }

        //Sinon insert
        jdbcTemplate.update("INSERT INTO movie(title, note, year, duration, synopsis) VALUES (?,?,?,?,?)", movie.title, movie.note, movie.year, movie.duration, movie.synopsis);


    }
}



