package pl.edu.pwr.abis.domain.entities.report;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class OcenaKryteriumPEM {
    @Id
    private Long id;

    @Basic
    @NotNull
    private Integer liczbaPunktow;

    @Basic
    private String uzasadnienie;

    @ManyToOne(optional = false)
    private KryteriumPEM kryteriumPEM;
}
