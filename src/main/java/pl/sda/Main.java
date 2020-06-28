package pl.sda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;


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


public class Main {
    private static final String ANSWER_FILE_NAME = "Answers.txt";

    public static void main(String[] args) {
        String name;
        String surname;


        Scanner scanner = new Scanner(System.in);
        printMenu();
        String modeChoice = scanner.nextLine();
        if ("1".equals(modeChoice)) {
            Answer pastaAnswer;
            Answer weatherAnswer;
            Answer fogAnswer;
            StringBuilder answerStringBuilder = new StringBuilder();
            System.out.println("Imie:");
            name = scanner.nextLine();
            answerStringBuilder.append(name);
            answerStringBuilder.append(";");
            System.out.println("Nazwisko:");
            surname = scanner.nextLine();
            answerStringBuilder.append(surname);
            answerStringBuilder.append(";");
            System.out.println("Czy makaron jest Twoim ulubionym daniem?");
            printPossibleAnswers();
            pastaAnswer = Answer.valueOfDisplayText(scanner.nextLine());
            if (pastaAnswer == null) {
                System.err.println("Your answer is not valid.");
                System.exit(1);
            }
            answerStringBuilder.append(pastaAnswer);
            answerStringBuilder.append(";");
            System.out.println("Czy pogoda ostatnio była ładna?");
            printPossibleAnswers();
            weatherAnswer = Answer.valueOfDisplayText(scanner.nextLine());
            if (weatherAnswer == null) {
                System.err.println("Your answer is not valid.");
                System.exit(1);
            }
            answerStringBuilder.append(weatherAnswer);
            answerStringBuilder.append(";");
            System.out.println("Czy ostry jest cień mgły?");
            printPossibleAnswers();
            fogAnswer = Answer.valueOfDisplayText(scanner.nextLine());
            if (fogAnswer == null) {
                System.err.println("Your answer is not valid.");
                System.exit(1);
            }
            answerStringBuilder.append(fogAnswer);
            answerStringBuilder.append(System.lineSeparator());

            try {
                Files.writeString(Paths.get(ANSWER_FILE_NAME), answerStringBuilder.toString(),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.err.println("No such directory.");
            }
        } else {
            try {
                List<String> resultList = Files.readAllLines(Paths.get(ANSWER_FILE_NAME));
                System.out.println("Results:");
                for (String record : resultList) {
                    String[] answers = record.split(";");
                    name = answers[0];
                    surname = answers[1];
                    Answer pastaAnswer = Answer.valueOfDisplayText(answers[2]);
                    Answer weatherAnswer = Answer.valueOfDisplayText(answers[3]);
                    Answer fogAnswer = Answer.valueOfDisplayText(answers[4]);
                    //System.out.println(String.format("Imie %s nazwisko %s 1.%s 2.%s 3.%s", name, surname, pastaAnswer, weatherAnswer, fogAnswer));
                    String surveyLine = new StringBuilder()
                            .append("Imie ").append(name)
                            .append(" nazwisko ")
                            .append(surname)
                            .append(" 1.")
                            .append(pastaAnswer)
                            .append(" 2.")
                            .append(weatherAnswer)
                            .append(" 3.")
                            .append(fogAnswer)
                            .toString();
                    System.out.println(surveyLine);
                }
            } catch (IOException e) {
                System.err.println("No such a directory.");
            }
        }

    }

    private static void printPossibleAnswers() {
        for (Answer answer : Answer.values()) {
            System.out.println(String.format("%s. %s", answer.ordinal() + 1, answer));
        }
    }

    private static void printMenu() {
        System.out.println("1. Tryb ankiety");
        System.out.println("2. Tryb wyników");
    }
}