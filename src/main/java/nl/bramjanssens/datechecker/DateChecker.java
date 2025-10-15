package nl.bramjanssens.datechecker;

public class DateChecker {
    public static String isItFriday(String today) {
        if ("Friday".equals(today)) return "TGIF";
        else return "Nope";
    }
}
