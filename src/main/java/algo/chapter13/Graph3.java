package algo.chapter13;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph3 {
    Map<String, List<String>> g;
    Set<String> used;

    public Graph3(Map<String, List<String>> g) {
        this.g = g;
        used = g.keySet();
    }
}
