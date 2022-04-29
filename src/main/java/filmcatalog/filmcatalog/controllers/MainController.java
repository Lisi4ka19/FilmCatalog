package filmcatalog.filmcatalog.controllers;

import filmcatalog.filmcatalog.entity.Film;
import filmcatalog.filmcatalog.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;
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
    public String getAllFilms(Model model, @PageableDefault(sort={"id"}, direction = Sort.Direction.ASC) Pageable pageable){

        Page<Film> page = filmService.getAllFilm(pageable);
        PagesInfo pagesInfo = new PagesInfo(page);

        model.addAttribute("allFilms", page.getContent());

        model.addAttribute("itemPage", pagesInfo.getPageItemsList());
        model.addAttribute("size", page.getSize());

        return "all-films";
    }

    @GetMapping("/addFilm")
    public String addFilm(Model model){

        Film film = new Film();
        model.addAttribute("film", film);

        return "film-view";
    }

    @PostMapping("/saveFilm")
    public String saveFilm(@RequestParam("file") MultipartFile file, @ModelAttribute("film") Film film) {
        try {
            film.setImage(file.getBytes());
        } catch (IOException e) {
            System.out.println("Error for read file");
        }

        filmService.saveFilm(film);

        return "redirect:/allFilms";
    }

    @GetMapping("/updateFilm")
    public String updateFilm(@RequestParam("id") int id, Model model) {


        Film film = filmService.getFilm(id);

        String codeStringImage = "";
        if(film.getImage()!=null) codeStringImage = Base64.getEncoder().encodeToString(film.getImage());


        model.addAttribute("film", film);

        model.addAttribute("codeStringImage", codeStringImage);

        return "film-view";
    }

    @GetMapping("/deleteFilm")
    public String deleteFilm(@RequestParam("id") int id, Model model){

        filmService.deleteFilm(id);

        return "redirect:/allFilms";
    }
}
