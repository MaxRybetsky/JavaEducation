package algo.chapter13.dfs;

import algo.chapter13.Graph;

public class DFSApp {
    public static void main(String[] args) {
        Graph gr = new Graph();
        gr.addVertex('A');
        gr.addVertex('B');
        gr.addVertex('C');
        gr.addVertex('D');
        gr.addVertex('E');
        gr.addEdge(0, 1);
        gr.addEdge(1, 2);
        gr.addEdge(0, 3);
        gr.addEdge(3, 4);
        System.out.println("Visits: ");
        gr.dfs();
        System.out.println();
    }
}
