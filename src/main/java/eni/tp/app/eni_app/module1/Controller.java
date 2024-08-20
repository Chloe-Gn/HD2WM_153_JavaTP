package eni.tp.app.eni_app.module1;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller

public class Controller {

    @GetMapping("accueil")
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


    @GetMapping("description-film")
    public String descriptionFilm() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "description-film";
    }



}
