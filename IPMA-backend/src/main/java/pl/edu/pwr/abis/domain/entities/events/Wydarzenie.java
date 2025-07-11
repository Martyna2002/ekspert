package pl.edu.pwr.abis.domain.entities.events;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pl.edu.pwr.abis.domain.entities.EdycjaKonkursu;
import pl.edu.pwr.abis.domain.enums.TypWydarzenia;

import java.time.LocalDateTime;

@Entity
public class Wydarzenie {
    @Id
    private Long id;

    @Column(unique=true)
    @NotNull
    private String nazwa;

    @Enumerated
    @NotNull
    private TypWydarzenia typ;

    @Basic
    @NotNull
    private LocalDateTime data;

    @ManyToOne(optional = false)
    private EdycjaKonkursu edycjaKonkursu;

    public Wydarzenie() {}

    public Wydarzenie(TypWydarzenia typ) {
        this.typ = typ;
    }
}
