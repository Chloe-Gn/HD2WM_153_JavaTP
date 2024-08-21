package eni.tp.app.eni_app.module1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @GetMapping("")
    public String accueil() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "accueil";
    }


    @GetMapping("liste-films")
    public String listeFilms() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "liste-films";
    }


    @GetMapping("listing-films")
    public String listingFilms() {

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
