package examples.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class Graph3 {
    private final Map<Vertex, List<Vertex>> graph = new HashMap<>();
    private final Map<Vertex, Boolean> used = new HashMap<>();
    private final Map<Vertex, Boolean> users = new HashMap<>();
    private List<String> emails = new ArrayList<>();

    public Map<String, List<String>> handler(Map<String, List<String>> data) {
        fillData(data);
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<Vertex, Boolean> user : users.entrySet()) {
            if (!user.getValue()) {
                Vertex uKey = user.getKey();
                dfs(uKey);
                result.put(uKey.getValue(), emails);
                emails = new ArrayList<>();
            }
        }
        return result;
    }

    private void fillData(Map<String, List<String>> userData) {
        for (Map.Entry<String, List<String>> entry : userData.entrySet()) {
            Vertex userKey = new Vertex(entry.getKey());
            used.put(userKey, false);
            users.put(userKey, false);
            List<Vertex> vertexes = entry.getValue().stream()
                    .map(e -> {
                        Vertex vertex = new Vertex(e, false);
                        used.put(vertex, false);
                        if (!graph.containsKey(vertex)) {
                            graph.put(vertex, new ArrayList<>());
                        }
                        graph.get(vertex).add(userKey);
                        return vertex;
                    })
                    .collect(Collectors.toList());
            graph.put(userKey, vertexes);
        }
    }

    private void dfs(Vertex start) {
        used.replace(start, true);
        for (Vertex v : graph.get(start)) {
            if (!used.get(v)) {
                if (v.isUser()) {
                    users.replace(v, true);
                } else {
                    emails.add(v.getValue());
                }
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", List.of("A", "B", "C"));
        map.put("2", List.of("D", "E", "F"));
        map.put("3", List.of("M", "A", "E"));
        map.put("4", List.of("S", "F", "G"));
        map.put("5", List.of("p", "v", "a"));
        map.put("6", List.of("k", "v", "u"));
        Graph3 g = new Graph3();
        System.out.println(g.handler(map));
    }
}

class Vertex {
    private final String value;
    private final boolean isUser;

    public Vertex(String value) {
        this(value, true);
    }

    public Vertex(String value, boolean isUser) {
        this.value = value;
        this.isUser = isUser;
    }

    public String getValue() {
        return value;
    }

    public boolean isUser() {
        return isUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return isUser == vertex.isUser
                && Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isUser);
    }

    @Override
    public String toString() {
        return value;
    }
}
