package pl.edu.pwr.abis.domain.entities.report;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.enums.StatusOcenyKoncowej;
import pl.edu.pwr.abis.domain.enums.TypOceny;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Ocena extends Raport {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypOceny rodzaj = TypOceny.KONCOWA;

    private String uzasadnienie;

    @NotNull
    private LocalDate planowanaDataOpracowania;

    private LocalDate dataZatwierdzenia;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusOcenyKoncowej statusOceny;

    @NotNull
    private int iloscPunktow = 0;

    @NotNull
    private boolean czyOpozniona;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ocena_id")
    private List<OcenaKryteriumPEM> ocenyKryteriow;

    public Ocena() {}

    public Ocena(@NotNull LocalDate planowanaDataOpracowania) {
        this.planowanaDataOpracowania = planowanaDataOpracowania;
    }

    public Integer lacznaLiczbaPunktow() {
        return ocenyKryteriow != null
            ? ocenyKryteriow.stream().mapToInt(OcenaKryteriumPEM::getLiczbaPunktow).sum()
            : 0;
    }

    // === Wymaganie 60 ===
    public void zmienPlanowanaDate(LocalDate nowaData) {
        if (this.rodzaj == TypOceny.KONCOWA && this.dataZatwierdzenia == null) {
            this.planowanaDataOpracowania = nowaData;
        } else {
            throw new IllegalStateException("Nie można zmienić daty: ocena nie jest końcowa lub została już zatwierdzona.");
        }
    }
}
