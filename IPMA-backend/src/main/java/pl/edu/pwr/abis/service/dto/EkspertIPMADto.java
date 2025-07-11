package pl.edu.pwr.abis.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EkspertIPMADto {
    private Long id;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;
    private String stanowisko;
    private Long organizacjaId;
}
