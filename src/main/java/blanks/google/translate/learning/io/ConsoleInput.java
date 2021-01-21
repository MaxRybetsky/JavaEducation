package blanks.google.translate.learning.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String in() {
        return scanner.nextLine();
    }
}
