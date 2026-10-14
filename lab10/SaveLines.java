

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/** Exercise 1: save five typed lines to a file, then read them back. */
public class SaveLines {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }
        Path file = Path.of("typed-lines.txt");
        Files.write(file, lines);
        System.out.println("--- Read back ---");
        Files.readAllLines(file).forEach(System.out::println);
    }
}
