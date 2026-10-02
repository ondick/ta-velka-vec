import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Pattern pJmeno = Pattern.compile("^[A-ZÁŽ][a-zá-ž]+ [A-ZÁ-Ž][a-zá-ž]+$");
    private Pattern pTelefon = Pattern.compile("^\\+420 \\d{3} \\d{3} \\d{3}$");
    private Pattern pEmail = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private Pattern pMestoUlice = Pattern.compile("^[A-ZÁ-Ž][A-ZÁ-Ža-zá-ž ]*$");
    private Pattern pCisloPopisne = Pattern.compile("^[1-9]\\d*$");
    private Pattern pPsc = Pattern.compile("^\\d{3} \\d{2}$");

    public boolean validujRadek(String radek, List<String> chyby, List<Vezen> platniVezni) {
        String[] casti = radek.split(";", -1);

        if (casti.length != 8) {
            chyby.add("neplatný počet údajů na řádku");
            return false;
        }

        String jmenoPrijmeni = casti[0].trim();
        String datumStr = casti[1].trim();
        String telefon = casti[2].trim();
        String email = casti[3].trim();
        String mesto = casti[4].trim();
        String ulice = casti[5].trim();
        String cisloPopisneStr = casti[6].trim();
        String psc = casti[7].trim();

        boolean ok = true;

        Matcher mJmeno = pJmeno.matcher(jmenoPrijmeni);
        if (!mJmeno.matches()) {
            chyby.add("neplatné jméno");
            ok = false;
        }

        LocalDate datum = null;
        try {
            String[] d = datumStr.split("\\.");
            if (d.length == 3) {
                int den = Integer.parseInt(d[0]);
                int mesic = Integer.parseInt(d[1]);
                int rok = Integer.parseInt(d[2]);
                datum = LocalDate.of(rok, mesic, den);
            } else {
                chyby.add("neplatné datum");
                ok = false;
            }
        } catch (Exception e) {
            chyby.add("neplatné datum");
            ok = false;
        }

        if (!pTelefon.matcher(telefon).matches()) {
            chyby.add("neplatný telefon");
            ok = false;
        }

        if (!pEmail.matcher(email).matches()) {
            chyby.add("neplatný e-mail");
            ok = false;
        }

        if (!pMestoUlice.matcher(mesto).matches()) {
            chyby.add("neplatné město");
            ok = false;
        }

        if (!pMestoUlice.matcher(ulice).matches()) {
            chyby.add("neplatná ulice");
            ok = false;
        }

        if (!pCisloPopisne.matcher(cisloPopisneStr).matches()) {
            chyby.add("neplatné číslo popisné");
            ok = false;
        }

        if (!pPsc.matcher(psc).matches()) {
            chyby.add("neplatné PSČ");
            ok = false;
        }

        if (ok) {
            String[] jm = jmenoPrijmeni.split(" ");
            int cp = Integer.parseInt(cisloPopisneStr);
            platniVezni.add(new Vezen(jm[0], jm[1], datum, telefon, email, mesto, ulice, cp, psc));
        }

        return ok;
    }
}