package cz.upce.film_app.Repository;

import cz.upce.film_app.Entity.FilmLibrary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmLibraryRespository extends JpaRepository<FilmLibrary,Long> {
  //  @EntityGraph(att)
    FilmLibrary findFilmLibraryByName(String contains);
}
