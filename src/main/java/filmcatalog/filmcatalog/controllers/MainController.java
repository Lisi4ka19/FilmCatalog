package filmcatalog.filmcatalog.controllers;

import filmcatalog.filmcatalog.entity.Film;
import filmcatalog.filmcatalog.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public String getMainPage(){

        return "main";
    }

    @GetMapping("/allFilms")
    public String getAllFilms(Model model){


        List<Film> filmList =filmService.getAllFilm();

        System.out.println("Количество записей: " + filmList.size());

        model.addAttribute("allFilms", filmList);
        return "all-films";
    }
}
