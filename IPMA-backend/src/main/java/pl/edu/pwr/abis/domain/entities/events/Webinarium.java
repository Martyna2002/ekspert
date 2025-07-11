package pl.edu.pwr.abis.domain.entities.events;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import pl.edu.pwr.abis.domain.enums.TypWebinarium;
import pl.edu.pwr.abis.domain.enums.TypWydarzenia;

@Entity
public class Webinarium extends Wydarzenie{
    @Id
    private Long id;

    public Webinarium(){
        super(TypWydarzenia.WEBINARIUM);
    }

    @Enumerated
    @NotNull
    private TypWebinarium typWebinarium;
}
