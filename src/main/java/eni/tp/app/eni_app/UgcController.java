package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.MovieManager;
import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.bo.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes({"addedMovie"})
@Controller
public class UgcController {

    @Autowired
    MovieManager movieManager;

    @GetMapping({"add-movie/{id}", "add-movie"})
    public String showAddMovie(@PathVariable(required = false) Long id, Model model, RedirectAttributes redirectAttributes) {

        // Instancier un film vide
        Movie movie = new Movie();

        // Si y'a un id de film, on le récupère grace à l'id
        // Ps: on écrase le film vide qu'on voulait afficher dans le form
        // donc on affichera un film existant dans le formulaire

        if (id != null) {

            movie = movieManager.getById(id);
        }

        // Envoyer le movie dans le Model
        model.addAttribute("movie", movie);

        return "add-movie-form";
    }


    @PostMapping("add-movie")
    public String processAddMovie(@Valid @ModelAttribute Movie movie, BindingResult bindingResult, Model model) {


        // Mettre le film dans la session
        model.addAttribute("addedMovie", movie);

        if (bindingResult.hasErrors()) {
            System.out.println("Erreur de contrôle surface");
        }

        //to-do : ajouter le film à la BDD

        // to-do : message de succès lorsqu'un film a été ajouté
        movieManager.saveMovie(movie);
        // to-do : message d'erreur si un des champs est vide à l'envoi

        return "add-movie-form";
    }

}
