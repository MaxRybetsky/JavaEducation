package algo.chapter13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph2 {
    private List<Vertex>[] g;
    private List<Vertex> used = new ArrayList<>();
    private Queue<Integer> queue = new ArrayDeque<>();

    public Graph2(List<Vertex>[] g, List<Vertex> used) {
        this.g = g;
        this.used = used;
    }

    public void dfs(int v) {
        System.out.print(used.get(v));
        dfsRec(v);
    }

    private void dfsRec(int v) {
        used.get(v).visitVertex(true);
        for (Vertex vert : g[v]) {
            int vertID = vert.getId();
            if (!used.get(vertID).wasVisited()) {
                System.out.print(vert);
                dfsRec(vertID);
            }
        }
    }

    public void bfs(int s) {
        queue.add(s);
        used.get(s).visitVertex(true);
        System.out.print(used.get(s));
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < g[v].size(); i++) {
                Vertex vert = g[v].get(i);
                int to = vert.getId();
                if (!used.get(to).wasVisited()) {
                    used.get(to).visitVertex(true);
                    queue.add(to);
                    System.out.print(vert);
                }
            }
        }
        reset();
    }

    public void displayGraph() {
        for (int i = 0; i < g.length; i++) {
            System.out.print(i + ": ");
            for (Vertex val : g[i]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void displayVerts() {
        for (Vertex val : used) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private void reset() {
        used.forEach(e -> e.visitVertex(false));
    }

    public static void main(String[] args) {
        List<Vertex>[] g = new List[5];
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        g[A.getId()] = List.of(B, C, D);
        g[B.getId()] = List.of(A, D);
        g[C.getId()] = List.of(A, E);
        g[D.getId()] = List.of(A, B);
        g[E.getId()] = List.of(C);
        Graph2 gg = new Graph2(g, List.of(A, B, C, D, E));
        gg.dfs(3);
        System.out.println();
        gg.reset();
        gg.bfs(4);
        System.out.println();
    }
}
