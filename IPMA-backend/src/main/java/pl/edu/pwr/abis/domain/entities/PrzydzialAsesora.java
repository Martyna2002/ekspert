package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.Aplikacja;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;
import pl.edu.pwr.abis.domain.enums.StanWspolpracyAsesora;

@Getter
@Setter
@Entity(name = "przydzial_asesora")
public class PrzydzialAsesora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated
    private StanWspolpracyAsesora stanWspolpracy;

    @Basic
    private String warunkiUmowy;

    @NotNull
    @Basic
    private LocalDate dataZlozeniaPropozycji;

    // asocjacje

    // Aplikacja
    @ManyToOne(optional = false)
    private Aplikacja aplikacja;

    // EkspertIPMA

    @ManyToOne(optional = false)
    private EkspertIPMA ekspertIPMA;



}
