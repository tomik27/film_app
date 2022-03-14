package cz.upce.film_app.Repository;

import cz.upce.film_app.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
