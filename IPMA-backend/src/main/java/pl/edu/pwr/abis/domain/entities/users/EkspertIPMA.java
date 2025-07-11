package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import pl.edu.pwr.abis.domain.entities.Asesor;
import pl.edu.pwr.abis.domain.entities.Organizacja;
import pl.edu.pwr.abis.domain.entities.PrzydzialAsesora;
import lombok.Setter;
import java.util.Set;


import java.util.List;

@Setter
@Entity
public class EkspertIPMA extends Osoba{
    @Id
    private Long id;

    @OneToOne
    private Asesor asesor;

    @ManyToOne(optional = false) 
    private Organizacja organizacja;


    @OneToMany(mappedBy = "ekspertIPMA")
    private List<PrzydzialAsesora> przydzialy;
}
