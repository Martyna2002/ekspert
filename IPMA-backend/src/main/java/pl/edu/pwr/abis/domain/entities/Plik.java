package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "plik")
public class Plik {

    @Id
    private Long id;

    @NotNull
    @Column(unique=true)
    private String sciezka;

    @NotNull
    @Basic
    private String nazwa;

    @NotNull
    @Basic
    @Setter(AccessLevel.NONE)
    private LocalDate dataUtworzenia;

    @NotNull
    @Basic
    @Setter(AccessLevel.NONE)
    private String typ;

    //asocjacje

    //Pytanie
    @ManyToOne(optional = true)
    private Pytanie pytanie;






}
