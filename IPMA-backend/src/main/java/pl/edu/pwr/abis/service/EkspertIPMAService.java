package pl.edu.pwr.abis.service;

import pl.edu.pwr.abis.service.dto.EkspertIPMADto;
import java.util.List;

public interface EkspertIPMAService {
    void importEksperci(List<EkspertIPMADto> dtoList);
}
