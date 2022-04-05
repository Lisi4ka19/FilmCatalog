package filmcatalog.filmcatalog;

import filmcatalog.filmcatalog.entity.Film;
import filmcatalog.filmcatalog.service.FilmService;
import filmcatalog.filmcatalog.service.FilmServiceEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FileCatalogApplication {



    public static void main(String[] args) {

        SpringApplication.run(FileCatalogApplication.class, args);
//
//        FilmService filmService = new FilmServiceEmp();
//        List<Film> listFilms = filmService.getAllFilm();
//        System.out.println(listFilms);



    }

}
