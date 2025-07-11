package pl.edu.pwr.abis.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pl.edu.pwr.abis.repository.RaportWizytyRepository;

@Service
public class RaportWizytyService {
    private final RaportWizytyRepository repository;

    public RaportWizytyService(RaportWizytyRepository repository) {
        this.repository = repository;
    }

    public void wyślijPonaglenie(Long raportId) {
        var raport = repository.findById(raportId)
            .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono raportu."));
        raport.wyślijPonaglenie();
        repository.save(raport);
    }

    public void zmieńDatęOpracowania(Long raportId, LocalDate nowaData) {
        var raport = repository.findById(raportId)
            .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono raportu."));
        raport.zmieńDatęOpracowania(nowaData);
        repository.save(raport);
    }
}
