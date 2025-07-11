package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import pl.edu.pwr.abis.domain.entities.Organizacja;

@Entity
public class Przedstawiciel extends Uzytkownik {
    @Id
    private Long id;

    @OneToOne
    private Organizacja organizacja;
}
