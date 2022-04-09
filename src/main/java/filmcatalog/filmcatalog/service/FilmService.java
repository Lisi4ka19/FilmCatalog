package filmcatalog.filmcatalog.service;


import filmcatalog.filmcatalog.entity.Film;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface FilmService {

    public Page<Film> getAllFilm(Pageable pageable);

    public void saveFilm(Film film);

    public Film getFilm(int id);

    public void deleteFilm(int id);


}
