package filmcatalog.filmcatalog.service;


import filmcatalog.filmcatalog.entity.Film;

import java.util.List;

public interface FilmService {

    public List<Film> getAllFilm();

    public void saveFilm(Film film);

    public Film getFilm(int id);

    public void deleteFilm(int id);


}
