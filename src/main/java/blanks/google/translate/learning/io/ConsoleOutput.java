package blanks.google.translate.learning.io;

public class ConsoleOutput implements Output {
    @Override
    public void out(String text) {
        System.out.println(text);
    }
}
