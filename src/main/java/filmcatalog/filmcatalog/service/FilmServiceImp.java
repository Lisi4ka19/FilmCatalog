package filmcatalog.filmcatalog.service;


import filmcatalog.filmcatalog.dao.FilmRepository;
import filmcatalog.filmcatalog.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmServiceImp implements FilmService{

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Page<Film> getAllFilm(Pageable pageable) {

        Page<Film> page = filmRepository.findAll(pageable);

        return page;
    }

    @Override
    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public Film getFilm(int id) {
        Film film = null;
        Optional<Film> optional = filmRepository.findById(id);
        if(optional.isPresent()) film = optional.get();

        return film;
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
