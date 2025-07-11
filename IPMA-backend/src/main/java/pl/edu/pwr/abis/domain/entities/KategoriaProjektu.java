package pl.edu.pwr.abis.domain.entities;

import java.util.Set;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


import jakarta.persistence.OneToMany;

@Getter
@Setter
@Entity(name = "kategoria_projektu")
public class KategoriaProjektu {

    @Id
    private Long id;

    @NotNull
    @Setter(AccessLevel.NONE)
    @Column(unique=true)
    private String nazwa;

    // asocjacje

    // Aplikacja
    @OneToMany(mappedBy = "kategoriaProjektu")
    private Set<Aplikacja> aplikacje;
}
