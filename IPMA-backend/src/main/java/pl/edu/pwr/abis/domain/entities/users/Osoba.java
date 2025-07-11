package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pl.edu.pwr.abis.domain.entities.Aplikacja;
import pl.edu.pwr.abis.domain.entities.Organizacja;

import java.util.List;

@Entity
public class Osoba {
    @Id
    private Long id;

    @Basic
    @NotNull
    private String imie;

    @Basic
    @NotNull
    private String nazwisko;

    @Basic
    @NotNull
    private String telefon;

    @Basic
    @NotNull
    private String email;

    @OneToMany(mappedBy = "odbiorca")
    private List<Email> odebrane;

    @OneToMany(mappedBy = "nadawca")
    private List<Email> wyslane;

    @OneToMany(mappedBy = "reprezentant")
    private List<Aplikacja> aplikacja;

//    @OneToOne(optional = false)
//    private Organizacja organizacja;

    @OneToOne(mappedBy = "zarzadca", optional = true)
    private Organizacja organizacja;

    @Basic
    private String stanowisko;


}
