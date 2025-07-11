package pl.edu.pwr.abis.service;

public class OcenaNotFoundException extends RuntimeException {
    public OcenaNotFoundException(Long ocenaId) {
        super("Ocena o ID " + ocenaId + " nie istnieje");
    }
}
