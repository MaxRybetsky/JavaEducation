package algo.chapter13;

import java.util.ArrayList;
import java.util.List;

public class Graph2 {
    private List<Integer>[] g;
    private List<Integer> used = new ArrayList<>();

    public Graph2(List<Integer>[] g) {
        this.g = g;
        for (int i = 0; i < g.length; i++) {
            used.add(0);
        }
    }

    public void dfs(int v) {
        used.set(v, 1);
        for(int vert : g[v]) {
            if (used.get(vert) == 0) {
                dfs(vert);
            }
        }
    }

    public void displayGraph() {
        for (int i = 0; i < g.length; i++) {
            System.out.print(i + ": ");
            for (int val : g[i]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void displayVerts() {
        for(int val : used) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer>[] g = new List[5];
        g[0] = List.of(1,2,3);
        g[1] = List.of(0, 3);
        g[2] = List.of(0, 4);
        g[3] = List.of(0, 1);
        g[4] = List.of(2);
        Graph2 gg = new Graph2(g);
        gg.displayVerts();
        gg.dfs(0);
        gg.displayVerts();
    }
}
