package filmcatalog.filmcatalog.controllers;

import filmcatalog.filmcatalog.entity.Film;
import filmcatalog.filmcatalog.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
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
    public String getAllFilms(Model model, Pageable pageable){
//        pageable.getPageNumber()
        Pageable pageableCurrent = PageRequest.of(0, 2);

        Page<Film> page = filmService.getAllFilm(pageableCurrent);

        PagesInfo pagesInfo = new PagesInfo(page);

//        List<Film> filmList =filmService.getAllFilm(pageable);

        model.addAttribute("allFilms", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("itemPage", pagesInfo.getPageItemsList());

        return "all-films";
    }

    @GetMapping("/addFilm")
    public String addFilm(Model model){

        Film film = new Film();
        model.addAttribute("film", film);

        return "film-view";
    }

    @GetMapping("/saveFilm")
    public String saveFilm(@ModelAttribute("film") Film film) {
        filmService.saveFilm(film);

        return "redirect:/allFilms";
    }

    @GetMapping("/updateFilm")
    public String updateFilm(@RequestParam("id") int id, Model model){

        Film film = filmService.getFilm(id);
        model.addAttribute("film", film);

        return "film-view";
    }

    @GetMapping("/deleteFilm")
    public String deleteFilm(@RequestParam("id") int id, Model model){

        filmService.deleteFilm(id);

        return "redirect:/allFilms";
    }
}
