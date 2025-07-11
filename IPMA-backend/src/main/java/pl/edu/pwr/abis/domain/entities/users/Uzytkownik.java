package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Setter;
import pl.edu.pwr.abis.domain.enums.StanKonta;

@Entity
public class Uzytkownik {
    @Id
    private Long id;

    @Column(unique=true)
    @NotNull
    @Setter(AccessLevel.NONE)
    private String login;

    @Enumerated
    @NotNull
    private StanKonta stanKonta;
}
