package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import pl.edu.pwr.abis.domain.entities.EdycjaKonkursu;

import java.util.List;

@Entity
public class CzlonekBiuraNagrody extends Uzytkownik {
    @Id
    private Long id;

    @ManyToMany
    private List<EdycjaKonkursu> edycje;

    @OneToMany(mappedBy = "przewodniczacyBiuraNagrody")
    private List<EdycjaKonkursu> edycjePrzewodniczacego;
}
