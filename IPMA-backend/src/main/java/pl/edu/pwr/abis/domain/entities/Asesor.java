package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;


@Getter
@Setter
@Entity(name = "asesor")
public class Asesor {

    @Id
    @NotNull
    private Long id;

    @NotNull
    @Basic
    private String imie;

    @NotNull
    @Basic
    private String nazwisko;

    @NotNull
    @Basic
    private String telefon;

    @NotNull
    @Basic
    private String email;
}
