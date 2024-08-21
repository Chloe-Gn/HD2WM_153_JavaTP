package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bll.MovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


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



    @GetMapping("listing-films")
    public String listingFilms(Model model) {

            model.addAttribute("movies", movieManager.selectMovies());

        return "listing-films";
    }

    @GetMapping("description-film")
    public String descriptionFilm() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "description-film";
    }



}
