package examples.io;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.Date;

public class Experimental implements Serializable {
    private int n = 0;
    private transient int mb = 1;

    private void writeObject(ObjectOutputStream out)
        throws IOException {
        out.defaultWriteObject();
        out.writeInt(n);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        n = s.readInt();
    }

    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("test.txt")
        );
        Experimental e = new Experimental();
        out.writeObject(e);
    }
}
