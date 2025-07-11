package pl.edu.pwr.abis.domain.entities.report;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import pl.edu.pwr.abis.domain.enums.StanRaportu;

import java.time.LocalDateTime;

@Entity
public class Raport {
    @Id
    private Long id;

    @Basic
    @NotNull
    private StanRaportu stanRaportu = StanRaportu.WERSJA_ROBOCZA;

    @Basic
    private LocalDateTime dataZlozenia;

    @Basic
    @NotNull
    private LocalDateTime planowanaDataZlozenia;

    @Basic
    private String komentarz;

    @Transient
    private boolean czyOpozniony(){
        return LocalDateTime.now().isAfter(planowanaDataZlozenia);
    }

    public Raport() {}

    public Raport(LocalDateTime planowanaDataZlozenia) {
        this.planowanaDataZlozenia = planowanaDataZlozenia;
    }
}
