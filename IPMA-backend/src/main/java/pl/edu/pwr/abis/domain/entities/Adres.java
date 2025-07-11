package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Adres {
    @Getter
    @Setter
    @Id
    private Long id;

    @NotNull
    @Basic
    private String kraj;

    @NotNull
    @Basic
    private String wojewodztwo;

    @NotNull
    @Basic
    private String miasto;

    @NotNull
    @Basic
    private String ulica;

    @NotNull
    @Basic
    private String kodPocztowy;

    // asocjacje
    // brak
}
