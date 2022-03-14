package cz.upce.film_app;

import cz.upce.film_app.Entity.*;
import cz.upce.film_app.Repository.ActorRepository;
import cz.upce.film_app.Repository.FilmHasActorRepository;
import cz.upce.film_app.Repository.FilmLibraryRespository;
import cz.upce.film_app.Repository.FilmRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FilmLibraryTests {

    @Autowired
    private FilmLibraryRespository filmLibraryRespository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmHasActorRepository filmHasActorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Test
    void saveFilmLibrary() {
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.setName("name");

        filmLibraryRespository.save(filmLibrary);

        List<FilmLibrary> all = filmLibraryRespository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
    }
    @Test
    void deleteLibraryFilm() {
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.setName("name");

        filmLibraryRespository.save(filmLibrary);
        filmLibraryRespository.delete(filmLibrary);

        List<FilmLibrary> all = filmLibraryRespository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(0);
    }

    @Test
    void updateLibraryFilm() {
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.setName("name");

        filmLibraryRespository.save(filmLibrary);

        filmLibrary= filmLibraryRespository.findFilmLibraryByName("name");
       filmLibrary.setName("newName");
        List<FilmLibrary> all = filmLibraryRespository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
         filmLibrary= filmLibraryRespository.findFilmLibraryByName("newName");
        Assertions.assertThat(filmLibrary.getName()).isEqualTo("newName");
    }

    @Test
    void findFilmTest(){
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.setName("name");
        filmLibraryRespository.save(filmLibrary);

        //film
        Film film = new Film();
        film.setFilmLibrary(filmLibrary);
        film.setDirector("Nolan");
        film.setName("Batman");
        film.setGenre(Genre.HORROR);
      //  Calendar calendar= new GregorianCalendar(2015, 7, 5);
        film.setReleaseDate(new GregorianCalendar(2008, 0, 0).getTime());
        filmRepository.save(film);

        //Actor
        Actor actor = new Actor();
        actor.setFirstName("Anrold");
        actor.setSurname("Schwarzeneger");
        actor.setBornPlace("Praha");
        actor.setBornDate(new GregorianCalendar(1968, 8, 10).getTime());
        actorRepository.save(actor);

        //FilmHasActor
        FilmHasActor filmHasActor = new FilmHasActor();
        filmHasActor.setFilm(film);
        filmHasActor.setActor(actor);
        filmHasActorRepository.save(filmHasActor);


        Film batman = filmRepository.findFilmByName("Batman");
        Assertions.assertThat(batman.getName()).isEqualTo("Batman");
    }

    @Test
    void findFilmByDirectorTest() {
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.setName("name");
        filmLibraryRespository.save(filmLibrary);

        //film
        Film film = new Film();
        film.setFilmLibrary(filmLibrary);
        film.setDirector("Nolan");
        film.setName("Batman");
        film.setGenre(Genre.HORROR);
        //  Calendar calendar= new GregorianCalendar(2015, 7, 5);
        film.setReleaseDate(new GregorianCalendar(2008, 0, 0).getTime());
        filmRepository.save(film);
        Film batman=  filmRepository.findFilmByDirector("Nolan");
        Assertions.assertThat(batman.getName()).isEqualTo("Batman");
    }



}
