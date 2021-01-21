package blanks.google.translate.learning.quiz;

public interface Quiz<T> {
    T getQuestion();

    boolean checkAnswer(T answer);

    T getRightAnswer();

    default int getRepeats() {
        return 1;
    }
}
