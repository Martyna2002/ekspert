package pl.edu.pwr.abis.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.edu.pwr.abis.domain.enums.StatusRaportuZWizytyStudyjnej;

@Entity
public class RaportZWizytyStudyjnej {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusRaportuZWizytyStudyjnej status;

    private LocalDate planowanaDataOpracowania;

    private boolean ponaglenieWysłane = false;

    public boolean isOpóźniony() {
        return status == StatusRaportuZWizytyStudyjnej.BRAK &&
            planowanaDataOpracowania.isBefore(LocalDate.now());
    }

    public void wyślijPonaglenie() {
        if (!isOpóźniony()) {
            throw new IllegalStateException("Raport nie jest opóźniony.");
        }
        if (ponaglenieWysłane) {
            throw new IllegalStateException("Ponaglenie już zostało wysłane.");
        }
        this.ponaglenieWysłane = true;
    }

    public void zmieńDatęOpracowania(LocalDate nowaData) {
        if (status == StatusRaportuZWizytyStudyjnej.ZWERYFIKOWANY) {
            throw new IllegalStateException("Nie można zmienić daty raportu zweryfikowanego.");
        }
        this.planowanaDataOpracowania = nowaData;
    }
}
