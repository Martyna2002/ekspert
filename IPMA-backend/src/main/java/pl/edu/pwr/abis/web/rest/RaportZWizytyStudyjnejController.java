package pl.edu.pwr.abis.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pwr.abis.service.RaportWizytyService;
import pl.edu.pwr.abis.service.dto.PonaglenieDTO;
import pl.edu.pwr.abis.service.dto.ZmianaDatyDTO;

@RestController
@RequestMapping("/api/raporty-wizyty")
public class RaportZWizytyStudyjnejController {

    private final RaportWizytyService service;

    public RaportZWizytyStudyjnejController(RaportWizytyService service) {
        this.service = service;
    }

    @PostMapping("/ponaglenie")
    public ResponseEntity<Void> wyslijPonaglenie(@RequestBody PonaglenieDTO dto) {
        service.wyślijPonaglenie(dto.raportId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/zmien-date")
    public ResponseEntity<Void> zmienDate(@RequestBody ZmianaDatyDTO dto) {
        service.zmieńDatęOpracowania(dto.raportId, dto.nowaData);
        return ResponseEntity.ok().build();
    }
}
