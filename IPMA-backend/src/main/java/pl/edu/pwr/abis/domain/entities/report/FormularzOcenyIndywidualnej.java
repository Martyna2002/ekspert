package pl.edu.pwr.abis.domain.entities.report;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import pl.edu.pwr.abis.domain.entities.Aplikacja;
import pl.edu.pwr.abis.domain.entities.Asesor;

@Entity
public class FormularzOcenyIndywidualnej extends Ocena{
    @Id
    private Long id;

    @ManyToOne(optional = false)
    private Aplikacja aplikacja;

    @ManyToOne(optional = false)
    private Asesor asesor;

    public FormularzOcenyIndywidualnej(Aplikacja aplikacja, Asesor asesor) {
        super(LocalDate.from(aplikacja.getEdycjaKonkursu().getPlanowanaDataZlozeniaOI()));
        this.aplikacja = aplikacja;
        this.asesor = asesor;
    }

    public FormularzOcenyIndywidualnej() {

    }
}
