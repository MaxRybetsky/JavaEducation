package examples.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VisitApp {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\projects\\JavaEducation"), new FileVisitClass());
    }
}
