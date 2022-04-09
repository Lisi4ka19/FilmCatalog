package filmcatalog.filmcatalog.dao;



import filmcatalog.filmcatalog.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface FilmRepository extends JpaRepository<Film, Integer> {
public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {

    Page<Film> findAll(Pageable pageable);

    Page<Film> findByProducer(String firstName, Pageable pageable);

    Page<Film> findByYearOfIssue(String firstName, Pageable pageable);



}
