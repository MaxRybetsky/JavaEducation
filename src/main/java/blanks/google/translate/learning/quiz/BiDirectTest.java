package blanks.google.translate.learning.quiz;

import java.util.Random;

public class BiDirectTest<T> {
    final private Test<T> test;

    final private Random random = new Random();

    private boolean isDirectTest = true;

    public BiDirectTest(T question, T answer) {
        this.test = new Test<>(question, answer);
    }

    public T getQuestion() {
        isDirectTest = random.nextInt(2) == 0;
        return isDirectTest ? test.getQuestion() : test.getAnswer();
    }

    public T getAnswer() {
        return isDirectTest ? test.getAnswer() : test.getQuestion();
    }

    public boolean checkAnswer(T answer) {
        return (answer != null)
                && (isDirectTest ? test.checkAnswer(answer)
                : answer.equals(test.getQuestion()));
    }

    @Override
    public String toString() {
        return "BiDirectTest{" +
                "\ntest=" + test +
                ", \nisDirectTest=" + isDirectTest + "\n}";
    }
}
