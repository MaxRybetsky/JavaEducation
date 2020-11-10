package examples.filesio;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileEx {
    public static void main(String[] args) throws IOException {
        match("glob:*.dat", "data");
        try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("123")))) {
            pw.println("sdfsdf");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void match(String glob, String location) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault()
                .getPathMatcher(glob);
        Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(pathMatcher.matches(file)) {
                    System.out.println(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
