package pl.edu.pwr.abis.domain.entities.events;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class WydarzenieWielodniowe extends Wydarzenie{
    @Id
    private Long id;

    @Basic
    @NotNull
    private LocalDateTime dataKonca;
}
