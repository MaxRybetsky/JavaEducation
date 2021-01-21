package blanks.google.translate.learning.quiz;

public class Test<T> {
    private final T question;
    private final T answer;

    public Test(T question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public T getQuestion() {
        return question;
    }

    public T getAnswer() {
        return answer;
    }

    public boolean checkAnswer(T answer) {
        return answer != null
                && answer.equals(this.answer);
    }

    @Override
    public String toString() {
        return "Test{" +
                "\nquestion=" + question +
                ", \nanswer=" + answer + "\n}";
    }
}
