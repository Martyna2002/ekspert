package pl.edu.pwr.abis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.abis.service.OcenaService;
import pl.edu.pwr.abis.service.dto.ZmianaDatyOcenyDTO;
import pl.edu.pwr.abis.service.dto.PonaglenieOcenyDTO;

@RestController
@RequestMapping("/api/oceny")
@RequiredArgsConstructor
public class OcenaController {

    private final OcenaService ocenaService;

    @PostMapping("/zmien-date")
    public ResponseEntity<Void> zmienDate(@RequestBody ZmianaDatyOcenyDTO dto) {
        ocenaService.zmienPlanowanaDate(dto.ocenaId(), dto.nowaData());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ponaglenie")
    public ResponseEntity<Void> wyslijPonaglenie(@RequestBody PonaglenieOcenyDTO dto) {
        ocenaService.wyslijPonaglenie(dto.ocenaId());
        return ResponseEntity.ok().build();
    }
}
