package pl.edu.pwr.abis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;
import pl.edu.pwr.abis.domain.entities.Organizacja;
import pl.edu.pwr.abis.repository.EkspertIPMARepository;
import pl.edu.pwr.abis.repository.OrganizacjaRepository;
import pl.edu.pwr.abis.service.EkspertIPMAService;
import pl.edu.pwr.abis.service.dto.EkspertIPMADto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EkspertIPMAServiceImpl implements EkspertIPMAService {

    private final EkspertIPMARepository ekspertRepo;
    private final OrganizacjaRepository organizacjaRepo;

    @Override
    public void importEksperci(List<EkspertIPMADto> dtoList) {
        for (EkspertIPMADto dto : dtoList) {
            EkspertIPMA ekspert = ekspertRepo.findById(dto.getId()).orElse(new EkspertIPMA());

            ekspert.setId(dto.getId());
            ekspert.setImie(dto.getImie());
            ekspert.setNazwisko(dto.getNazwisko());
            ekspert.setTelefon(dto.getTelefon());
            ekspert.setEmail(dto.getEmail());
            ekspert.setStanowisko(dto.getStanowisko());

            Organizacja org = organizacjaRepo.findById(dto.getOrganizacjaId())
                .orElseThrow(() -> new IllegalArgumentException("Organizacja nie znaleziona"));

            ekspert.setOrganizacja(org);
            ekspertRepo.save(ekspert);
        }
    }
}
