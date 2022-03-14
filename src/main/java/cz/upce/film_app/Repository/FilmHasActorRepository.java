package cz.upce.film_app.Repository;

import cz.upce.film_app.Entity.FilmHasActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmHasActorRepository extends JpaRepository<FilmHasActor,Long> {
}
