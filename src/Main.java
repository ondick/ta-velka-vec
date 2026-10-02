import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Vezen> platniVezni = new ArrayList<>();
        Validator validator = new Validator();

        try {
            File soubor = new File("vezni_testovaci_data.txt");
            Scanner scanner = new Scanner(soubor);

            int cisloRadku = 1;
            while (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                if (radek.trim().isEmpty()) {
                    cisloRadku++;
                    continue;
                }

                List<String> chyby = new ArrayList<>();
                boolean jePlatny = validator.validujRadek(radek, chyby, platniVezni);

                if (jePlatny) {
                    System.out.println("Řádek " + cisloRadku + ": validní");
                } else {
                    System.out.println("Řádek " + cisloRadku + ": nevalidní (" + String.join(", ", chyby) + ")");
                }

                cisloRadku++;
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Soubor se nepodařilo načíst.");
        }

        System.out.println("\n--- Seznam platných vězňů ---");
        for (Vezen v : platniVezni) {
            System.out.println(v.getPrijmeni() + " " + v.getRokNarozeni());
        }
    }
}