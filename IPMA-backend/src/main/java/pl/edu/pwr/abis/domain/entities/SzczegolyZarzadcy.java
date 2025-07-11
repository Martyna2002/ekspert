package pl.edu.pwr.abis.domain.entities;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "szczegółyZarzadzcy")
public class SzczegolyZarzadcy {

    @Id
    private Long id;

    @NotNull
    private String stanowisko;

    //asocjacje

    //Organizacja
    @OneToOne(optional = false)
    private Organizacja organizacja;

}
