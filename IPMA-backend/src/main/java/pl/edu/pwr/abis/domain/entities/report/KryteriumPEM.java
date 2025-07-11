package pl.edu.pwr.abis.domain.entities.report;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import pl.edu.pwr.abis.domain.enums.KategoriaPEM;

@Entity
public class KryteriumPEM {
    @Id
    private Long id;

    @NotNull
    @Column(unique=true)
    private String nazwa;

    @Enumerated
    @NotNull
    private KategoriaPEM kategoriaPEM;

    @Basic
    private String opis;
}
