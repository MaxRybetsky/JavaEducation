package algo.chapter13;

public class Vertex {
    private char label;
    private boolean wasVisited;
    private final int id;
    private static int count = 0;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
        id = count++;
    }

    public char getLabel() {
        return label;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void visitVertex(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return label + "";
    }
}
