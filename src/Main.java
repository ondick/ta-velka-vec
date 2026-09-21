import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String nazevSouboru = "vezni_testovaci_data.txt";
        String radek;
        BufferedReader br = new BufferedReader(new FileReader(nazevSouboru));
        //br.lines().forEach(System.out::println);

        while ((radek = br.readLine()) != null){
            System.out.println(radek);
        }




    }
}