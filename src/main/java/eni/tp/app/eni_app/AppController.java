package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.MovieManager;
import eni.tp.app.eni_app.bo.Movie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.LocaleResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SessionAttributes({"loggedUser"})
@Controller
public class AppController {

    @Autowired
    MovieManager movieManager;

    @Autowired
    LocaleResolver localeResolver;

    @GetMapping("change-lang/{lang}")
    public String changeLang(@PathVariable("lang") String lang, HttpServletRequest request, HttpServletResponse response) {
        Locale locale = Locale.forLanguageTag(lang);
        localeResolver.setLocale(request, response, locale);
        return "redirect:/";
    }

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("movies")
    public String movies(Model model) {
        // Récuperer la liste
       List<Movie> movies = movieManager.getAll();

        // Envoyer les films dans le modele
        model.addAttribute("movies", movies);

        // Envoyer la note maximale
        List<Integer> maxStars = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("maxStars", maxStars);

        return "movies";
    }

    @GetMapping("movie-detail/{id}")
    public String movieDetail(@PathVariable("id") long id, Model model) {
        // Récupérer le film par son id
        Movie movie = movieManager.getById(id);

        // Si le film est null (donc n'existe pas)
        if (movie == null) {
            // Afficher le message erreur
            return "movie-not-found";
        }

        // Envoyer le film dans la vue donc le modèle
        model.addAttribute("movie", movie);
        // Envoyer la note maximale
        List<Integer> maxStars = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("maxStars", maxStars);

        return "movie-detail";
    }
}
