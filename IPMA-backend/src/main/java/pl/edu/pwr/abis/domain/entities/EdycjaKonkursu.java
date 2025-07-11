package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.CascadeType;


import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.users.CzlonekBiuraNagrody;
import pl.edu.pwr.abis.domain.entities.users.Jury;
import pl.edu.pwr.abis.domain.enums.StanEdycjiKonkursu;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "edycja_konkursu")
public class EdycjaKonkursu {

    @Id
    @NotNull
    @GeneratedValue
    private Integer numerEdycji;

    @NotNull
    @Basic
    private Integer rok;

    @NotNull
    @Enumerated
    private StanEdycjiKonkursu stan;

    @NotNull
    @Basic
    private Double kosztUczestnictwa;

    @NotNull
    @Basic
    private Integer minLiczbaCzlonkowProjektu;

    @NotNull
    @Basic
    private Integer minCzasTrwaniaProjektuMiesiace;

    @NotNull
    @Basic
    private Integer minLiczbaPodwykonawcow;

    @NotNull
    @Basic
    private Integer maxCzasOdUkonczeniaProjektuMiesiace;

    @NotNull
    @Basic
    @Getter
    private LocalDateTime planowanaDataZlozeniaOI;

    //asocjacje

    //Plik

    @OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    private Plik regulamin;

    @OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    private Plik wyniki;

    @OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    private Plik listaFinalistow;

    //CzłonekBiuraNagrody
    @ManyToOne
    private CzlonekBiuraNagrody przewodniczacyBiuraNagrody;

    // Jury
    @ManyToOne(optional = true)
    private Jury przewodniczacyJury;

    @ManyToOne(optional = true)
    private Jury skladJury;
}
