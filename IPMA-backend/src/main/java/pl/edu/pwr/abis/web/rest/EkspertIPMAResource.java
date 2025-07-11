package pl.edu.pwr.abis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.abis.service.EkspertIPMAService;
import pl.edu.pwr.abis.service.dto.EkspertIPMADto;

import java.util.List;

@RestController
@RequestMapping("/api/eksperci-ipma")
@RequiredArgsConstructor
public class EkspertIPMAResource {

    private final EkspertIPMAService ekspertService;

    @PostMapping("/import")
    public ResponseEntity<Void> importEksperci(@RequestBody List<EkspertIPMADto> eksperci) {
        ekspertService.importEksperci(eksperci);
        return ResponseEntity.ok().build();
    }
}
