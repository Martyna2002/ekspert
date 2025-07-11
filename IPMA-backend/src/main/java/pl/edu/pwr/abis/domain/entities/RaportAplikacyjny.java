package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.enums.StanRaportu;

@Getter
@Setter
@Entity(name = "raport_aplikacyjny")
public class RaportAplikacyjny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated
    private StanRaportu stan;

    @NotNull
    @Basic
    private LocalDate dataZlozenia;

    @Basic
    private String powodOdrzucenia;

    // asocjacje

    // Aplikacja
    @OneToOne(optional = false)
    private Aplikacja aplikacja;
}
