/** Exercise 1: enum with a switch. */

enum Level { LOW, MEDIUM, HIGH }

public class LevelAdvice {
    static void advise(Level level) {
        switch (level) {
            case LOW    -> System.out.println("LOW: you have plenty of headroom.");
            case MEDIUM -> System.out.println("MEDIUM: keep an eye on it.");
            case HIGH   -> System.out.println("HIGH: take action now!");
        }
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) advise(l);
    }
}

