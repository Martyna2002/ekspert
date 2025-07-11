package pl.edu.pwr.abis.service.dto;

import java.time.LocalDate;

public class RaportZWizytyDTO {

    private Long raportId;
    private String nazwaProjektu;
    private String organizacja;
    private String zespolAsesorow;
    private LocalDate planowanaDataOpracowania;
    private String statusRaportu;
    private boolean czyOpóźniony;

    public RaportZWizytyDTO() {
    }

    public RaportZWizytyDTO(Long raportId, String nazwaProjektu, String organizacja,
        String zespolAsesorow, LocalDate planowanaDataOpracowania,
        String statusRaportu, boolean czyOpóźniony) {
        this.raportId = raportId;
        this.nazwaProjektu = nazwaProjektu;
        this.organizacja = organizacja;
        this.zespolAsesorow = zespolAsesorow;
        this.planowanaDataOpracowania = planowanaDataOpracowania;
        this.statusRaportu = statusRaportu;
        this.czyOpóźniony = czyOpóźniony;
    }

    public Long getRaportId() {
        return raportId;
    }

    public void setRaportId(Long raportId) {
        this.raportId = raportId;
    }

    public String getNazwaProjektu() {
        return nazwaProjektu;
    }

    public void setNazwaProjektu(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
    }

    public String getOrganizacja() {
        return organizacja;
    }

    public void setOrganizacja(String organizacja) {
        this.organizacja = organizacja;
    }

    public String getZespolAsesorow() {
        return zespolAsesorow;
    }

    public void setZespolAsesorow(String zespolAsesorow) {
        this.zespolAsesorow = zespolAsesorow;
    }

    public LocalDate getPlanowanaDataOpracowania() {
        return planowanaDataOpracowania;
    }

    public void setPlanowanaDataOpracowania(LocalDate planowanaDataOpracowania) {
        this.planowanaDataOpracowania = planowanaDataOpracowania;
    }

    public String getStatusRaportu() {
        return statusRaportu;
    }

    public void setStatusRaportu(String statusRaportu) {
        this.statusRaportu = statusRaportu;
    }

    public boolean isCzyOpóźniony() {
        return czyOpóźniony;
    }

    public void setCzyOpóźniony(boolean czyOpóźniony) {
        this.czyOpóźniony = czyOpóźniony;
    }
}
