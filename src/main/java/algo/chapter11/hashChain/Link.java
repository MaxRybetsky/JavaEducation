package algo.chapter11.hashChain;

public class Link {
    private int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
    }

    public int getiData() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }
}
