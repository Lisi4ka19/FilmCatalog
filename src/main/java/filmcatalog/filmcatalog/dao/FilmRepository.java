package filmcatalog.filmcatalog.dao;



import filmcatalog.filmcatalog.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
