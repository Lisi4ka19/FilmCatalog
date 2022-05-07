package filmcatalog.filmcatalog.controllers;

import filmcatalog.filmcatalog.entity.Film;
import filmcatalog.filmcatalog.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String getMainPage(Model model){
        String username = getUserName();

        model.addAttribute("username", username);
        return "main";
    }

    @GetMapping("/allFilms")
    public String getAllFilms(Model model, @PageableDefault(sort={"id"}, direction = Sort.Direction.ASC) Pageable pageable){

        Page<Film> page = filmService.getAllFilm(pageable);
        PagesInfo pagesInfo = new PagesInfo(page);

        model.addAttribute("allFilms", page.getContent());

        model.addAttribute("itemPage", pagesInfo.getPageItemsList());
        model.addAttribute("size", page.getSize());
        model.addAttribute("username", getUserName());

        return "all-films";
    }

    @GetMapping("/addFilm")
    public String addFilm(Model model){

        Film film = new Film();

        String username = getUserName();

        film.setUsername(username);

        model.addAttribute("film", film);
        model.addAttribute("username", username);
        model.addAttribute("enable", true);

        return "film-view";
    }

    @PostMapping("/saveFilm")
    public String saveFilm(@RequestParam("file") MultipartFile file, @ModelAttribute("film") Film film) {
        try {
            film.setImage(file.getBytes());
        } catch (IOException e) {
            System.out.println("Error for read file");
        }

        String username = getUserName();
        film.setUsername(username);

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

        String username = getUserName();
        Boolean enable = username.equals(film.getUsername())||film.getUsername()==null;
        model.addAttribute("enable", enable);
        model.addAttribute("username", username);

        return "film-view";
    }

    @GetMapping("/deleteFilm")
    public String deleteFilm(@RequestParam("id") int id, Model model){

        filmService.deleteFilm(id);

        return "redirect:/allFilms";
    }



    public String getUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username =  auth.getName();

        return username;
    }

}