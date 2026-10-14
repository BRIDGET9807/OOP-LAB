import java.util.*;
import java.util.stream.*;

/** Exercise 4: names above class average, sorted alphabetically (streams). */
record Pupil(String name, double score) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Pupil> pupils = List.of(
            new Pupil("Tariro", 78), new Pupil("Anesu", 91), new Pupil("Moyo", 55),
            new Pupil("Chenai", 82), new Pupil("Blessing", 60));

        double avg = pupils.stream().mapToDouble(Pupil::score).average().orElse(0);
        System.out.println("Average: " + avg);

        pupils.stream()
              .filter(p -> p.score() > avg)
              .map(Pupil::name)
              .sorted()
              .forEach(System.out::println);
    }
}
