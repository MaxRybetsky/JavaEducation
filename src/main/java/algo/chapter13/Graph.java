package algo.chapter13;

import algo.chapter4.queue.Queue;
import algo.chapter4.stack.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int adjMat[][];
    private int nVerts;
    private Stack stack;
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        stack = new Stack(MAX_VERTS);
        queue = new Queue(MAX_VERTS);
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public void dfs() {
        vertexList[0].visitVertex(true);
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex((int) stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].visitVertex(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        reset();
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited()) {
                return i;
            }
        }
        return -1;
    }

    public void bfs() {
        vertexList[0].visitVertex(true);
        displayVertex(0);
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = (int) queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].visitVertex(true);
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        reset();
    }

    public void mst() {
        vertexList[0].visitVertex(true);
        stack.push(0);
        while (!stack.isEmpty()) {
            int curV = (int) stack.peek();
            int v = getAdjUnvisitedVertex(curV);
            if(v == -1) {
                stack.pop();
            } else {
                vertexList[v].visitVertex(true);
                stack.push(v);
                displayVertex(curV);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        reset();
    }

    private void reset() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].visitVertex(false);
        }
    }
}
