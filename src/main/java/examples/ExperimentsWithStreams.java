package examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExperimentsWithStreams {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", List.of("A", "B", "C"));
        List<String> m = new ArrayList<>();
        m.add("D");
        m.add("E");
        m.add("F");
        map.put("2", m);
        map.put("3", List.of("M", "A", "E"));
        map.get("2").add("sdf");
        map.put(null, List.of("a"));
        System.out.println(map);
        List<List<String>> lst = new ArrayList<>();
        System.out.println(lst.get(0));
        System.out.println(lst);
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
