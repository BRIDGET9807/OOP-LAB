import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/** Exercise 3: count lines, words and characters (like the Unix wc command). */
public class FileStats {
    public static void main(String[] args) throws IOException {
        Path file = Path.of(args.length > 0 ? args[0] : "sample.txt");
        if (!Files.exists(file)) {
            Files.writeString(file, "Java is fun.\nObjects everywhere!\nKeep practising.\n");
            System.out.println("(created sample " + file + ")");
        }
        List<String> lines = Files.readAllLines(file);
        long words = 0, chars = 0;
        for (String line : lines) {
            chars += line.length();
            if (!line.isBlank()) words += line.trim().split("\\s+").length;
        }
        System.out.println("Lines: " + lines.size());
        System.out.println("Words: " + words);
        System.out.println("Characters (excluding newlines): " + chars);
    }
}

