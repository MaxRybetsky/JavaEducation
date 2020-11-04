package examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExperimentsWithStreams {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", List.of("A", "B", "C"));
        map.put("2", List.of("D", "E", "F"));
        map.put("3", List.of("M", "A", "E"));

    }
}

class Vertex {
    private final String value;
    private final int id;
    private static int count = 0;
    private boolean wasVisited;
    private final boolean isUser;

    public Vertex(String value, boolean isUser) {
        this.value = value;
        this.wasVisited = true;
        this.isUser = isUser;
        this.id = count++;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
