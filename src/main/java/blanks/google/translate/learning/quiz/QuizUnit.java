package blanks.google.translate.learning.quiz;

import blanks.google.translate.learning.WordEn;

public class QuizUnit implements Quiz<String> {
    private WordEn word;
    private BiDirectTest<String> test;
    private int repeats;

    public QuizUnit(WordEn word) {
        this(word, 5);
    }

    public QuizUnit(WordEn word, int repeats) {
        this.word = word;
        this.repeats = repeats;
        this.test = new BiDirectTest<>(word.getValue(),
                word.getTranslations()
                        .stream()
                        .findAny()
                        .orElse(null));
    }

    @Override
    public String getQuestion() {
        return test.getQuestion();
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (test.checkAnswer(answer)) {
            if (--repeats == 0) {
                word.upStage();
            }
            return true;
        }
        return false;
    }

    @Override
    public String getRightAnswer() {
        return test.getAnswer();
    }

    @Override
    public int getRepeats() {
        return repeats;
    }

    @Override
    public String toString() {
        return "QuizUnit{\n" +
                "word=" + word +
                "\n, test=" + test +
                ", \nrepeats=" + repeats + "\n}";
    }
}
