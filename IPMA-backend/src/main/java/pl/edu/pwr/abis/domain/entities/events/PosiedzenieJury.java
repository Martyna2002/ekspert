package pl.edu.pwr.abis.domain.entities.events;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class PosiedzenieJury extends WydarzenieMiejscowe{
    @Id
    private Long id;

    @Basic
    @NotNull
    private String opis;
}
