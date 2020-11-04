package algo.chapter13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph3 {
    Map<String, List<String>> g;
    List<List<String>> gr;
    Map<String, Integer> indexes = new HashMap<>();

    public Graph3(Map<String, List<String>> g) {
        this.g = g;
        int index = 0;
        for (String vert : g.keySet()) {
            indexes.put(vert, index++);
            for (String elem : g.get(vert)) {
                if (!indexes.containsKey(elem)) {
                    indexes.put(elem, index++);
                }
            }
        }
        System.out.println(indexes);
    }

    public void dfs() {
        int vertices = g.size();
        boolean[] visited = new boolean[vertices];
        for (Map.Entry<String, List<String>> entry : g.entrySet()) {
            String source = entry.getKey();
            if (!visited[indexes.get(source)]) {
                dfsUtil(source, visited);
            }
        }
    }

    private void dfsUtil(String source, boolean[] visited) {
        visited[indexes.get(source)] = true;
        System.out.print(source + " ");
        List<String> list = g.get(source);
        for (int i = 0; i < list.size(); i++) {
            String dest = list.get(i);
            if(!visited[indexes.get(dest)]) {
                dfsUtil(dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", List.of("A", "B", "C"));
        map.put("2", List.of("D", "E", "F"));
        map.put("3", List.of("M", "A", "E"));
        System.out.println(map.size());
        Graph3 g = new Graph3(map);
        g.dfs();
    }
}
