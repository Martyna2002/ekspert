package pl.edu.pwr.abis.domain.entities;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;
import pl.edu.pwr.abis.domain.entities.users.Osoba;
import pl.edu.pwr.abis.domain.enums.StanDanych;

@Getter
@Setter
@Entity(name = "organizacja")
public class Organizacja {


    @NotNull
    @Column(unique=true)
    private String nip;

    @NotNull
    @Basic
    private String nazwa;

    @NotNull
    @Basic
    private String email;

    @NotNull
    @Enumerated
    private StanDanych stanDanych;

    @NotNull
    @Basic
    private Boolean czyPowiazanyZIPMA = false;

    @NotNull
    @Basic
    private String skrotNazwy;

    @NotNull
    @Basic
    private String nazwaNaFakturze;

    // asocjacje

    // Aplikacja
    @OneToMany(mappedBy = "organizacjaInicjujaca")
    private Set<Aplikacja> aplikacjeZainicjowane;

    @OneToMany(mappedBy = "organizacja")
    @OrderBy("numerAplikacji")
    private List<Aplikacja> aplikacje;

    // Adres
    @OneToOne(optional = true)
    private Adres afiliacja;


    //SzczegółyZarządzcy
    @OneToOne(optional = false)
    private Osoba zarzadca;

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
