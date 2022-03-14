package cz.upce.film_app.Repository;

import cz.upce.film_app.Entity.Film;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepository extends JpaRepository<Film,Long> {
    @EntityGraph(attributePaths = {"actorsInFilm"})
    Film findFilmByName(String contains);

    String searchString ="NOLAN";
    @Query("select f from Film f where f.Director =?1")
    Film findFilmByDirector(String director);
}
