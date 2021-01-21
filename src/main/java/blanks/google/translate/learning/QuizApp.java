package blanks.google.translate.learning;

import blanks.google.translate.learning.io.ConsoleInput;
import blanks.google.translate.learning.io.ConsoleOutput;
import blanks.google.translate.learning.io.Input;
import blanks.google.translate.learning.io.Output;
import blanks.google.translate.learning.quiz.Quiz;
import blanks.google.translate.learning.quiz.QuizUnit;

import java.util.*;
import java.util.stream.Collectors;

public class QuizApp {
    private final Input input;
    private final Output output;
    private List<WordEn> words;

    private final int NUMBER_OF_ADDITIONAL_ATTEMPTS = 5;

    public QuizApp(Input input, Output output, List<WordEn> words) {
        this.input = input;
        this.output = output;
        this.words = words;
    }

    public void quizRun() {
        if(words.size() == 0) {
            output.out("No words");
            return;
        }
        List<Quiz<String>> quizzes = words.stream()
                .map(QuizUnit::new)
                .collect(Collectors.toList());
        int n = quizzes.size() * (quizzes.stream()
                .findFirst()
                .get()
                .getRepeats()) + NUMBER_OF_ADDITIONAL_ATTEMPTS;
        for (int i = 0; i < n; i++) {
            Quiz<String> q = getRandom(new Random(), quizzes);
            output.out(q.getQuestion());
            String answer = input.in();
            if (q.checkAnswer(answer)) {
                output.out("That's right");
                if (q.getRepeats() == 0) {
                    quizzes.remove(q);
                }
            } else {
                output.out("No: " + q.getRightAnswer());
            }
        }
    }

    public Quiz<String> getRandom(Random random, List<Quiz<String>> quizzes) {
        return quizzes.get(random.nextInt(quizzes.size()));
    }


    static String[][] ws = {
            {"hi", "привет"},
            {"be", "быть", "являться"},
            {"do", "делать"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordEn word1 = new WordEn();
        WordEn word2 = new WordEn();
        WordEn word3 = new WordEn();
        List<WordEn> words = initWords(word1, word2, word3);
        QuizApp quizApp = new QuizApp(new ConsoleInput(), new ConsoleOutput(), words);
        quizApp.quizRun();
    }

    public static List<WordEn> initWords(WordEn... words) {
        List<WordEn> res = new ArrayList<>();
        for (int i = 0; i < ws.length; i++) {
            words[i].setValue(ws[i][0]);
            List<String> trs = Arrays.stream(ws[i]).skip(1).collect(Collectors.toList());
            words[i].setTranslations(trs);
            res.add(words[i]);
        }
        return res;
    }
}
