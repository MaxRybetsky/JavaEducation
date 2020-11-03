package algo.chapter13.mst;

import algo.chapter13.Graph;

public class MSTApp {
    public static void main(String[] args) {
        Graph gr = new Graph();
        gr.addVertex('A');
        gr.addVertex('B');
        gr.addVertex('C');
        gr.addVertex('D');
        gr.addVertex('E');
        gr.addEdge(0, 1);
        gr.addEdge(0, 2);
        gr.addEdge(0, 3);
        gr.addEdge(0,4);
        gr.addEdge(1,2);
        gr.addEdge(1,3);
        gr.addEdge(1,4);
        gr.addEdge(2,3);
        gr.addEdge(2,4);
        gr.addEdge(3,4);
        System.out.println("Minimum spanning tree: ");
        gr.mst();
        System.out.println();
    }
}
