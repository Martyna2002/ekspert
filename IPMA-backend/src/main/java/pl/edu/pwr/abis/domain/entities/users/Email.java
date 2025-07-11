package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Email {

    @Id
    private Long id;

    @Basic
    @NotNull
    private String temat;

    @Basic
    @NotNull
    private String tresc;

    @ManyToOne(optional = false)
    private Osoba nadawca;

    @ManyToOne(optional = false)
    private Osoba odbiorca;
}
