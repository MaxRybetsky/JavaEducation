package examples;

import java.io.Console;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            char[] pass = console.readPassword();
            for (char c : pass) {
                System.out.print(c);
            }
            Arrays.fill(pass, ' ');
            for (char c : pass) {
                System.out.print(c);
            }
        }
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        Path p = Paths.get("C:\\projects\\JavaEducation");
        File f = p.toFile();
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(Arrays.toString(f.list()));

    }
}
