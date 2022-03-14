package cz.upce.film_app.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Actor {
    private String firstName;
    private String surname;
    private Date bornDate;
    private String bornPlace;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Set<FilmHasActor> filmsWithActor;

    public Set<FilmHasActor> getFilmsWithActor() {
        return filmsWithActor;
    }

    public void setFilmsWithActor(Set<FilmHasActor> filmsWithActor) {
        this.filmsWithActor = filmsWithActor;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }
}
