import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    List<String> strings = new ArrayList<String>();
    public static void main(String[] args) {
        Main main = new Main();
        main.loadStrings(
                "Andres", "Alejandro", "Cristian", "Beatriz", "Benjamin", "Hector", "Jorge", "Manuel", "Ximena", "Karen");

        var sortLengtClaseAnonima = main.sortLengtClaseAnonima();
        System.out.println("Length");
        System.out.println("Clase Anonima");
        main.showList(sortLengtClaseAnonima);

        var sortLengthByLamda = main.sortLengtLamda();
        System.out.println("Expresion Lambda");
        main.showList(sortLengthByLamda);

        var sortLengtReferencia = main.sortLengtReferencia();
        System.out.println("Metodo de Referencia");
        main.showList(sortLengtReferencia);

        var sortAlfabeticoClaseAnonima = main.sortAlfabeticoClaseAnonima();
        System.out.println("Alfabetica");
        System.out.println("Clase Anonima");
        main.showList(sortAlfabeticoClaseAnonima);

        var sortAlfabeticoLamda =main.sortAlfabeticoLamda();
        System.out.println("Expresio Lambda");
        main.showList(sortAlfabeticoLamda);

        var sortAlfabeticoReferencia =main.sortAlfabeticoReferencia();
        System.out.println("Metodo de Referencia");
        main.showList(sortAlfabeticoReferencia);
    }
    public void loadStrings(String... strings) {
        for (var string : strings) this.strings.add(string);
    }
    public List<String> sortLengtClaseAnonima() {
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        return strings;
    }
    public List<String> sortLengtLamda() {
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.length() - str2.length());
        return strings;
    }
    public List<String> sortLengtReferencia() {
        List<String> strings = this.strings;
        SortLengt sortLengt = new SortLengt();
        strings.sort(sortLengt::compare);
        return strings;
    }
    class SortLengt implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().length() - o2.toString().length();
        }
    }
    public List<String> sortAlfabeticoClaseAnonima() {
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }
    public List<String> sortAlfabeticoLamda() {
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }
    public List<String> sortAlfabeticoReferencia() {
        List<String> strings = this.strings;
        SortAlphaetic sortAlphabetic = new SortAlphaetic();
        Collections.sort(strings, sortAlphabetic::compare);
        return strings;
    }
    class SortAlphaetic implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().compareToIgnoreCase(o2.toString());
        }
    }
    public void showList(List<String> strings){
        strings.forEach(System.out::println);
    }
}