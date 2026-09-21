public class Vezen {
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private String city;
    private String ulice;
    private int cisloPopisny;
    private int psc;

    public Vezen(String name, String dateOfBirth, String phoneNumber, String email, String city, String ulice, int cisloPopisny, int psc) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.ulice = ulice;
        this.cisloPopisny = cisloPopisny;
        this.psc = psc;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getUlice() {
        return ulice;
    }

    public int getCisloPopisny() {
        return cisloPopisny;
    }

    public int getPsc() {
        return psc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public void setCisloPopisny(int cisloPopisny) {
        this.cisloPopisny = cisloPopisny;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }
}
