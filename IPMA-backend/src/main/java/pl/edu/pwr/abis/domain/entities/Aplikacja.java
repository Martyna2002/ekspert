package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.report.FormularzOcenyIndywidualnej;
import pl.edu.pwr.abis.domain.entities.report.Ocena;
import pl.edu.pwr.abis.domain.entities.report.Raport;
import pl.edu.pwr.abis.domain.entities.users.Osoba;
import pl.edu.pwr.abis.domain.enums.FazaOceny;
import pl.edu.pwr.abis.domain.enums.StanAplikacji;
import pl.edu.pwr.abis.domain.enums.StanOplaty;
import pl.edu.pwr.abis.domain.enums.WynikAplikacji;

@Getter
@Setter
@Entity(name = "aplikacja")
public class Aplikacja {

    @Id
    private Integer numerAplikacji;

    @NotNull
    @Basic
    private LocalDateTime dataZlozenia;

    @NotNull
    @Enumerated
    private StanAplikacji stan;

    @Basic
    private String powodOdrzucenia;

    @NotNull
    @Enumerated
    private StanOplaty stanOplaty;

    @Enumerated
    private WynikAplikacji wynik;

    @NotNull
    @Basic
    private String nazwaProjektu;

    @NotNull
    @Basic
    private String opisProjektu;

    @NotNull
    @Basic
    private Integer czasTrwaniaMiesiace;

    @NotNull
    @Basic
    private Integer liczbaCzlonkow;

    @NotNull
    @Basic
    private Integer budzet;

    @NotNull
    @Basic
    private Integer liczbaPodwykonawcow;

    @NotNull
    @Basic
    private Boolean czyZgodnyZDefinicja;

    @NotNull
    @Basic
    private Boolean czyPublikowalny;

    @NotNull
    @Basic
    private Boolean czyUkonczony;

    @Basic
    private LocalDateTime dataZakonczenia;

    @Enumerated
    private FazaOceny fazaOceny;

    @NotNull
    @Basic
    private Double sredniaOcenaJury;

    // asocjacje

    // Adres
    @OneToOne(optional = true)
    private Adres miejsceWizytyStudyjnej;

    // Plik
    @OneToOne(optional = true)
    private Plik listReferencyjny;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plik> zdjecia;

    @OneToOne(optional = true)
    private Plik logotyp;

    @OneToOne(optional = true)
    private Plik film;

    @OneToOne(optional = true)
    private Plik oswiadczenieinicjatora;

    @OneToOne(optional = true)
    private Plik oswiadczenieAplikanta;

    // Organizacja
    @ManyToOne(optional = true)
    private Organizacja organizacjaInicjujaca;

    @ManyToOne(optional = false)
    @NotNull
    private Organizacja organizacja;

    // RaportAplikacyjny
    @OneToOne(mappedBy = "aplikacja", optional = true)
    private RaportAplikacyjny raportAplikacyjny;

    // Raport
    @OneToOne(optional = true)
    private Raport raportWizytyStudyjnej;

    // Ocena
    @OneToOne(optional = true)
    private Ocena raportOcenyWstepnej;

    @OneToOne(optional = true)
    private Ocena raportOcenyKoncowej;

    // FormularzOcenyIndywidualnej
    @OneToMany(mappedBy = "aplikacja")
    private Set<FormularzOcenyIndywidualnej> formularzOcenIndywidualnych;

    // PrzydzialAsesora
    @OneToMany(mappedBy = "aplikacja")
    @OrderBy("id")  // lub inny klucz do porządkowania, jeśli jest istotny
    private List<PrzydzialAsesora> przydzieleniAsesorowie;

    @OneToOne
    private PrzydzialAsesora asesorWiodacy;

    // KategoriaProjektu
    @ManyToOne(optional = false)
    @NotNull
    private KategoriaProjektu kategoriaProjektu;

    // Asesor
    @OneToMany
    private Set<Asesor> asesorzy; // asesorzy są przypisani do aplikacji w kontekście konkretnej edycji

    // Pytanie
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pytanie> pytania;

    // EdycjaKonkursu
    @Getter
    @Setter
    @ManyToOne
    private EdycjaKonkursu edycjaKonkursu;

    //Osoba
    @ManyToOne
    private Osoba reprezentant;




    


}
