package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import pl.edu.pwr.abis.domain.entities.Aplikacja;
import pl.edu.pwr.abis.domain.entities.EdycjaKonkursu;

import java.util.List;
import java.util.Set;

@Entity
public class Jury extends Uzytkownik{

    // asocjacje
    // Jury
    @OneToMany(mappedBy = "przewodniczacyJury")
    private Set<EdycjaKonkursu> edycjePrzewodniczacego;

    @OneToMany(mappedBy = "skladJury")
    private Set<EdycjaKonkursu> edycje;

    // Aplikacja
    @ManyToMany
    private List<Aplikacja> projekty;
}
