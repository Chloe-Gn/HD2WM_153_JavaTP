package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bll.MovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SessionAttributes({"loggedUser"})
@Controller
public class AppController {

    @Autowired
    MovieManager movieManager;


    @GetMapping("")
    public String accueil() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "accueil";
    }


    @GetMapping("liste-films")
    public String listeFilms() {

        return "liste-films";
    }


    @GetMapping("films")
    public String listingFilms(Model model) {

        model.addAttribute("movies", movieManager.selectMovies());

        // Envoyer la note maximale
        List<Integer> maxStars = Arrays.asList(1, 2, 3, 4, 5);

        model.addAttribute("maxStars", maxStars);


        return "listing-films";
    }

    @GetMapping("films/{id}")
    public String descriptionFilm(@PathVariable("id") long id, Model model) {

       Movie movie =  movieManager.selectMovieByID(id);

        if (movie == null) {

            // ca suffit car un return ça arrête le code

            return "page-404";
        }


        model.addAttribute("movie", movie);



        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "description-film";
    }


    @GetMapping("login")
    public String getMethodLogin(Model model) {


        // Tester si déjà connecté retourner page d'erreur
        User loggedUser = (User)model.getAttribute("loggedUser");

        if (loggedUser != null) {
            return "already-logged-page";

            // Le return arrête la fonction. Tout le reste ne
            // sera pas connecté.
        }


        User user = new User("",1L,"");

        model.addAttribute("user", user);

        return "login-form";
    }


    @PostMapping("login")
    public String postMethodLogin(@ModelAttribute User user, Model model) {

        model.addAttribute("loggedUser", user);
        System.out.println(String.format("l'utilisateur %s a été sauvegardé", user.email));

        return "redirect:/";

    }



}
