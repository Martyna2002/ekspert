package pl.edu.pwr.abis.domain.entities;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.Aplikacja;

@Getter
@Setter
@Entity(name = "pytanie")
public class Pytanie {

    @Id
    private Long id;

    @NotNull
    @Column(unique=true)
    private String tresc;

    @Basic
    private String odpowiedz;

    // asocjacje

    // Plik
    @OneToMany(mappedBy = "pytanie")
    private List<Plik> zalaczniki;

}
