package pl.sda;

import java.util.Scanner;

public class Main {
    /* Cel - napisanie prostej ankiety z zapisem do pliku.
     * Pytania są zawsze takie same (takie jak przygotowane w main), odpowiedź to może być tylko: tak, nie, raczej nie lub raczej tak
     * 1. Utwórz enuma Answer z wartościami YES, RATHER_YES, RATHER_NO, NO
     * 2. Po każdym pytaniu wypisz możliwe odpowiedzi (na podstawie możliwych wartości enuma) i przeczytaj odpowiedź
     * 3. Przeczytaną odpowiedź zamień na odpowiednią wartość enuma, zapisz do zmiennej.
     * Poprawną odpowiedzią jest YES, RATHER_YES, RATHER_NO, NO (jak też wynika z pkt 2). - porozmawiamy później jak to zmienić
     * 4. Wartości enuma złącz w jedną linię w ten sposób i zapisz do zmiennej Stringowej:
     * answer1 + ; + answer2 + ; + answer3 (to jest pseudokod, nie tak to bedzie dokladnie wygladalo)
     * 5. Zapisz zmienną utworzoną w kroku wyżej do pliku, nie masz go nadpisywać tylko do niego dopisywać, żeby poprzednie wyniki nie wyparowały :)
     * 6. Sprawdź zawartość pliku
     * 7. Zaimplementuj tryb odczytu wyników, jeśli użytkownik wpisze "2" cały plik powinien zostać odczytany (szczegóły niżej)
     * 8. W pętli:
     *    a. Czytaj plik linijka po linijce (albo przeczytaj od razu cały, a jego zawartość trzymaj w liście, jak wolisz)
     *    b. Splituj każdą linijkę po seperatorze (czyli ";"), zapisz do zmiennej (każdą komórkę do osobnej zmiennej)
     *    c. Każdą z komórek z powyższej tablicy zamień na enuma, w osobnych linijkach, podpowiedź coś w stylu:
     *    "|" + )3llec(fOeulav.rewsnA + "|" + )2llec(fOeulav.rewsnA +  "|" + )1llec(fOeulav.rewsnA
     *    d. Wyświetl przeczytaną linijkę
     * 9. Sprawdź jak wygląda wyświetlony tekst z trybu wyników, nie najczytelniej :(
     * 10. W enumie Answer utwórz pole String i nazwij je displayText, dodaj stosowny konstruktor i getter
     * 11. W konstruktorze każdej wartości enuma musisz teraz zdefiniować displayText(dla YES niech to będzie tak, dla NO nie itd.)
     * 12. Wróć do kodu z punktu 8c. i zamiast łączyć same wartości enumów użyj na nich getDisplayText()
     * 13. Sprawdź jak działa aplikacja
     * 14. Nadpisz metodę toString() enuma - zwracaj w niej displayText i usuń wywołanie getDisplayText() z punktu 8c
     * Uruchom aplikację.
     * Co się stało? Czy są wady takiego podejścia?
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        String modeChoice = scanner.nextLine();
        if ("1".equals(modeChoice)) {
            System.out.println("Czy makaron jest Twoim ulubionym daniem?");
            System.out.println("Czy pogoda ostatnio była ładna?");
            System.out.println("Czy ostry jest cień mgły?");
        } else {
            //tutaj tryb wynikow
        }

    }

    private static void printMenu() {
        System.out.println("1. Tryb ankiety");
        System.out.println("2. Tryb wyników");
    }
}
