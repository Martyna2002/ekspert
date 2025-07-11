package pl.edu.pwr.abis.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import pl.edu.pwr.abis.domain.entities.report.Ocena;
import pl.edu.pwr.abis.domain.enums.TypOceny;
import pl.edu.pwr.abis.repository.OcenaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OcenaService {

    private final OcenaRepository ocenaRepository;

    public OcenaService(OcenaRepository ocenaRepository) {
        this.ocenaRepository = ocenaRepository;
    }

    // pobieramy wszystkie niezatwierdzone oceny (w celu wyróżnienia)
    public List<Ocena> niezatwierdzoneKoncowe;

    public List<Ocena> znajdzNiezatwierdzoneOceny() {
        return ocenaRepository.findAllByRodzajAndDataZatwierdzeniaIsNull(TypOceny.KONCOWA);
    }

    @Transactional
    public void wyslijPonaglenie(Long ocenaId) {
        Ocena ocena = ocenaRepository.findById(ocenaId)
            .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono oceny o ID " + ocenaId));

        // wysyłanie ponaglenia do asesora wiodącego
        System.out.printf("Ponaglenie wysłane do asesora dla oceny %d%n", ocenaId);
    }

    // zmiana planowanej daty dostarczenia oceny końcowej
    @Transactional
    public void zmienPlanowanaDate(Long ocenaId, LocalDate nowaData) {
        Ocena ocena = ocenaRepository.findById(ocenaId)
            .orElseThrow(() -> new OcenaNotFoundException(ocenaId));

        if (ocena.getRodzaj() != TypOceny.KONCOWA) {
            throw new OcenaNotFoundException(ocenaId);
        }

        if (ocena.getDataZatwierdzenia() != null) {
            throw new OcenaNotFoundException(ocenaId);
        }

        ocena.setPlanowanaDataOpracowania(nowaData);
        ocenaRepository.save(ocena);
    }
}
