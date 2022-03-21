package cz.upce.film_app.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Film {
    @Column(length = 30)
    private String name;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Genre genre;
  //  @Column(columnDefinition = )
  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private String Director;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Set<FilmHasActor> actorsInFilm;

    @ManyToOne
    private FilmLibrary filmLibrary;

    public FilmLibrary getFilmLibrary() {
        return filmLibrary;
    }

    public void setFilmLibrary(FilmLibrary filmLibrary) {
        this.filmLibrary = filmLibrary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }


    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<FilmHasActor> getActorsInFilm() {
        return actorsInFilm;
    }

    public void setActorsInFilm(Set<FilmHasActor> actorsInFilm) {
        this.actorsInFilm = actorsInFilm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
