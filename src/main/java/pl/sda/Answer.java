package pl.sda;

import java.util.HashMap;
import java.util.Map;

public enum Answer {
    YES("Tak"),
    RATHER_YES("Raczej tak"),
    NO("Nie"),
    RATHER_NO("Raczej nie");

    private final String displayText;
    private static final Map<String, Answer> map = new HashMap<>();
    // tablica["costam"] = Answer.NO
    // mapa.put("costam", Answer.NO);
    // "costam" => Answer.NO
    // tablica["costam"]
    // mapa.get("costam") -> Answer.NO


    Answer(String displayText){
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    static {
        for (Answer answer : Answer.values()) {
            map.put(answer.displayText, answer);
        }
        /*
          "Tak" -> YES
          "Nie" -> NO
          "Raczej tak" -> RATHER_YES
          "Raczej nie" -> RATHER_NO
         */
    }

    @Override
    public String toString(){
        return displayText;
    }

    public static Answer valueOfDisplayText(String displayText) {
        return map.get(capitalize(displayText));
    }

    private static String capitalize(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}