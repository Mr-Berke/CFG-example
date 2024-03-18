import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] S = {"aa", "bX", "aXX"};
        String[] X = {"ab", "b"};

        Set<String> uretilen = new HashSet<>();
        Set<String> tekrar = new HashSet<>();

        for (String sIfadesi : S) {
            Set<String> kelimeler = new HashSet<>();
            kelimeler.add(sIfadesi);

            while (kelimeler.stream().anyMatch(kelime -> kelime.contains("X"))) {
                Set<String> yeniKelimeler = new HashSet<>();
                for (String kelime : kelimeler) {
                    for (String xKelime : X) {
                        String newKelime = kelime.replaceFirst("X", xKelime);
                        yeniKelimeler.add(newKelime);
                    }
                }
                kelimeler = yeniKelimeler;
            }

            uretilen.addAll(kelimeler);
        }

        for (String kelime : uretilen) {
            if (uretilen.stream().anyMatch(k -> !k.equals(kelime) && k.contains(kelime))) {
                tekrar.add(kelime);
            }
        }

        System.out.println("Üretilen Kelimeler:");
        uretilen.forEach(System.out::println);

        System.out.println("\nTekrar Eden Kelimeler:");
        tekrar.forEach(System.out::println);

}}