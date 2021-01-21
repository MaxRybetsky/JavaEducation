package blanks.google.translate.learning;

import java.util.List;

public class WordEn {
    private Integer id;
    private String value;
    private Integer stage;
    private List<String> translations;

    private Integer stageStep;

    private final Integer MAX_STAGE = 100;
    private final Integer MIN_STAGE = 0;

    public WordEn() {
        id = 0;
        stage = 0;
        stageStep = 20;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public void upStage() {
        if (stage < MAX_STAGE) {
            stage += stageStep;
        }
    }

    public void downStage() {
        if (stage > MIN_STAGE) {
            stage -= stageStep;
        }
    }

    @Override
    public String toString() {
        return "WordEn{" +
                "\nvalue='" + value + '\'' +
                ", \ntranslations=" + translations + ",\n" +
                " stage=" + stage +
                "\n}";
    }
}
