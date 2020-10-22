package examples.io;

import java.io.*;

public class Exp {
    public static void main(String[] args) throws IOException {
        DataOutput out = new DataOutputStream(new FileOutputStream("output.txt"));
        out.writeInt(12);
        out.writeInt(12);
        DataInput in = new DataInputStream(new FileInputStream("output.txt"));
        System.out.println(in.readLong());
    }
}
