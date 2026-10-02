import java.time.LocalDate;

public class Vezen {
    private String jmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;
    private String telefon;
    private String email;
    private String mesto;
    private String ulice;
    private int cisloPopisne;
    private String psc;

    public Vezen(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefon, String email, String mesto, String ulice, int cisloPopisne, String psc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.ulice = ulice;
        this.cisloPopisne = cisloPopisne;
        this.psc = psc;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRokNarozeni() {
        return datumNarozeni.getYear();
    }
}