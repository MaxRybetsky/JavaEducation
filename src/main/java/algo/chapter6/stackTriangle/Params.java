package algo.chapter6.stackTriangle;

public class Params {
    private final int n;
    private final int returnAddress;

    public Params(int n, int returnAddress) {
        this.n = n;
        this.returnAddress = returnAddress;
    }

    public int getN() {
        return n;
    }

    public int getReturnAddress() {
        return returnAddress;
    }
}
