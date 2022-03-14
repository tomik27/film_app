package cz.upce.film_app.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FilmLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Set<Film> filmsInLibrary;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilmsInLibrary() {
        return filmsInLibrary;
    }

    public void setFilmsInLibrary(Set<Film> filmsInLibrary) {
        this.filmsInLibrary = filmsInLibrary;
    }
}
